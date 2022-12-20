package io.cucumber.shouty;

import java.util.ArrayList;
import java.util.List;

public class Person {
    public final String name;
    private ArrayList<String> heardMessages = new ArrayList<>();

    public Person(String name) {
        this.name = name;
    }

    public void moveTo(Integer distance) {
    }

    public void shout(String message) {

    }

    public List<String> getMessagesHeard() {
        return heardMessages;
    }

    public void hearMessage(String message) {
        heardMessages.add(message);
    }
}
