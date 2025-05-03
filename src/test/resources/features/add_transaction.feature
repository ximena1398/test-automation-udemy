Feature: Add transaction

  Scenario: Add new transaction
    Given Pepito is logged into the application
      | user | pass |
    When Pepito enters the required information for the new transaction
      | 12-03-2025 | 300000 | Prueba dos |
    Then Pepito should see a new transaction in the transaction list whit correct details
      | 300000 | Prueba dos |
