/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonesearch.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author olehenrikvik
 */
//The purpose of this class is to store a list of persons. 
//The class should be able to give personal information based on search
//terms, both name, address and phone number. 
public class Persons {

    private List<Person> persons;

    public Persons() {
        this.persons = new ArrayList<Person>();
    }

    public String nameSearchByPhoneNumber(String phoneNumber) {
        for (Person person : persons) {
            if (phoneNumber.equals(person.getPhoneNumber())) {
                return person.getName();
            }
        }
        return "  not found";
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public void addPerson(String name) {
        persons.add(new Person(name));
    }

    public void addPersonWithAddress(String name, String street, String city) {
        persons.add(new Person(name, street, city));
    }

    public void addPersonWithPhoneNumber(String name, String phoneNumber) {
        persons.add(new Person(name, phoneNumber));
    }

    public String phoneNumberSearchByPerson(Person person) {
        return person.getPhoneNumber();
    }

    public String getPersonalInformation(Person person) {
        return "Address: " + person.getAddress() + "\nPhone number: " + String.valueOf(person.getPhoneNumber());
    }

    public void sortAlphabeticallyByName() {
        SortAlphabeticallyByName nameSorter = new SortAlphabeticallyByName();
        Collections.sort(persons, nameSorter);
    }

    public String filteredSearchByKeyword(String keyword) {
        if (!keyword.isEmpty()) {
            List<Person> matches = new ArrayList<Person>();
            for (Person person : persons) {
                if (person.getName().contains(keyword) || person.getAddress().contains(keyword)) {
                    matches.add(person);
                }
            }
            String returnString = "";
            if (!matches.isEmpty()) {
                for (Person person : matches) {
                    returnString += person.toString();
                }
                return returnString;
            }
            return " keyword not found";
        } else {
            String listOfAll = "";
            for (Person person : persons) {
                listOfAll += person.toString() + "\n";
            }
            return listOfAll;
        }
    }

    public void removePerson(Person person) {
        persons.remove(person);
    }

    public boolean personsContains(String name) {
        for (Person person : persons) {
            if (person.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
