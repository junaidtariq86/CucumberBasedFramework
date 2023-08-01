Feature: SauceDemo Add to cart a Product
  @AddToCartAProduct
  Scenario: Login to the application with valid credentials
    Given User is on Login Page
    When User login into application using valid user credentials
    Then Main Home Page is populated
    And Select a "Sauce Labs Backpack" from Product list
    And select "Add to cart" from product description page
    And verify that the Cart is not empty
    Then  User logout from application

