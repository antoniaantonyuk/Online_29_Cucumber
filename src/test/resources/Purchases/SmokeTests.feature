@Smoke
Feature: Smoke Tests
  Background:
    Given user on the purchases page

  Scenario: checks purchase tab title of Requests for Quotation
    Then title of the page should be "Requests for Quotation - Odoo"

  Scenario: checks purchase tab title of Purchase Orders
    Then title of the page should be "Purchase Orders - Odoo"

  Scenario: checks purchase tab title of Vendors
    Then title of the page should be "Vendors - Odoo"

  Scenario: checks purchase tab title of Products
    Then title of the page should be "Products - Odoo"

  Scenario: checks purchase tab title of Incoming Products
    Then title of the page should be "Incoming Products - Odoo"

  Scenario: checks purchase tab title of Vendor Bills
    Then title of the page should be "Vendor Bills - Odoo"

  Scenario: checks purchase tab title of Purchases Analysis
    Then title of the page should be "Purchases Analysis - Odoo"

