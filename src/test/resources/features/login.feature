@Login
  Feature: As a Zenity collaborator I want to login so that I could access the intranet

    Scenario Outline: Login with valid credentials
      Given user is on the login page
      When  user is logging-in with "<username>" "<password>"
      Then  he should be at the home page
      Examples:
        | username | password |
        | tester1  | tester1  |