Feature: Repairs menu database test
  @db
  Scenario: add products to repair and check in database
    Given open brite url
    When login as purchase user
    And user adds products to repair from excel
    Then all data of excel should be in the repair orders page

  @db
  Scenario: Verify repairs db test
    Given open brite url
    When login as purchase user
    And user goes to the repairs page
    Then all names of Products to repair should be match with database records

