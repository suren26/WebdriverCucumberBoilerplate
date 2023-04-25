@scenario1

Feature: Adding products into the cart

  @regression
  Scenario: Adding 1 product to the cart

    Given user is logged in on saucedemo page "https://www.saucedemo.com/"
    When User sees the product
    And Adds the products into cart "shoppingcartBag"
    Then User sees the quantity in shopping cart badge
    And user logs out

  @regression
  Scenario: Adding 2 products to the cart

    Given user is logged in on saucedemo page "https://www.saucedemo.com/"
    When User sees the product
    And Adds the products into cart "shoppingcartBag"
    And Adds the products into cart "bikeLight"
    Then User sees the quantity in shopping cart badge
    And user logs out