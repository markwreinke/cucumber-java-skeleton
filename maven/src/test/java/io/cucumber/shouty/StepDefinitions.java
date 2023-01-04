package io.cucumber.shouty;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.Transpose;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jdk.nashorn.internal.objects.annotations.Where;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitions {

    private static final int DEFAULT_RANGE = 100;
    private HashMap<String, Person> people;
    private Network network;

    static class Whereabouts {
        public String name;
        public Integer location;

        public Whereabouts(String name, int location) {
            this.name = name;
            this.location = location;
        }
    }

    @DataTableType
    public Whereabouts defineWhereabouts(Map<String, String> entry) {
        return new Whereabouts(entry.get("name"), Integer.parseInt(entry.get("location")));
    }

    @Before
    public void createNetwork() {
        network = new Network(DEFAULT_RANGE);
        people = new HashMap<>();
    }

    @Given("the range is {int}")
    public void rangeIs(int range) throws Throwable {
        network = new Network(range);
    }

    @Given("A/a person named {person}")
    public void a_person_named(Person person) {
        person.setNetwork(network);
        people.put(person.name, person);
    }

    @Given("A/a person named {person} is located at {int}")
    public void personNamedLocated(Person person, int location) {
        if(!people.containsKey(person.name)) {
            person.setNetwork(network);
            person.setLocation(location);
            people.put(person.name, person);
        } else {
            people.get(person.name).setLocation(location);
        }
    }

    @Given("people are located at")
    public void people_are_located_at(List<Whereabouts> whereabouts) {

        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        for (Whereabouts whereabout : whereabouts) {
            if(people.containsKey(whereabout.name)) {
                people.get(whereabout.name).setLocation(whereabout.location);
            } else {
                people.put(whereabout.name, new Person(whereabout.name, whereabout.location, network));
            }
        }
    }

    @Given("people are located as the following")
    public void people_are_located_at_transposed(@Transpose List<Whereabouts> whereabouts) {

        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        for (Whereabouts whereabout : whereabouts) {
            if(people.containsKey(whereabout.name)) {
                people.get(whereabout.name).setLocation(whereabout.location);
            } else {
                people.put(whereabout.name, new Person(whereabout.name, whereabout.location, network));
            }
        }
    }

    @When("{person} shouts {string}")
    public void person_shouts(Person person, String message) {
        people.get(person.name).shout(message);
    }

    @When("{person} shouts the following message")
    public void sean_shouts_the_following_message(Person person, String docStringMessage) {
        people.get(person.name).shout(docStringMessage);
    }

    @Then("{person} should hear Sean's message")
    public void person_hears_message(Person personListening) {
        assertEquals(1, people.get(personListening.name).getMessagesHeard().size());
    }

    @Then("{person} should not hear Sean's message")
    public void person_doesnt_hear_message(Person personListening) {
        assertEquals(0, people.get(personListening.name).getMessagesHeard().size());
    }


    @When("{person} shouts")
    public void seanShouts(Person person) {
        people.get(person.name).shout("Hello World!");
    }

    @Then("{person} hears the following messages:")
    public void person_hears_the_following_messages(Person person, io.cucumber.datatable.DataTable expectedMessages) {
        List<List<String>> actualMessages = new ArrayList<>();
        List<String> heard = people.get(person.name).getMessagesHeard();

        for (String message : heard) {
            actualMessages.add(Collections.singletonList(message));
        }

        expectedMessages.diff(DataTable.create(actualMessages));
    }


}
