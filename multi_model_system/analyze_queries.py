import pandas as pd
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.cluster import KMeans

def analyze_queries():
    """
    Analyzes unclassified queries to find new patterns.
    """
    try:
        # Load the unclassified queries
        with open("multi_model_system/unclassified_queries.txt", "r") as f:
            queries = [line.strip() for line in f.readlines()]
    except FileNotFoundError:
        print("No unclassified queries to analyze yet.")
        return

    if not queries:
        print("No unclassified queries to analyze.")
        return

    # Vectorize the queries
    vectorizer = TfidfVectorizer(stop_words='english')
    X = vectorizer.fit_transform(queries)

    # Cluster the queries using KMeans
    # We'll look for 3 new potential expert categories, but this could be tuned
    num_clusters = 3
    kmeans = KMeans(n_clusters=num_clusters, random_state=42, n_init=10)
    kmeans.fit(X)

    # Print the results
    print("Found new query clusters:")
    for i in range(num_clusters):
        print(f"\nCluster {i+1}:")
        cluster_queries = [queries[j] for j, label in enumerate(kmeans.labels_) if label == i]
        for q in cluster_queries:
            print(f"  - {q}")

if __name__ == "__main__":
    analyze_queries()
