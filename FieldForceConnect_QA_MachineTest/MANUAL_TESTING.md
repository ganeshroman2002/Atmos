# Manual Testing – FieldForceConnect

## Test Cases

| TC ID | Module | Test Case | Steps | Test Data | Expected Result |
| --- | --- | --- | --- | --- | --- |
| TC01 | Sign Up | Check signup with valid details | Open Signup page → enter all valid details → click Signup | Valid name, email, mobile, password | User should be registered successfully |
| TC02 | Sign Up | Check signup with blank fields | Open Signup page → leave all fields blank → click Signup | Blank | Required field message should come |
| TC03 | Sign Up | Check signup with wrong email | Enter wrong email format → click Signup | abc@ | Email validation message should come |
| TC04 | Sign Up | Check signup with wrong mobile number | Enter invalid mobile number | 12345 | Mobile number validation should come |
| TC05 | Sign Up | Check password validation | Enter a weak/invalid password | 12345 | Password validation message should come |
| TC06 | Sign Up | Check confirm password | Enter different password and confirm password | Test@123 / Test@456 | Password mismatch message should come |
| TC07 | Sign Up | Check signup with already registered email | Enter an email which is already registered | Existing email | Proper error message should come |
| TC08 | Forgot Password | Check forgot password with registered email | Open Forgot Password → enter registered email → submit | Registered email | OTP/reset process should start |
| TC09 | Forgot Password | Check forgot password with wrong email | Enter email which is not registered | test123@gmail.com | Proper error message should come |
| TC10 | Forgot Password | Check forgot password with blank email | Leave email blank → submit | Blank | Required field message should come |
| TC11 | Forgot Password | Check wrong email format | Enter invalid email format | abc@ | Email validation should come |
| TC12 | Forgot Password | Check reset password with valid OTP | Enter valid OTP and new password | Valid OTP | Password should be changed successfully |
| TC13 | Sign with OTP | Check login with valid OTP | Enter mobile/email → enter valid OTP → submit | Valid OTP | User should login successfully |
| TC14 | Sign with OTP | Check login with wrong OTP | Enter wrong OTP → submit | 000000 | Error message should come |
| TC15 | Sign with OTP | Check OTP with blank field | Leave OTP blank → submit | Blank | Required field message should come |
| TC16 | Sign with OTP | Check expired OTP | Enter expired OTP | Expired OTP | OTP expired message should come |
| TC17 | Sign with OTP | Check resend OTP | Click Resend OTP | N/A | New OTP should be sent |
| TC18 | Sign with OTP | Check OTP with alphabets | Enter letters instead of OTP | abcdef | OTP should not be accepted |
| TC19 | Login | Check login with valid credentials | Enter correct email and password → click Login | Valid credentials | User should login and dashboard should open |
| TC20 | Login | Check login with wrong password | Enter correct email and wrong password | Wrong password | Error message should come |
| TC21 | Login | Check login with wrong email | Enter wrong email and password | Wrong email | Error message should come |
| TC22 | Login | Check login with blank fields | Leave email and password blank → click Login | Blank | Required field messages should come |
| TC23 | Login | Check login with wrong email format | Enter invalid email format | abc@ | Email validation should come |
| TC24 | Login | Check password is hidden | Enter password in password field | Test@123 | Password should be hidden |
| TC25 | Login | Check login button | Open login page and check Login button | N/A | Login button should be visible and clickable |

## Field Validation

| Module | Field | Validation |
| --- | --- | --- |
| Sign Up | Name | Should not be blank and should accept valid name |
| Sign Up | Email | Should accept valid email format |
| Sign Up | Mobile | Should accept valid mobile number |
| Sign Up | Password | Should follow password rules |
| Sign Up | Confirm Password | Should match password |
| Forgot Password | Email | Should accept valid registered email |
| OTP | OTP | Should accept correct number of digits only |
| Login | Email | Should accept valid email/mobile |
| Login | Password | Should not be blank and should be hidden |

## Bugs / Observations

| Bug ID | Module | Bug / Observation | Expected | Actual | Severity | Status |
| --- | --- | --- | --- | --- | --- | --- |
| BUG01 | Login API | Invalid login gives HTTP 200 even though login is not successful | Invalid login should return the expected error HTTP status according to API design | API returns 200 with success=false | Medium | Observed |

**Note:** Only actual observations are listed as bugs. Other test cases should be marked after execution.