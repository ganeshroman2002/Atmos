def handle_greeting(query):
    """
    Handles a greeting and returns an appropriate response.
    """
    greetings = ["hello", "hi", "hey"]
    if any(greeting in query.lower() for greeting in greetings):
        return "Hello there!"
    return None
