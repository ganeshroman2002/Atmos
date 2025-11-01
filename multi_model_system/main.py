import sys
import os

# Define the base directory of the project
BASE_DIR = os.path.dirname(os.path.abspath(__file__))

# Add the project root to the Python path
sys.path.append(BASE_DIR)

from router.main import route_query
from greeting_expert.main import handle_greeting
from math_expert.main import handle_math
from farewell_expert.main import handle_farewell

def main():
    """
    Main application loop.
    """
    print("Welcome to the multi-model AI system!")
    print("You can say 'hello', ask a math problem like 'what is 2+2?', or type 'exit' to quit.")

    unclassified_queries_path = os.path.join(BASE_DIR, "unclassified_queries.txt")

    while True:
        query = input("> ")
        if query.lower() == "exit":
            break

        expert, confidence = route_query(query)

        if expert == "greeting_expert":
            response = handle_greeting(query)
        elif expert == "math_expert":
            response = handle_math(query)
        elif expert == "farewell_expert":
            response = handle_farewell(query)
        else: # Unclassified
            response = "Sorry, I don't have an expert for that."
            with open(unclassified_queries_path, "a") as f:
                f.write(query + "\n")

        print(response)

if __name__ == "__main__":
    main()
