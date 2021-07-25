@Functional
Feature: Online Shopping Portal

  @Sanity @Regression
  Scenario: Successful Login
    Given login is successful

  @Smoke
  Scenario: Failed Login
    Given login has failed

  @Regression
  Scenario: New user registration
    Given user registers on portal

  @Regression
  Scenario: Search a product
    Given user searches a product

  @Sanity @Regression
  Scenario: Adding a product to the cart
    Given user adds a product to the cart

  @Sanity
  Scenario: Adding multiple products to the cart
    Given user adds more products to the cart

  @Sanity @Regression
  Scenario: Removal of product from the cart
    Given user removes a product from the cart

  @Smoke
  Scenario: Quantity increase for selected product
    Given user increases product quantity in the cart

  @Smoke
  Scenario: Quantity decrease for selected product
    Given user decreases product quantity in the cart

  @Sanity @Regression
  Scenario: Empty shopping cart
    Given user removes all items from cart

  @Sanity @Regression
  Scenario: Cash payment
    Given user makes cash payment

  @Smoke
  Scenario: Issue of gift voucher
    Given user applies for gift voucher

  @Regression
  Scenario: Selecting delivery type
    Given user selects home delivery option

  @Regression
  Scenario Outline: Select payment option
    Given user selects payment type as "<paymentMethod>"

    Examples: 
      | paymentMethod    |
      | CC Card          |
      | DB Card          |
      | Net Banking      |
      | Cash On Delivery |
      | Cash             |
