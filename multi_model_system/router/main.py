import joblib
import os

# Get the absolute path to the model file
model_path = os.path.join(os.path.dirname(os.path.abspath(__file__)), '..', 'router_model.joblib')

# Load the trained model
model = joblib.load(model_path)
CONFIDENCE_THRESHOLD = 0.7 # We'll use this later for the unsupervised part

def route_query(query):
    """
    Routes a query to the appropriate expert using the trained ML model.
    Returns the expert name and the confidence score.
    """
    # The model expects an iterable (like a list), so we pass the query in a list
    prediction = model.predict([query])
    probabilities = model.predict_proba([query])

    # Get the probability of the predicted class
    confidence = probabilities.max()

    if confidence >= CONFIDENCE_THRESHOLD:
        # Return the first (and only) prediction
        return prediction[0], confidence
    else:
        # If confidence is too low, we can't classify it
        return "unclassified", confidence
