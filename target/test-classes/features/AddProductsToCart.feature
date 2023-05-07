Feature: Testing that more than one product can be added to the cart
  Scenario: Adding products from the homepage to the cart
    Given I am on the homepage
    When I click the link for the first product
    And I click the add to cart
    And I click the ok button to the confirmation message
    And I navigate to the homepage
    And I click the link for the second product
    And I click add to cart for the second product
    And I click the ok button to the second confirmation message
    And I navigate to the cart page
    Then I should view both items in my basket