def route_query(query):
    """
    Routes a query to the appropriate expert.
    """
    query = query.lower()
    if any(greeting in query for greeting in ["hello", "hi", "hey"]):
        return "greeting_expert"
    elif "what is" in query:
        return "math_expert"
    elif any(farewell in query for farewell in ["bye", "goodbye", "see you"]):
        return "farewell_expert"
    return None
