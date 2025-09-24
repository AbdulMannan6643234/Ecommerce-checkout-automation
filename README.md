# Ecommerce-Checkout-Flow
Automated tested framework for an e-commerce application on the **checkout process**, as well as **login** and **signup flows**.

## Features
- Automated tests for:
        - Checkout flow: cart updates, payment, order confirmation
        - User authentication: login and signup
        - Negative cases: incomplete fields, invalid inputs, error validation
- Page Object Model (POM) for maintainable test structure
- Centralized locators and test data for easier updates
- Generates TestNG reports after each run
## Tech Stack
Ensure you have the following installed:
- Language: Java, JavaScript
- Automation: Selenium WebDriver
- Test Framework: TestNG
- Build Tool: Maven
- Version Control: Git & Github
## Installation
Clone the repositories and install dependencies:
```bash
git clone https://github.com/AbdulMannan6643234/Ecommerce-checkout-automation.git
cd Ecommerce-checkout-automation
mvn clean install
```
## Test Run:
To run tests:
```bash
mvn test
```
## Project Structure
```text
Ecommerce-checkout-automation/
├── src/main/java/pages/        # Page Objects and Utilities
└── src/test/java/              # TestNG test classes
├── pom.xml                     # Maven dependencies
├── screenshots                 # Includes Screenshots of successfull test results
```
## Future Improvements:
- Expanding TestNG usage (data-driven testing, parallel execution)
- Integrating advancced reporting tools (Allure, ExtentReports)
- Exploring API testing with RestAssured
- CI/CD integration for continuous testing
# Screenshots / Reports
### SignUp
![Successful Signup Flow](/screenshots/SuccessfulSignUpTest.png)
Testing a Successful SignUp Flow.

![SignUp Test With Blank Fields](/screenshots/SignUpTestWithEmptyFields.png)
Testing a SignUp flow failure without any data in the fields.

![Shorter Password than required](/screenshots/SignUpTestWithShortPassword.png)
Testing a SignUp flow with a password that is shorter than the required length.

### Contacting Support
![Successfully Sending a Message](/screenshots/SuccessfulContactTest.png)
Successfully sending an automated message to support.

![Attempting a Blank Message](/screenshots/ContactTestWithEmptyMessage.png)
Attempting to send a blank message to support.

![Attempting Contact Without Selecting a Subject](/screenshots/ContactTestWithoutSelectingSubject.png)

Attempting to contact support without selecting a subject.

### Checkout
![Successful Checkout Flow](/screenshots/SuccessfulCheckoutFlow)
Automating a Successful Checkout Flow.

![Attempting CHeckout with wrong credentials](/screenshots/CheckoutTestWithWrongCredentials.png)
Automating a Checkout flow with wrong login creds.

![Attempting Checkout with incomplete credentials](/screenshots/CheckoutTestWithIncompleteCredentials.png)
Automating a checkout flow with incomplete signup credentials.

![Attempting Checkout Without Adding Address](/screenshots/CheckoutTestWithoutAddress.png)
Automating checkout flow without specifying address.
