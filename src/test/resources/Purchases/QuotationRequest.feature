@Run
Feature: QuoteRequestPage


  Background:
    Given user on the home page
    When user click on BriteErpDemo option
    Then user logs in by using credentials from config file
    And use clicks on purchase tab

  #brit74

  Scenario: total amount shown bottom of the table matches with all individual quote prices added together.

    Then total value shown at the bottom of the page should match with addition of all quote values
#
##brit79
#  Scenario: user can select one or more quotes from list successfully and total price updates based on selections
#    Given user on the home page
#    When user click on BriteErpDemo option
#    Then user logs in by using "in_pos_manager4.@info.com" and "KjKtfgrs33"
#    And use clicks on purchase tab
#    Then user selects random quotes from the list
#    Then total value shown at the bottom of the page should match with addition of all selected quote values
#
#
##brit 81 , 82
#  Scenario: Manager should be able to print as a purchase order
#    Given user on the home page
#    When user click on BriteErpDemo option
#    Then user logs in by using "in_pos_manager4.@info.com" and "KjKtfgrs33"
#    And use clicks on purchase tab
#    Then user selects random quotes from the list
#    And user can click on print tab and select print as a Purchase Order option
#
#
##brit 101,81
#  Scenario: Manager should be able to print as a request for quotation
#    Given user on the home page
#    When user click on BriteErpDemo option
#    Then user logs in by using "in_pos_manager4.@info.com" and "KjKtfgrs33"
#    And use clicks on purchase tab
#    Then user selects random quotes from the list
#    And user can click on print tab and select print as a request for quotation option
#
##brit 115
#  Scenario: Manager should be able to export a report
#    Given user on the home page
#    When user click on BriteErpDemo option
#    Then user logs in by using "in_pos_manager4.@info.com" and "KjKtfgrs33"
#    And use clicks on purchase tab
#    Then user selects random quotes from the list
#    And user can click on action tab and selects export option
#    Then user selects exporting options by double clicking on them
#    Then user clicks on export to File button
#
#
##brit 115
#  Scenario Outline: Change the view of the page
#    Given user on the home page
#    When user click on BriteErpDemo option
#    Then user logs in by using "in_pos_manager4.@info.com" and "KjKtfgrs33"
#    And use clicks on purchase tab
#    And user click on "<view>" view
#    Then user confirms that selected view is enabled
#
#    Examples:
#      |view         |
#      |List         |
#      |Kanban       |
#      |Pivot        |
#      |Graph        |
#      |Schedule     |
#
#
##brit 321
#  Scenario: Manager should be able to delete a quote
#    Given user on the home page
#    When user click on BriteErpDemo option
#    Then user logs in by using "in_pos_manager4.@info.com" and "KjKtfgrs33"
#    And use clicks on purchase tab
#    Then user clicks on the quote he wants to delete
#    Then user clicks on cancel button
#    And user clicks on action tab and selects delete option
#    Then user confirms the delete
#
#
##brit 324
#  Scenario Outline: Manager should be able to sort the transaction by date, amount, reference, vendor, and source
#    Given user on the home page
#    When user click on BriteErpDemo option
#    Then user logs in by using "in_pos_manager4.@info.com" and "KjKtfgrs33"
#    And use clicks on purchase tab
#    Then user clicks on "<columns>"  head
##Then user clicks on  column head
##Then user clicks on vendor column head
##And user clicks on Scheduled date column head
##Then user clicks on Total column head
#
#    Examples:
#      |columns         |
#      |Reference       |
#      |Order Date      |
#      |vendor          |
#      |Scheduled date  |
#      |Reference       |
#      |Total           |
#
##brit 325
#  Scenario Outline: Create a new quote
#    Given user on the home page
#    When user click on BriteErpDemo option
#    Then user logs in by using "in_pos_manager4.@info.com" and "KjKtfgrs33"
#    And use clicks on purchase tab
#    Then user clicks on create button
#    Then user fills out required information "<Vendor>", "<Vendor Reference>", "<Order date>","<Scheduled Date>"
#    Then user clicks on save button
#
#    Examples:
#      |Vendor       |Vendor Reference| Order Date |Scheduled Date|
#      |HP           |oz61            |02/18/2019  | 02/19/2019   |
#      |CyberTek     |oz61            | 02/18/2019 | 02/19/2019   |
#      |JP           |OZ              | 02/18/2019 | 02/19/2019   |
#
