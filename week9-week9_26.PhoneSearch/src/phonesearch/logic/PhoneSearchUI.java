package phonesearch.logic;

import java.util.Scanner;

// nextInt is normally exclusive of the top value,
// so add 1 to make it inclusive

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author olehenrikvik
 */
public class PhoneSearchUI {

    private final Scanner reader;
    private final Persons persons;

    public PhoneSearchUI(Scanner reader, Persons persons) {
        this.reader = reader;
        this.persons = new Persons();
    }

    public void start() {
        welcomePhoneSearchPanel();
        while (true) {
            System.out.print("\ncommand: ");
            String input = reader.nextLine();
            if (!input.equals("x")) {
                if (input.equals("1")) {
                    addANumber();
                } else if (input.equals("2")) {
                    searchForANumber();
                } else if (input.equals("3")) {
                    searchForAPersonByNumber();
                } else if (input.equals("4")) {
                    addAnAddress();
                } else if (input.equals("5")) {
                    searchForPersonalInformation();
                } else if (input.equals("6")) {
                    deletePersonalInformation();
                } else if (input.equals("7")) {
                    filteredListing();
                }
            } else {
                return;
            }
        }

    }

    public void welcomePhoneSearchPanel() {
        System.out.println("phone search\n"
                + "available operations:\n"
                + " 1 add a number\n"
                + " 2 search for a number\n"
                + " 3 search for a person by phone number\n"
                + " 4 add an address\n"
                + " 5 search for personal information\n"
                + " 6 delete personal information\n"
                + " 7 filtered listing\n"
                + " x quit");
    }

    private void addANumber() {
        System.out.print("whose number: ");
        String name = reader.nextLine();
        System.out.print("number: ");
        String phoneNumber = reader.nextLine();
        if (persons.personsContains(name)) {
            for (Person person : persons.getPersons()) {
                if (person.getName().equals(name)) {
                    person.addPhoneNumber(phoneNumber);
                }
            }
        } else {
            persons.addPersonWithPhoneNumber(name, phoneNumber);
        }
    }

    private void searchForANumber() {
        System.out.print("whose number: ");
        String name = reader.nextLine();
        if (persons.personsContains(name)) {
            for (Person person : persons.getPersons()) {
                if (person.getName().equals(name)) {
                    System.out.println(person.getPhoneNumber());
                }
            }
        } else {
            notFound();
        }
    }

    private void searchForAPersonByNumber() {
        System.out.print("number: ");
        String number = reader.nextLine();
        for (Person person : persons.getPersons()) {
            if (person.getPhoneNumber().contains(number)) {
                System.out.println(" " + person.getName());
                return;
            }
        }
        System.out.println(" not found");
    }

    private void addAnAddress() {
        System.out.print("whose address: ");
        String name = reader.nextLine();
        System.out.print("street: ");
        String street = reader.nextLine();
        System.out.print("city: ");
        String city = reader.nextLine();
        if (persons.personsContains(name)) {
            for (Person person : persons.getPersons()) {
                if (person.getName().equals(name)) {
                    person.addAddress(street, city);
                }
            }
        } else {
            persons.addPersonWithAddress(name, street, city);
        }
    }

    private void searchForPersonalInformation() {
        System.out.print("whose information: ");
        String name = reader.nextLine();
        if (persons.personsContains(name)) {
            for (Person person : persons.getPersons()) {
                if (person.getName().equals(name)) {
                    System.out.println("  address: "
                            + person.getAddress()
                            + "\n"
                            + "  phone numbers:");
                    System.out.print(person.printPhoneNumbersFive());
                }
            }
        } else {
            notFound();
        }
    }

    private void deletePersonalInformation() {
        System.out.print("whose information: ");
        String name = reader.nextLine();
        Person toRemove = new Person("placeholder");
        if (persons.personsContains(name)) {
            for (Person person : persons.getPersons()) {
                if (person.getName().equals(name)) {
                    toRemove = person;
                }
            }
        }
        persons.removePerson(toRemove);
    }

    private void filteredListing() {
        System.out.print("keyword (if empty, all listed): ");
        String keyword = reader.nextLine();
        persons.sortAlphabeticallyByName();
        System.out.println(persons.filteredSearchByKeyword(keyword));
    }

    private void notFound() {
        System.out.println(" not found");
    }
}
