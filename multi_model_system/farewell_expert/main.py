def handle_farewell(query):
    """
    Handles a farewell and returns an appropriate response.
    """
    farewells = ["bye", "goodbye", "see you"]
    if any(farewell in query.lower() for farewell in farewells):
        return "Goodbye!"
    return None
