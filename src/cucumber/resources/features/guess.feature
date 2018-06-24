Feature: guess
  guess number

  Scenario: create a room
    When I create a room with secret "1234"
    Then guess button will be enabled


