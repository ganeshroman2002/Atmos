import pandas as pd
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.svm import SVC
from sklearn.pipeline import make_pipeline
import joblib
import os

# Define the base directory of the project
BASE_DIR = os.path.dirname(os.path.abspath(__file__))

def train_router():
    """
    Trains a model to classify queries and route them to the correct expert.
    """
    dataset_path = os.path.join(BASE_DIR, "dataset.csv")
    model_path = os.path.join(BASE_DIR, "router_model.joblib")

    # Load the dataset
    df = pd.read_csv(dataset_path)

    # Create a pipeline with a TF-IDF vectorizer and an SVC classifier
    pipeline = make_pipeline(
        TfidfVectorizer(),
        SVC(kernel='linear', probability=True) # Using SVC for simplicity
    )

    # Train the model
    pipeline.fit(df['query'], df['expert'])

    # Save the trained model
    joblib.dump(pipeline, model_path)
    print(f"Router model trained and saved successfully at {model_path}!")

if __name__ == "__main__":
    train_router()
