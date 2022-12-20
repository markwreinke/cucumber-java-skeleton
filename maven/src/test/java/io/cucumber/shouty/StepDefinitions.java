package io.cucumber.shouty;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitions {

    private Person lucy = new Person("Lucy");
    private Person sean = new Person("Sean");
    private String messageFromSean;

    @Given("{person} is located/standing {int} metre(s) from Sean")
    public void lucy_is_located_metres_from_sean(Person person, Integer distance) {
        person.moveTo(distance);
    }

    @When("Sean shouts {string}")
    public void sean_shouts(String message) {
        sean.shout(message);
        lucy.hearMessage(message);
        messageFromSean = message;
    }
    @Then("Lucy hears Sean's message")
    public void lucy_hears_sean_s_message() {
        assertEquals(asList(messageFromSean), lucy.getMessagesHeard());
    }


}
