Feature: Quests

  @reg @positive 
  Scenario: Organizer should be able to create new quest end delete quest (passive quest)- test env
    Given user sign in with valid credentials "mrbrooks2" "Test1234"
    When  admin should be able to create new quest for test environment
    Then  Quest id should be created
    When  admin should be able to delete quest
    Then  admin search for deleted quest should get not found message


  Scenario: Organizer should be able to create new quest end delete quest (passive quest)- dev-Env
   Given  user sign in with valid credentials "TestingUser01" username "Test1234" password in "devURI" envirenment
    When  admin should be able to create new quest for "devURI" environment
    Then  Quest id should be created
    When  admin should be able to delete quest for "devURI" environment
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
    When User add user action in "testURI" env
    Then   completed quest' reward should be able shown in getUserQuestRewards

    @wip
    Scenario: OnChainRewards e2e
      Given user sign in with valid credentials "mrbrooks" username "Test1234" password in "devURI" envirenment
      When admin create new quest as "STANDARD"  onChain  "a937d077-e3dd-4a93-8787-1da1701704fg" tokenID  10000 amount "NEWCOMER" user type
      And user sign in with valid credentials "mrbrooks" username "Test1234" password in "devURI" envirenment
      And user add action for quest
      Then user should be able to get quest reward






