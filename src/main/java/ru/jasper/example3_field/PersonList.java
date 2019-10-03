package ru.jasper.example3_field;

import java.util.ArrayList;

public class PersonList {

    public ArrayList<Person> getPersons() {
        ArrayList<Person> people = new ArrayList<>();

        people.add(produce("Ivan", "Ivanov"));
        people.add(produce("Peter", "Petrov"));
        people.add(produce("Vasily", "Vasilyev"));

        return people;
    }

    private Person produce(String name, String surname) {
        Person person = new Person();
        person.setName(name);
        person.setSurname(surname);
        return person;
    }
}
