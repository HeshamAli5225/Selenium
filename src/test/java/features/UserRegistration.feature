Feature: User Registration
  I want to check that the user can register successfully in NopeCommerce

  Scenario Outline:User Registration
    Given the user in the home page
    When clicking on register link
    And entering "<firstName>","<lastName>","<email>","<password>",
    Then the registration page displayed successfully

    Examples:
      | firstName | lastName | email | password |
      | Hesham | Ali | hesham1@gmail.com | 12345678 |
      | Hesham | Ali | hesham2@gmail.com | 12345678 |