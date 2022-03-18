Feature: Tournament Tests

 @smoke @positive
  Scenario: CreateTournament With Multiple Brackets
    Given user sign in with valid credentials "mrbrooks2" "Test1234"
    When  user post CreateTournament With Multiple Brackets
    Then  Status Code Should be 200

 @smoke @negative
  Scenario: User should not be able to Start the tournament when Bracket Empty
    Given user sign in with valid credentials "mrbrooks" "Test1234"
    When  user post CreateTournament With Multiple Brackets
    And   user try to start tournament
    Then  user should get message Bracket is empty message

   @smoke @positive
   Scenario: User should be able to join to Upcoming Tournament
     Given user sign in with valid credentials "mrbrooks2" "Test1234"
     When user send request for upcoming tournament
     Then participant ids should include added team id

   @smoke @positive
   Scenario: User should be able to  Unenroll From Tournament
     Given user sign in with valid credentials "mrbrooks2" "Test1234"
     When user send request for Unenroll from Tournament
     Then added team id should be deleted from participant id list


   Scenario: User should be able to see Past Tournament detail
     Given user sign in with valid credentials "mrbrooks2" "Test1234"
     And user send request for past tournament detail id "tournament-created-by-ahmet-13"
     Then  user should be able to see participants
     And   tournament approval should "false"

     @wip @reg
   Scenario: Tournament E2E Test
     Given user sign in with valid credentials "mrbrooks2" "Test1234"
     And   organizer create tournament with single elemination
     And   Add participant mrbrooks2
     And   user sign in with valid credentials "mrbrooks" "Test1234"
     And   Add participant mrbrooks
     And   user sign in with valid credentials "mrbrooks2" "Test1234"
     And   organizer generates bracket
     And   organizer starts tournament
     And   organizer enters score
     And   organizer ends tournament




