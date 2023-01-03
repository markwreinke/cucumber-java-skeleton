Feature: Shout

  We can write notes or such in this space! (As long as you don't start with a Gherkin keyword)

  This is called a description.

  The Background is not commonly used

  Background:
    Given A person named Lucy
    And a person named Sean

  Rule: Shouts can be heard by other users
    Scenario: Listener hears a message
      When Sean shouts "free bagels at Sean's"
      Then Lucy hears Sean's message


    Scenario: Listener hears a different message
      When Sean shouts "Free coffee!"
      Then Lucy hears Sean's message


  Rule: Shouts should only be heard if the listener is within range
    Scenario: Listener is within range

    Scenario: Listener is out of range