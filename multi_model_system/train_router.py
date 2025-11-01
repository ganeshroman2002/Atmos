import pandas as pd
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.svm import SVC
from sklearn.pipeline import make_pipeline
import joblib

def train_router():
    """
    Trains a model to classify queries and route them to the correct expert.
    """
    # Load the dataset
    df = pd.read_csv("multi_model_system/dataset.csv")

    # Create a pipeline with a TF-IDF vectorizer and an SVC classifier
    pipeline = make_pipeline(
        TfidfVectorizer(),
        SVC(kernel='linear', probability=True) # Using SVC for simplicity
    )

    # Train the model
    pipeline.fit(df['query'], df['expert'])

    # Save the trained model
    joblib.dump(pipeline, "multi_model_system/router_model.joblib")
    print("Router model trained and saved successfully!")

if __name__ == "__main__":
    train_router()
