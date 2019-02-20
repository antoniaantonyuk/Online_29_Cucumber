Feature: Smoke Tests

  @Smoke
  Scenario: checks purchase tab title
    Given user on the purchases page
    Then title of the page should be "Requests for Quotation - Odoo"
