Feature: Admin Panel Tests

 @reg @positive
  Scenario: Admin should be able to search using getUserFinancialTransaction endPoint CGB-443
    Given user sign in with valid credentials "mrbrooks2" "Test1234"
    When Admin queries by getFinancialTransaction endpoint
    Then getFinancialTransaction results should be not empty

  @reg @positive
  Scenario: Admin should be able to get specific users financial transaction   CGB-443
    Given user sign in with valid credentials "mrbrooks2" "Test1234"
    When Admin queries by getUserFinancialTransaction endpoint
    Then getUserFinancialTransaction results should not be empty