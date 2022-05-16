Feature: Swiss Tests

  @swiss
  Scenario Outline: Users Match Tests
    Given user sign in with valid credentials "axieOrganizer" username "Test1234" password in "dev4URI" envirenment
    When Organizer create <maxTeam> <maxParticipantCount>  <rounCount> Swiss tournament "dev4URI" env.
    And  Add 32 participant to tournament
    Given user sign in with valid credentials "axieOrganizer" username "Test1234" password in "dev4URI" envirenment
    And organizer generate first swiss bracket
    And  Organizer starts tournament
    And  Organizer enter the scores and generate next bracket for 4 round 32 participants

    Examples:
    |maxTeam|maxParticipantCount|rounCount|
    |32     |32                   | 4       |

  @bigrun
Scenario: Run Specific Tournament
  Given user sign in with valid credentials "axieOrganizer" username "Test1234" password in "dev4URI" envirenment
  And   Enter specific tournament info "dd672552-93a2-4602-8100-b55f9ed6ff73" tournamentID "a3d181cb-f170-4daa-9fd3-08f594f99b26" bracketID for axieTournament
  And  Add 4096 participant to tournament
  Given user sign in with valid credentials "axieOrganizer" username "Test1234" password in "dev4URI" envirenment
  And organizer generate first swiss bracket
  And  Organizer starts tournament
  And  Organizer enter the scores and generate next bracket for 16 round 4096 participants


    Scenario: test
      Given user sign in with valid credentials "axieOrganizer" username "Test1234" password in "dev4URI" envirenment
      Given test1

