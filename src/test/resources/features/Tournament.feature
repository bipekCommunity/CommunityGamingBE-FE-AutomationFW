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

      @reg @e2e
   Scenario: Tournament E2E Test CGB-435 CGB-433 CGB-434
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
     ## used mrbrooks2 id
     When user get rewards
     Then  user claim off chain reward


  @reg @positive
  Scenario: Listing Tournament CGB-440 CGB-439 CGB-438
    Given user sign in with valid credentials "mrbrooks2" "Test1234"
    And   organizer create tournament with single elemination
    Then  tournament should list in upcoming tournament
    And   tournament should not list in progress tournament
    And   tournament should not list in completed tournament
    And   Add participant mrbrooks2
    And   user sign in with valid credentials "mrbrooks" "Test1234"
    And   Add participant mrbrooks
    And   user sign in with valid credentials "mrbrooks2" "Test1234"
    And   organizer generates bracket
    When  organizer starts tournament
    Then  tournament should list in progress tournament
    And   tournament should not list in upcoming tournament
    And   tournament should not list in completed tournament
    When  organizer enters score
    When  organizer ends tournament
    Then  tournament should list in completed tournament
    And   tournament should not list in progress tournament
    And   tournament should not list in upcoming tournament

   @e2d @reg @smoke
  Scenario: RR and SE phases E2E test
    Given user sign in with valid credentials "mrbrooks2" "Test1234"
    When  organizer create tournament with Multiple Bracket (RoundRobin-Single Elemination)
    And   fill tournament with participants
    And   generate bracket for RR
    Then  bracket Status should be Seeded
    When  organizer starts tournament for MultipleBracket RR-SE
    Then  bracket Status should be Live
    When  organizer enters the score for RR
    And   organizer enters the score for RR second match
    And   organizer generates bracket  for SE
    And   organizer starts bracket for SE
    And   organizer enters the score for SE
    And   organizer ends the tournament for RR-SE
    Then  bracket Status should be Complete
    And   Winner List should contains ID
    And   tournament status should be Complete


  Scenario Outline: Swiss-SE Tournament Creation
     Given user sign in with valid credentials "mrbrooks2" "Test1234"
     When Organizer create a Tournament <teamSize> <maxTeams> Swiss bracket as <phaseIndeSW> <maxParticipantCountSW> <gamesPerRoundSW> <playPerTeamsSW> <roundCountSW> and single elemination as <phaseIndexSE> <maxParticipantCountSE>
     And  fill tournament with participants
   And generate bracket swiss
    And organizer starts tournament for MultipleBracket

    Examples:
    |teamSize|maxTeams|phaseIndeSW|maxParticipantCountSW|gamesPerRoundSW|playPerTeamsSW|roundCountSW|phaseIndexSE|maxParticipantCountSE|
    #|1       |4       |1          |4                    |1              |1             |2           |2           |4                    |
    |1       |4000     |1          | 4000                 |12              |2             |1          |2           |2000                   |





