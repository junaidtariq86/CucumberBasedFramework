Feature: SauceDemo Application Login
  @LoginToSauceDemo
  Scenario: Login to the application with valid credentials
    Given User is on Login Page
    When User login into application using valid user credentials
    Then Main Home Page is populated
    Then User logout from application
