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
@reg @positive
  Scenario: Admin should be able to add and edit token CGB-472
    Given user sign in with valid credentials "mrbrook2" username "Test1234" password in "dev2URI" envirenment
    When  user try to create new token
    Then  Input data should be created correctly
    When  user can be able to edit created token's data

  @reg @positive
  Scenario: Admin should be able to delete created token CGB-487
    Given user sign in with valid credentials "mrbrook2" username "Test1234" password in "dev2URI" envirenment
    When  user try to create new token
    Then  Input data should be created correctly
    When  user can be able to delete created token
    Then  Deleted token should appear in token list
  @reg @positive
  Scenario: Admin should be able to create a game CGB-471
    Given user sign in with valid credentials "mrbrook2" username "Test1234" password in "dev2URI" envirenment
    When user try to create new game with valid data
    Then game should be created

  @reg @positive
  Scenario: Admin should be able to edit created game CGB-471
    Given user sign in with valid credentials "mrbrook2" username "Test1234" password in "dev2URI" envirenment
    When user try to create new game with valid data
    Then game should be created
    And user can be able to edit Game info with valid data


    ##Scenario: All players can check-in for the team (Captain & Normal Player) CGB-346
     ## When Organizer creates a tournament
      ##And  Participants joint tournament
      ##Then Organizer should be able to check-in for the team
      ##And  Participant should be able to check-in for the team
      ##And  NonParticipant user should not be able to check-in for the team



