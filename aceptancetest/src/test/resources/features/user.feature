@user
Feature: Api users

  Scenario: find one user by id
    Given I have id user
    When I make a request
    Then valid the status code