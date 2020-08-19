Feature: Verify user can manage products in cart

  Background: Login as a valid user to sauce demo site
    Given User logged in as a valid user and in product page
      | userid        | password     |
      | standard_user | secret_sauce |

  @product
  Scenario: Verify user can checkout a product
    When User click the add button to add the product  "Sauce Labs Bolt T-Shirt" to cart
    And clicks on cart
    Then verify "Sauce Labs Bolt T-Shirt" is present in the cart
    When user clicks on checkout
    And provides the user details and cliks on continue
    Then verify "Sauce Labs Bolt T-Shirt" is present in checkout overview
    And user clicks on finish
    Then verify the order confirmation "THANK YOU FOR YOUR ORDER"
