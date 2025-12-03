#Language: en

Feature: Login to Innosistemas
  As a user, I want to log in to the platform to access my account

  Scenario: Successful login as a student
    Given I am on the login page of Innosistemas
    When I enter my student credentials
    Then I should be logged in successfully

  Scenario: Successful login as a professor
    Given I am on the login page of Innosistemas
    When I enter my professor credentials
    Then I should be logged in successfully

  Scenario: Successful login as an administrator
    Given I am on the login page of Innosistemas
    When I enter my administrator credentials
    Then I should be logged in successfully

  Scenario: Unsuccessful login with invalid credentials
    Given I am on the login page of Innosistemas
    When I enter invalid credentials
    Then I should see an error message
