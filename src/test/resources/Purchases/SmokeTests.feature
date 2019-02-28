@Smoke
Feature: Smoke testS


  Scenario: wrong password
    Given user on the home page
    When user click on BriteErpDemo option
    Then user logs in wrong password "in_pos_manager4.@info.com" and "KjKtfgrs333"


  Scenario: wrong username
    Given user on the home page
    When user click on BriteErpDemo option
    Then user logs in wrong username "in_pos_manager44.@info.com" and "KjKtfgrs"


  Scenario Outline: checks the tabs under purchase module
    Given user on the purchases page
    Then title of the page should be "<tabTitle>"
    Examples:
      | tabTitle                      |
      | Requests for Quotation - Odoo |
      | Purchase Orders - Odoo        |
      | Vendors - Odoo                |
      | Products - Odoo               |
      | Incoming Products - Odoo      |
      | Vendor Bills - Odoo           |
      | Purchase Analysis - Odoo     |