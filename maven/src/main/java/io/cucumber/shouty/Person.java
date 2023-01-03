package io.cucumber.shouty;

import java.util.ArrayList;
import java.util.List;

public class Person {
    public final String name;

    private Network network;
    private ArrayList<String> heardMessages = new ArrayList<>();

    public Person(String name, Network network) {
        this.name = name;
        this.network = network;
    }

    public Person(String name) {
        this.name = name;
    }

    public void setNetwork(Network newNetwork) {
        this.network = newNetwork;
    }

    public Network getNetwork() {
        return network;
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
