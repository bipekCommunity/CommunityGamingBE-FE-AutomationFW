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


    Scenario: Admin should be able to add token CGB-472
      Given user sign in with valid credentials "mrbrook2" username "Test1234" password in "dev2URI" envirenment
      When  user try to create new token
      Then  Input data should be created correctly
  @wip
  Scenario: Admin should be able to add and edit token CGB-472
    Given user sign in with valid credentials "mrbrook2" username "Test1234" password in "dev2URI" envirenment
    When  user try to create new token
    Then  Input data should be created correctly
    When  user can be able to edit created token's data


  Scenario: Admin should be able to create a game CGB-471
    Given user sign in with valid credentials "mrbrook2" username "Test1234" password in "dev2URI" envirenment
    When user try to create new game with valid data
    Then game should be created

  @wip
  Scenario: Admin should be able to edit created game CGB-471
    Given user sign in with valid credentials "mrbrook2" username "Test1234" password in "dev2URI" envirenment
    When user try to create new game with valid data
    Then game should be created
    And user can be able to edit Game info with valid data


