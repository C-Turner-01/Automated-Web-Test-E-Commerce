Feature: Testing that a confirmation message occurs when an item has been purchased
  @PurchasingItem
  Scenario: Adding Item to cart from homepage and purchasing that item
    Given I am on the homepage
    When I click the link for the first product "<ProductOne>"
    And I click the add to cart
    And I click the ok button to the confirmation message
    And I navigate to the cart page
    And I click purchase
    And I fill form details "testName" "testCountry" "testCity" "1111111111111111"
    And I click the purchase button
    Then I should see a confirmation message showing that the item has been purchased