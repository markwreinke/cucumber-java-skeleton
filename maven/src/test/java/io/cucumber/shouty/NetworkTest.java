package io.cucumber.shouty;

import io.cucumber.java.Before;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class NetworkTest {
    private int range = 100;
    private Network network = new Network(range);
    private String message = "Free bagels!";

//    @Test
//    public void broadcasts_a_message_to_a_listener_within_range() {
//        int seanLocation = 0;
//        Person lucy = mock(Person.class);
//        network.subscribe(lucy);
//        network.broadcast(message, seanLocation);
//        verify(lucy).hear(message);
//    }
}
