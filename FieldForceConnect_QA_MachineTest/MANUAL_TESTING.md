# Manual Testing – FieldForceConnect

## Test Cases

| TC ID | Module | Test Scenario | Precondition | Test Steps | Test Data | Expected Result | Priority | Status |
| --- | --- | --- | --- | --- | --- | --- | --- | --- |
| TC-SU-001 | Sign Up | Successful registration | User is on Sign Up page | Enter valid mandatory data; submit | Valid unique email/mobile, strong password | Account is created and success confirmation/redirect is shown | High | Not Run |
| TC-SU-002 | Sign Up | Required field validation | Sign Up page open | Leave mandatory fields blank; submit | Blank | Validation is shown for each required field | High | Not Run |
| TC-SU-003 | Sign Up | Invalid email format | Sign Up page open | Enter invalid email; submit | abc@ | Email format validation is shown | Medium | Not Run |
| TC-SU-004 | Sign Up | Invalid mobile format | Sign Up page open | Enter invalid mobile; submit | 123 | Mobile validation is shown | Medium | Not Run |
| TC-SU-005 | Sign Up | Password policy | Sign Up page open | Enter weak password | 12345 | Password policy message is shown | High | Not Run |
| TC-SU-006 | Sign Up | Confirm password mismatch | Sign Up page open | Enter different password/confirm password | Pass@123 / Pass@124 | Mismatch validation is shown | High | Not Run |
| TC-FP-001 | Forgot Password | Registered email/mobile | Forgot Password page open | Enter registered identifier and submit | Registered email/mobile | OTP/reset flow is initiated | High | Not Run |
| TC-FP-002 | Forgot Password | Unregistered identifier | Forgot Password page open | Enter unregistered identifier | unknown@example.com | Appropriate error message is shown | High | Not Run |
| TC-FP-003 | Forgot Password | Invalid format | Forgot Password page open | Enter invalid identifier | abc@ | Validation is shown | Medium | Not Run |
| TC-OTP-001 | Sign with OTP | Valid OTP | OTP screen open | Enter valid OTP and continue | Valid OTP | User is authenticated and redirected | High | Not Run |
| TC-OTP-002 | Sign with OTP | Invalid OTP | OTP screen open | Enter incorrect OTP | 000000 | Error message is shown; user is not authenticated | High | Not Run |
| TC-OTP-003 | Sign with OTP | Expired OTP | OTP screen open | Use expired OTP | Expired OTP | Expiry message is shown; authentication fails | High | Not Run |
| TC-OTP-004 | Sign with OTP | Resend OTP | OTP screen open | Click Resend OTP | N/A | New OTP is generated/sent and resend control behaves correctly | Medium | Not Run |
| TC-LG-001 | Login | Valid credentials | Login page open | Enter valid email/password; click Login | Registered credentials | User logs in successfully and dashboard is displayed | High | Passed |
| TC-LG-002 | Login | Invalid credentials | Login page open | Enter invalid credentials; click Login | invalid@example.com / WrongPassword@123 | Authentication fails and error is displayed | High | Passed |
| TC-LG-003 | Login | Blank fields | Login page open | Submit without credentials | Blank | Required field validation is shown | High | Not Run |
| TC-LG-004 | Login | Invalid email format | Login page open | Enter malformed email | abc@ | Email validation is shown | Medium | Not Run |
| TC-LG-005 | Login | Password masking | Login page open | Type password | Password value | Password is masked | Low | Not Run |
| TC-LG-006 | Login | Logout/session | User logged in | Logout and use browser back | N/A | Protected page is not accessible without authentication | High | Not Run |

## Field Validation

| Module | Field | Validation |
| --- | --- | --- |
| Sign Up | Name | Required; alphabetic/allowed characters; sensible length; trim leading/trailing spaces |
| Sign Up | Email | Required; valid email format; maximum length; reject malformed addresses |
| Sign Up | Mobile | Required; numeric; valid country/length; reject letters and invalid length |
| Sign Up | Password | Required; minimum length; complexity policy; should be masked |
| Sign Up | Confirm Password | Required; must exactly match password |
| Forgot Password | Email/Mobile | Required; valid email/mobile format; registered identifier should proceed |
| Sign with OTP | OTP | Required; numeric; exact OTP length; reject invalid/expired OTP |
| Sign with OTP | Resend OTP | Cooldown/rate-limit; resend generates a new OTP; old OTP behavior should be defined |
| Login | Email/Mobile | Required; valid email/mobile format; trim spaces |
| Login | Password | Required; masked; invalid credentials must not authenticate |

## Bugs & Observations

| ID | Area | Observation | Evidence | Severity | Status |
| --- | --- | --- | --- | --- | --- |
| API-001 | Login API | Invalid credentials return HTTP 200 while JSON indicates success=false. Confirm expected API contract before logging as a defect. | Candidate run showed 200 OK with success=false and invalid-credentials message. | Low/Medium | Observation |
| API-002 | Authentication | Do not store actual referral token or password in repository. | Security best practice for test artifacts. | High | Action Required |
