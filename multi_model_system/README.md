# Multi-Model AI System

This project is a proof-of-concept for a multi-model AI system that uses a combination of supervised and unsupervised learning.

## Setup

1.  **Create a virtual environment (optional but recommended):**
    ```bash
    python -m venv venv
    source venv/bin/activate  # On Windows, use `venv\Scripts\activate`
    ```

2.  **Install the dependencies:**
    ```bash
    pip install -r requirements.txt
    ```

## Usage

### Running the Main Application

To start the interactive multi-model system, run:

```bash
python main.py
```

You can then type queries like "hello", "what is 10 + 5?", or "goodbye".

### Training the Router Model

If you modify the `dataset.csv`, you will need to retrain the router model. To do this, run:

```bash
python train_router.py
```

This will create an updated `router_model.joblib` file.

### Analyzing Unclassified Queries

As you use the system, any queries that the router cannot classify with high confidence are saved to `unclassified_queries.txt`. To analyze these queries and find potential new expert categories, run:

```bash
python analyze_queries.py
```
