Feature: SauceDemo Login with locked user
  @LoginWithLockedUser
  Scenario: Login to the application with locked user
    Given User is on Login Page
    When Locked User login into application
    And Locked User error message is displayed
    And Clear username field
    Then Clear password field
