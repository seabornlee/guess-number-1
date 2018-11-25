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
    Then show message "5678" and "0A0B"

  Scenario: guess wrong two times
    Given I create a room with secret "2345"
    And guess "5678"
    When guess "7890"
    Then show message "7890" and "0A0B"
    And show message "5678" and "0A1B"