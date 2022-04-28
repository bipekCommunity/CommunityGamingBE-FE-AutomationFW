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
  And   Enter specific tournament info "77d82dae-dfec-405b-8826-1ccd4c93958d" tournamentID "37d9919c-1231-4b25-8b73-56546dad2dcf" bracketID for axieTournament
  And  Add 4096 participant to tournament
  Given user sign in with valid credentials "axieOrganizer" username "Test1234" password in "dev4URI" envirenment
  And organizer generate first swiss bracket
  And  Organizer starts tournament
  And  Organizer enter the scores and generate next bracket for 16 round 4096 participants

