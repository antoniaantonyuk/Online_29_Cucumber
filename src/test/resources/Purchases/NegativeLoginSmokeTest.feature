@Smoke
  Feature: Negative Login test
 Background:
   Given user on the home page
   When user click on BriteErpDemo option

  Scenario: wrong password
    Then user logs in wrong password "in_pos_manager4.@info.com" and "KjKtfgrs333"


  Scenario: wrong username
      Then user logs in wrong username "in_pos_manager44.@info.com" and "KjKtfgrs"