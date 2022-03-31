Feature: Users Tests

 @reg
  Scenario: User should be able to get user information CGB-412
    Given user sign in with valid credentials to Dev Environment  "Testinguser01" "Linkinpark!996"
    When  user should be able to send request for user information
    Then  user should be able to see personal information data
    When  user post CreateTournament With Multiple Brackets for Dev Environment
    Then  Organized Tournament Count should be an increase
    When  user post request for create  a team
    Then  Teams count should be an increase

 @reg
  Scenario: Do not serve registration questions if the requesting user is not in the tournament CGB-361
    Given user sign in with valid credentials to Dev Environment  "Testinguser01" "Linkinpark!996"
    When organizer send a request for registration question
    Then organizer should be able to see registration answers
    Given user sign in with valid credentials to Dev Environment  "Testinguser01" "Linkinpark!996"
    When participant send a request for registration question
    Then participant should be able to see registration answers
    Given user sign in with valid credentials to Dev Environment  "ahmadplus41" "Linkinpark!996"
    When user send a request for registration question
    Then user should  be able to see registration answers




    
