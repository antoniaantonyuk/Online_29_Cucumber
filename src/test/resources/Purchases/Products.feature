@ron
Feature: Products page under purchases

  Background:
    Given user on the home page
    When user click on BriteErpDemo option
    Then user logs in by using "in_pos_manager4.@info.com" and "KjKtfgrs33"
    And user clicks on purchases tab
    And user clicks on products tab


#brit 1841
  Scenario: Manager should be able to add a message under a document description
    Given User on the products page
    When the user clicks on "Iphone 8"
    And the user clicks on the "add a message" button
    And the user types on the message box this message " 50% discount" button
    And the user clicks on the "message" button
    Then verify that the message added in the message box.


#brit 1809
  Scenario: Manager should be able to update product quantity on hand
    Given User on the products page
    When the user click on "DataCard"
    And the user click on the "update quantity" button
    And the user enters " 11" as new quantity
    And the user clicks on the "apply" button
    Then verify that the quantity is updated.


#brit 1819

  Scenario: Manager should be able to print a product label
    Given User on the products page
    When the user clicks on "Apple Watch 3"
    And the user clicks on the "print" button
    Then the user should see the product's label.
    Then verify that the label contains the product name.
