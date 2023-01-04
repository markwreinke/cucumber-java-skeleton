package io.cucumber.shouty;

import java.util.ArrayList;
import java.util.List;

public class Person {
    public final String name;
    private int location = 0;
    private int credits = 0;

    private Network network;
    private ArrayList<String> heardMessages = new ArrayList<>();
    private ArrayList<String> shoutedMessages = new ArrayList<>();

    public Person(String name, int location, Network network) {
        this.name = name;
        this.location = location;
        setNetwork(network);
    }

    public Person(String name, int location) {
        this.name = name;
        this.location = location;
    }

    public Person(String name) {
        this.name = name;
    }

    public void setNetwork(Network newNetwork) {
        this.network = newNetwork;
        this.network.subscribe(this);
    }

    public Network getNetwork() {
        return network;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public void shout(String message) {
        network.broadcast(message, location);
        if (heardMessages.contains(message)) {
            shoutedMessages.add(message);
        }
    }

    public int getCredits() {
        return credits;
    }

    public void addCredits(int numCredits) {
        this.credits += numCredits;
    }

    public void removeCredits(int numCreditsToRemove) {
        this.credits -= numCreditsToRemove;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public List<String> getMessagesHeard() {
        return heardMessages;
    }

    public List<String> getMessagesShouted() {
        return shoutedMessages;
    }

    public void hearMessage(String message) {
        heardMessages.add(message);
    }
}
