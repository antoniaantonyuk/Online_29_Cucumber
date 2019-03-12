Feature: reading data from Excel and confirming changes with DB

  Background:
    Given user on the purchases page
  @excel
  Scenario: Edit random quote by getting value from excel

    When user opens random quote
    Then user edit required parts
    #Then PO should be updated on DB
#@db
  Scenario: compare PO count at front with backend
    When user on Purchase Orders Page
    Then number of purchase orders should match with database records


  Scenario: compare PO Reference names
    When user on Purchase Orders Page and POs are sorted by Reference no
    Then Reference numbers should match with database records


  Scenario: Confirms new PO is created
    When user on Purchase Orders Page
    When user creates new PO
    Then new PO should be added to DB

 Scenario: Confirms PO is removed
    When user opens random quote
    Then user deletes a quote
    Then new PO should be removed from db

  @db
  Scenario: add a new request and delete it
    When user successfully creates new PO
    Then new PO should be added to DB
    Then user deletes a quote
    Then new PO should be removed from db