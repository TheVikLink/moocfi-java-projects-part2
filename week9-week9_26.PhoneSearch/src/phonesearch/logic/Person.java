/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonesearch.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author olehenrikvik
 */
//The purpose of this class is to store personal information,
//such as name, phone number and address. 
public class Person {

    private String name;
    private String phoneNumber;
    private Map<String, String> address;
    private ArrayList<String> phoneNumbers;

//    }
    public Person(String name) {
        this.phoneNumber = phoneNumber;
        this.address = new HashMap<String, String>();
        this.name = name;
        this.phoneNumbers = new ArrayList<String>();
    }

    public Person(String name, String street, String city) {
        this.address = new HashMap<String, String>();
        this.address.put("street", street);
        this.address.put("city", city);
        this.name = name;
    }

    public Person(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.phoneNumbers = new ArrayList<String>();
        phoneNumbers.add(phoneNumber);
    }

    public void addAddress(String street, String city) {
        try {
            this.address.put("street", street);
            this.address.put("city", city);
        } catch (Exception e) {
            this.address = new HashMap<String, String>();
            this.address.put("street", street);
            this.address.put("city", city);
        }
    }

    public void addPhoneNumber(String phoneNumber) {
        try {
            this.phoneNumber = phoneNumber;
            phoneNumbers.add(phoneNumber);
        } catch (Exception e) {
            this.phoneNumbers = new ArrayList<String>();
            this.phoneNumber = phoneNumber;
            phoneNumbers.add(phoneNumber);
        }
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        if (phoneNumbers.size() == 0) {
            return "  not found";
        } else {
            return printPhoneNumbersTwo();
        }
    }

    public String getAddress() {
        try {
            return address.get("street") + " " + address.get("city");
        } catch (Exception e) {
            return " address unknown";
        }
    }

    public String printPhoneNumbersTwo() {
        try {
            String phoneNumberList = "";
            for (String phoneNumber : phoneNumbers) {
                phoneNumberList += " " + phoneNumber + "\n";
            }
            return phoneNumberList.substring(0, phoneNumberList.length() - 1);
        } catch (Exception e) {
            return "  phone number not found";
        }
    }

    public String printPhoneNumbersFive() {
        try {
            String phoneNumberList = "";
            for (String phoneNumber : phoneNumbers) {
                phoneNumberList += "   " + phoneNumber + "\n";
            }
            return phoneNumberList;
        } catch (Exception e) {
            return "  phone number not found";
        }
    }

    public String printPhoneNumbersSeven() {
        try {
            String phoneNumberList = "  phone numbers:"
                    + "\n";
            for (String phoneNumber : phoneNumbers) {
                phoneNumberList += "   " + phoneNumber + "\n";
            }
            return phoneNumberList;
        } catch (Exception e) {
            return "  phone number not found";
        }
    }

    @Override
    public String toString() {
        return getName() + "\n"
                + "  address: "
                + getAddress()
                + "\n"
                + printPhoneNumbersSeven();
    }

}
