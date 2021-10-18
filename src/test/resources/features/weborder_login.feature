@ui
Feature: Web order app login
  As a user
  I should be able to login to web order app
  # this is where repeating beginning code can go, this is how we can comment in feature file
  # whatever is in background will run before each scenario
  Background:
    Given we are at web order login page

  Scenario: User login successfully
    # Given we are at web order login page
    When we provide valid credentials
    Then we should see all order page

  Scenario: User login fail
    # Given we are at web order login page
    When we provide invalid credentials
    Then we should still be at login page
    And login error message should be present

    @bla
  Scenario: User login withs specific
    #what you put inside quotation will be string parameter value
    When user provide username "Tester" and password "test"
    Then we should see all order page

      @bla
   Scenario:  Suer log in with wrong credentials
     When user provide username "Test" and password "tester"
     Then we should still be at login page
     And login error message should be present