#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Verify user can manage products in cart

  Background: Login as a valid user to sauce demo site
    Given User logged in as a valid user and in product page
      | userid        | password     |
      | standard_user | secret_sauce |

  @product
  Scenario: Verify user can add an item to shopping cart
    When User click the add button to add the product  "Sauce Labs Bolt T-Shirt" to cart
    And clicks on cart
    Then verify "Sauce Labs Bolt T-Shirt" is present in the cart

  @product
  Scenario: Verify user can remove item from shopping cart
    When User click the add button to add the product  "Sauce Labs Bolt T-Shirt" to cart
    And clicks on cart
    Then verify "Sauce Labs Bolt T-Shirt" is present in the cart
    And user click ons remove button to remove the product "Sauce Labs Bolt T-Shirt" from cart
    Then verify "Sauce Labs Bolt T-Shirt" is removed from cart
