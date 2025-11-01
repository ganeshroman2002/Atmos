def handle_math(query):
    """
    Handles a math problem and returns the answer.
    """
    if "what is" in query.lower():
        query = query.lower().replace("what is", "").strip()
        try:
            # A simple way to evaluate math expressions.
            # NOTE: In a real-world scenario, this is not safe!
            # We would use a proper math expression parser.
            return str(eval(query))
        except:
            return "Sorry, I can't solve that math problem."
    return None
