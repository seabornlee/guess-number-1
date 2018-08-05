Feature: guess
  guess number

  Scenario: create a room
    When I create a room with secret "1234"
    Then guess button will be enabled

  Scenario: guess win
    Given I create a room with secret "1234"
    When guess "1234"
    Then win the game

  Scenario: guess wrong
    Given I create a room with secret "1234"
    When guess "5678"
    Then show message "0A0B"