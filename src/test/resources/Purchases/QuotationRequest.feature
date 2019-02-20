@Run
Feature: QuoteRequestPage


  Background:
    Given user on the purchases page

  #brit74

  Scenario: total amount shown bottom of the table matches with all individual quote prices added together.
    Then total value shown at the bottom of the page should match with addition of all quote values

#brit79

  Scenario: user can select one or more quotes from list successfully and total price updates based on selections
    Then user selects random quotes from the list
    Then total value shown at the bottom of the page should match with addition of all selected quote values


##brit 81 , 82

  Scenario: Manager should be able to print as a purchase order
    Then user selects random quotes from the list
    And user can click on print tab and select print as a Purchase Order option
#
#
##brit 101,81

  Scenario: Manager should be able to print as a request for quotation
    Then user selects random quotes from the list
    And user can click on print tab and select print as a request for quotation option
#
##brit 115

  Scenario: Manager should be able to export a report
    Then user selects random quotes from the list
    And user can click on action tab and selects export option
    Then user selects exporting options by double clicking on them
    Then user clicks on export to File button
#
#
##brit 115

  Scenario Outline: Change the view of the page
    And user click on "<view>" view

   # Then user confirms that selected view is enabled
    Examples:
      | view     |
      | List     |
      | Kanban   |
      | Pivot    |
      | Graph    |
      | Schedule |
#
#
##brit 321

  Scenario: Manager should be able to delete a quote

    Then user clicks on the quote he wants to delete
    Then user clicks on cancel button
    And user clicks on action tab and selects delete option
    Then user confirms the delete

##brit 324

  Scenario Outline: Manager should be able to sort the transaction by date, amount, reference, vendor, and source
    Then user clicks on "<column1>", "<column2>","<column3>","<column4>","<column5>","<column6>","<column7>" head

    Examples:
      | column1   | column2    | column3 | column4        | column5 | column6 | column7 |
      | Reference | Order Date | Vendor  | Scheduled Date | Untaxed | Total   | Status  |


##brit 325

  Scenario Outline: Create a new quote

    Then user clicks on create button
   Then user fills out required information "<Vendor>", "<Vendor Reference>", "<Order Date>","<Scheduled Date>"
   Then user confirms the request
#
    Examples:
      |Vendor       |Vendor Reference| Order Date |Scheduled Date|
     |ADALET           |oz61            |02/18/2019  | 02/19/2019   |
     |CyberTek     |glidali61            | 02/16/2019 | 02/24/2023   |
      |JP           |glidali              | 02/18/2019 | 02/19/2021   |
#
