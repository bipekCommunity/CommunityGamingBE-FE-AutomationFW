Feature: Quests

  @reg @positive @logg
  Scenario: Organizer should be able to create new quest end delete quest (passive quest)- test env
    Given user sign in with valid credentials "mrbrooks2" "Test1234"
    When  admin should be able to create new quest for test environment
    Then  Quest id should be created
    When  admin should be able to delete quest
    Then  admin search for deleted quest should get not found message

  @reg @negative
  Scenario: Organizer should not be able to delete active quest -test env
    Given user sign in with valid credentials "mrbrooks2" "Test1234"
    When  user try to delete active quest
    Then  user should get Cannot delete active quest message

  @reg @negative
  Scenario: Organizer should not be able to create quest with today or past date -test env
    Given user sign in with valid credentials "mrbrooks2" "Test1234"
    When  user try to create quest with today
    Then  user should get Start date cannot be before tomorrow"

  @reg @negative
  Scenario: Created quest name should be unique
    Given user sign in with valid credentials "mrbrooks2" "Test1234"
    When  admin should be able to create new quest for test environment
    When  admin try to create same quest again
    Then  admin should get Quest name cannot be same already created quest message

  @smoke @positive
  Scenario:Giving the Claim Right to Users CGB-387
    Given user sign in with valid credentials "mrbrooks2" "Test1234"
    And   admin create new quest for test environment
    Given user sign in with valid credentials "mrbrooks" "Test1234"
    Then   completed quest' reward should be able shown in getUserQuestRewards






