@yaz
Feature: Products page under purchases

  Background:
    Given user on the products page

#brit 1841

  Scenario Outline: Manager should be able to add a message under a document description
    When the user clicks on "<item>"
    And the user clicks on the "add a message" button
    And the user types on the message box this message "<note>" button
    And the user clicks on the "message" button
    Then verify that the message added in the message box.
    Examples:
      | item     | note         |
      | Iphone 8 | 50% discount |


#brit 1809

  Scenario Outline: Manager should be able to update product quantity on hand
    When the user click on "<item>"
    And the user click on the "update quantity" button
    And the user enters "<quantity>" as new quantity
    And the user clicks on the "apply" button
    Then verify that the quantity is updated.
    Examples:
      | item     | quantity |
      | DataCard | 15       |

#brit 1819

  Scenario Outline: Manager should be able to print a product label
    When the user clicks on the product of "<item>"
    And the user clicks on the product's "print" button
    Then verify that the label contains the product name.
    Examples:
      | item          |
      | Apple Watch 3 |