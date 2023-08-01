Feature: SauceDemo Remove Products From Cart
  @AddToCartAProduct
  Scenario: Login to the application with valid credentials
    Given User is on Login Page
    When User login into application using valid user credentials
    Then Main Home Page is populated
    And verify that the Cart is not empty
    Then Open the Cart
    And Remove products from cart
    Then User logout from application