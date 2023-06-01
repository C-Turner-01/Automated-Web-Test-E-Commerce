Feature: Testing that more than one product can be added to the cart
  Scenario Outline: Adding products from the homepage to the cart
    Given I am on the homepage
    When I click the link for the first product "<ProductOne>"
    And I click the add to cart
    And I click the ok button to the confirmation message
    And I navigate to the homepage
    And I click the link for the second product "<ProductTwo>"
    And I click add to cart for the second product
    And I click the ok button to the second confirmation message
    And I navigate to the cart page
    Then I should view both items in my basket
    Examples:
    |ProductOne|ProductTwo|
    |mobileOne |mobileTwo |
    |laptopOne |laptopTwo |
    |monitorOne|monitorTwo|