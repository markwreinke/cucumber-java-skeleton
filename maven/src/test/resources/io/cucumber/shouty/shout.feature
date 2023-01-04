@slow
Feature: Shout

  We can write notes or such in this space! (As long as you don't start with a Gherkin keyword)

  This is called a description.

  The Background is not commonly used


  Rule: Shouts can be heard by other users
    Scenario: Listener hears a message
      Given a person named Sean is located at 0
      And a person named Lucy is located at 50
      When Sean shouts "free bagels at Sean's"
      Then Lucy should hear Sean's message


    Scenario: Listener hears a different message
      Given the range is 100
      And a person named Sean is located at 0
      And a person named Lucy is located at 50
      When Sean shouts "Free coffee!"
      Then Lucy should hear Sean's message


  Rule: Shouts should only be heard if the listener is within range
    Scenario: Listener is within range
      Given the range is 100
      And people are located at
        | name | location |
        | Sean | 0        |
        | Lucy | 50       |
      When Sean shouts
      Then Lucy should hear Sean's message

    @focus @smoke
    Scenario: Listener is out of range
      Given the range is 100
      And people are located as the following
        | name     | Sean | Larry |
        | location | 0    | 150   |
      When Sean shouts
      Then Larry should not hear Sean's message

  Rule: Listener should be able to hear multiple shouts
    Scenario: Two shouts
      Given a person named Sean
      And a person named Lucy
      When Sean shouts "Free bagels!"
      And Sean shouts "Free toast!"
      Then Lucy hears the following messages:
        | Free bagels!  |
        | Free toast!   |

  Rule: Maximum length of a message is 180 characters
    Scenario: Message is too long
      Given a person named Sean
      And a person named Lucy
      When Sean shouts the following message
        """
        123456789012345678901234567890123456789012345678901234567890123456789012345678901234
        567890123456789012345678901234567890123456789012345678901234567890123456789012345678
        901234567890123456789012345678901234567890123456789012345678901234567890123456789012
        345678901234567890123456789012345678901234567890123456789012345678901234567890123456
        789012345678901234567890123456789012345678901234567890123456789012345678901234567890
        123456789012345678901234567890123456789012345678904123456789012345678901234567890123
        """
      Then Lucy should not hear Sean's message