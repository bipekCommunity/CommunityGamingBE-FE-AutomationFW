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



 Scenario: Importing .csv file to the admin panel CGB-457 (positive)
   When User post request with valid parameter (key-text)
   Then CSV file should be imported

   When User post request with key and empty text
   Then CSV file should be imported

   When User post request with more text in one key
   Then Key and first text should be imported

   When When User post request for changes to key's value
   And  user type unique characters in value
   Then Value should be changed

  Scenario: Importing .csv file to the admin panel CGB-457 (negative)
    When User post request with missed key
    Then user should get bad request message

  Scenario:Adding new parameters to the admin panel CGB-458(positive)
    When User send request for addnig new parameters (unique key, status Active/passive)
    Then Translation key should be added.

    When user send request for created parameter with different language code
    Then Translation key should be added with diffrent language code.

  Scenario:Adding new parameters to the admin panel CGB-458(negative)
    When User try yo send request for new parameters to created parameters
    Then user should get Tournament already added on "language(tr/en...etc)" message


  Scenario: Editing the definitions in the admin panel CGB-459 (positive)
    When User send request for edit parameter with created id
    Then parameter should be changed

    When User send request for edit key and value with created id
    Then parameters should be changed

  Scenario: Editing the definitions in the admin panel CGB-459 (negative)
    When User send request for edit parameter  with missing key
    Then User should get Key cannot be empty message
