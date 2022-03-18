Feature: Login Page's Tests

  @smoke @positive
  Scenario: User should be able to login with valid credentials
    Given user sign in with valid credentials "mrbrooks" "Test1234"
    Then Status Code Should be 200


  @smoke @negative
  Scenario Outline: User should not be able to log in with an invalid username
   Given user try to sign in invalid userName "<username>" "Test1234"
   Then  User should get "not Found" message
   Examples:
     |username|
     |mrbrook |
     |        |
     |test1234|
     |123     |

 @smoke @negative
  Scenario Outline:User should not be able to log in with an invalid password
    Given user try to sign in invalid password "mrbrooks2" "<password>"
    Then  User should get "Bad credentials" message
    Examples:
      |password  |
      |mrbrooks2 |
      |TEST1234  |
      |          |
      |Test123   |

  @smoke @positive
  Scenario: Get My Profile
    Given user sign in with valid credentials "mrbrooks2" "Test1234"
    When User send request for my profile request
    Then Status Code Should be 200


  Scenario: User should be able to change password
    Given user sign in with valid credentials new password
    When user send request for Change Password
    Then response should be "true"
    And  user should not be able to login with old password
    And  user sign in with new password
    And  user re-enters old password



