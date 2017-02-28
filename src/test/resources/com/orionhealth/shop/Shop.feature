Feature: Shop Cart.
  
  As a shop user
  I want to be able to select between two items
  So that, I can buy them

  Background: 
    Given I open the Shop page

  @regression @now @smoke
  Scenario: Product A and B - Check the shopping when purchase quantity is in the stock for two products (Scenario 00 - positive path)
    When I fill Item A with "2" products
    And I fill Item B with "2" products
    And I click on Buy button
    And I fill Item A with "3" products
    And I fill Item B with "3" products
    And I click on Buy button
    Then I see the "Success" message
    And I see the stocks decrementation of the item A with "15"
    And I see the stocks decrementation of the item B with "5"
    And I see the Order Number "1"
    And I see the items history shown in Order Number "1" in
      | ORDER    |
      | Item A 2 |
      | Item B 2 |

  @regression @now
  Scenario: Product A - Check the shopping when purchase quantity is in the stock (Scenario 01 - positive path)
    When I fill Item A with "2" products
    And I click on Buy button
    Then I see the "Success" message
    And I see the Order Number "1"
    And I see the stocks decrementation of the item A with "18"
    And I see the stocks decrementation of the item B with "10"
    And I see the items history shown in Order Number "1" in item A with "2" products displayed

  @regression
  Scenario: Product A - Check the shopping when purchase quantity is less than stock (Scenario 02 - negative path)
    When I fill Item A with "-1" products
    And I click on Buy button
    Then I see the "at least buy one product" message
    And I see the stocks decrementation of the item A with "20"
    And I see the stocks decrementation of the item B with "10"

  @regression
  Scenario: Product A - Check the shopping when purchase quantity is empty (Scenario 03 - negative path)
    When I fill Item A with "" products
    And I click on Buy button
    Then I see the "at least buy one product" message
    And I see the stocks decrementation of the item A with "20"
    And I see the stocks decrementation of the item B with "10"

  @regression
  Scenario: Product A - Check the shopping when purchase quantity is greater than stock (Scenario 04 - negative path)
    When I fill Item A with "21" products
    And I click on Buy button
    Then I see the "not enough stock for product #1, current quantity: 20, expect quantity: 21" message
    And I see the stocks decrementation of the item A with "20"
    And I see the stocks decrementation of the item B with "10"

  @regression
  Scenario: Product A - Check the shopping when purchase quantity is equals to the stock (Scenario 05 - positive path)
    When I fill Item A with "20" products
    And I click on Buy button
    Then I see the "Success" message
    And I see the Order Number "1"
    And I see the stocks decrementation of the item A with "0"
    And I see the stocks decrementation of the item B with "10"
    And I see the items history shown in Order Number "1" in item A with "20" products displayed

  @regression
  Scenario: Product B - Check the shopping when purchase quantity is in the stock (Scenario 06 - positive path)
    When I fill Item B with "3" products
    And I click on Buy button
    Then I see the "Success" message
    And I see the Order Number "1"
    And I see the stocks decrementation of the item A with "20"
    And I see the stocks decrementation of the item B with "7"
    And I see the items history shown in Order Number "1" in item B with "3" products displayed

  @regression
  Scenario: Product B - Check the shopping when purchase quantity is less than stock (Scenario 07 - negative path)
    When I fill Item B with "-1" products
    And I click on Buy button
    Then I see the "at least buy one product" message
    And I see the stocks decrementation of the item A with "20"
    And I see the stocks decrementation of the item B with "10"

  @regression
  Scenario: Product B - Check the shopping when purchase quantity is empty (Scenario 08 - negative path)
    When I fill Item B with "" products
    And I click on Buy button
    Then I see the "at least buy one product" message
    And I see the stocks decrementation of the item A with "20"
    And I see the stocks decrementation of the item B with "10"

  @regression
  Scenario: Product B - Check the shopping when purchase quantity is greater than stock (Scenario 09 - negative path)
    When I fill Item B with "11" products
    And I click on Buy button
    Then I see the "not enough stock for product #2, current quantity: 10, expect quantity: 11" message
    And I see the stocks decrementation of the item A with "20"
    And I see the stocks decrementation of the item B with "10"

  @regression
  Scenario: Product B - Check the shopping when purchase quantity is equals to the stock (Scenario 10 - positive path)
    When I fill Item B with "10" products
    And I click on Buy button
    Then I see the "Success" message
    And I see the Order Number "1"
    And I see the stocks decrementation of the item A with "20"
    And I see the stocks decrementation of the item B with "0"
    And I see the items history shown in Order Number "1" in item B with "10" products displayed
