
Feature: VendorsPage

  Background:
  #Given user on the home page
  #When user click on BriteErpDemo option
  #Then user logs in by using "in_pos_manager4.@info.com" and "KjKtfgrs33"
  #And user clicks on purchases tab
    Given user on the purchases page
    And user clicks on vendors tab

  #BRIT-1548

  Scenario Outline: Create a new vendor
    Then user clicks on VendorCreate button
    And user clicks on company radio button
  #  Then user fills out required information "<Name>", "<Address>", "<Phone>","<Email>"
    Then user creates new vendor "<Name>", "<Address>", "<Phone>","<Email>"

    Examples:
      | Name       | Address          | Phone      | Email             |
      | TexasGuys  | Virginia Street  | 3243234212 | info@cybertek.com |
      | TexasGuys2 | Virginia Street1 | 3243234212 | info@cybertek.com |


##BRIT-1555
  Scenario Outline: User should be able to search for a Vendor in search field
    Then user write vendor name which want to search "<SearchField>"

    Examples:
      | SearchField |
      | Apex        |
      | Cybertek    |


##BRIT-1564

  Scenario: User should be able to filter for a Vendor and company in search field
    Then user clicks on advanced search button
    Then user clicks on filters dropdown button
    And user clicks on companies


##BRIT-1571 //
  @go
  Scenario: import a CSV or Excel file
    Then user clicks on import button
    Then user uploads data file excel file upload


##BRIT-1580 //

  Scenario: User is able to click any of the existing vendors
    And user clicks on vendors tab
    Then user clicks any vendor use random method


###BRIT-1689

  Scenario: User should be able to sent an email to the vendors email address
    Then user clicks on 'Dont Touch' vendor
    Then clicks on oibekalim@gmail.com system should open default email fill requirement and send


###BRIT-1718

  Scenario: Manager should be able to see a bar, line and pie charts,  from reporting function
    Then user clicks on Reporting button
    Then user clicks on bar, line and pie chart buttons
