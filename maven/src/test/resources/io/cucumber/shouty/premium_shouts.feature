Feature: Premium account

  Rules:
  * Mention the word "Buy" and you lose 5 credits.
  * Over-Long messages cost 2 credits

  Background:
    Given the range is 100
    And people are located at
    | name  | location|
    | Sean  | 0       |
    | Lucy  | 100     |

  Scenario: Test Premium account features
    Given Sean has bought 30 credits
    When Sean shouts 2 over-long messages
    And Sean shouts 3 messages containing the word "buy"
    Then Lucy hears all Sean's messages
    And Sean should have 11 credits

  @todo
  Scenario: BUG #2789
    Given Sean has bought 30 credits
    When Sean shouts "buy buy buy!"
    Then Sean should have 25 credits