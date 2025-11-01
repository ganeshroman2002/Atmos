import sys
import os

# Add the project root to the Python path
sys.path.append(os.path.dirname(os.path.abspath(__file__)))

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

    while True:
        query = input("> ")
        if query.lower() == "exit":
            break

        expert = route_query(query)

        if expert == "greeting_expert":
            response = handle_greeting(query)
        elif expert == "math_expert":
            response = handle_math(query)
        elif expert == "farewell_expert":
            response = handle_farewell(query)
        else:
            response = "Sorry, I don't have an expert for that."

        print(response)

if __name__ == "__main__":
    main()
