# FieldForceConnect QA Machine Test Submission

Machine-test submission covering:
- Manual testing test cases, field validation and observations
- Java + Maven + Selenium + TestNG automation
- Postman API collection for valid/invalid login and Add Customer setup

Application: https://test.fieldforceconnect.com/

## Automation
See `automation/`.

## Manual Testing
See `MANUAL_TESTING.md` and the CSV files.

## Postman
Import `postman/FieldForceConnect.postman_collection.json` and set the environment variables described in `postman/README.md`.

## Important
Credentials and tokens are not committed. Replace placeholders locally before execution.

The confirmed login API from the candidate run is `POST {{base_url}}/api/account/authenticate`.
The Add Customer endpoint is intentionally kept as a variable until it is identified from the application's network request; no endpoint is fabricated.
