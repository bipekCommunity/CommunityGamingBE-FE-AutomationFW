Feature: Swiss Tests

  @swiss
  Scenario Outline: Users Match Tests
    Given user sign in with valid credentials "axieOrganizer" username "Test1234" password in "dev4URI" envirenment
    When Organizer create <maxTeam> <maxParticipantCount>  <rounCount> Swiss tournament "dev4URI" env.
    And  Add 4096 participant to tournament
    Given user sign in with valid credentials "axieOrganizer" username "Test1234" password in "dev4URI" envirenment
    And organizer generate first swiss bracket
    And  Organizer starts tournament
    And  Organizer enter the scores and generate next bracket for 16 round 4096 participants

    Examples:
    |maxTeam|maxParticipantCount|rounCount|
    |4096     |4096             | 16       |