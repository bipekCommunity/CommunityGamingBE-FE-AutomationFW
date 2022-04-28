Feature: Swiss Tests


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
    |32     |32                 | 4       |

  @swiss
Scenario: Run Specific Tournament
  Given user sign in with valid credentials "axieOrganizer" username "Test1234" password in "dev4URI" envirenment
  And   Enter specific tournament info "25209159-f201-4f60-9932-2d0ac40f56b8" tournamentID "a7765f99-c70b-4bfa-9160-4c80940ffc4d" bracketID for axieTournament
  And  Add 32 participant to tournament
  Given user sign in with valid credentials "axieOrganizer" username "Test1234" password in "dev4URI" envirenment
  And organizer generate first swiss bracket
  And  Organizer starts tournament
  And  Organizer enter the scores and generate next bracket for 4 round 32 participants

