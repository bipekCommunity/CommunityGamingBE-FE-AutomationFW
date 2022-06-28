Feature: UIMainPage

  @ui @smoke @wipUI
  Scenario: UserSignIn
    Given User clicks Sign In button
    When  User enters "TestingUser01" userName  "Test1234" password to fields
    And   User clicks to sigIn button
    Then  User should be able to logged in to CG

