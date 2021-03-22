package com.knoldus;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PhoneBook {
    /**
     * initializing Map<String, Long> contacts
     * String:- Name of User
     * Long:- PhoneNo
     */
    public Map<String, Long> contacts = new HashMap<>() {
        {
            put("Kuldeep", 8755142655L);
            put("Deepak", 9876543210L);
            put("Vikas", 9531764201L);
            put("Rishabh", 9630258741L);
        }
    };

    // contacts are stored in a Map<String, Long> allContacts
    Map<String, Long> allContacts = contacts;

    // Default constructor
    public PhoneBook() {
    }

    /**
     * getter
     *
     * @return allContacts of type Map<String, Long>
     */
    public Map<String, Long> getAllContacts() {
        return allContacts;
    }

    /**
     * Exercise 4
     * Did you receive a Hello message from the PhoneBook's toString method?
     * If yes, reimplement the exercise 3 to avoid it get's printed.
     * If no, reimplement exercise 3 to have it actually printed.
     *
     * @Override toString()
     */

    @Override
    public String toString() {
        System.out.println("Hello! ");
        return "PhoneBook { " +
                "allContacts= " + allContacts +
                " }";
    }

    /**
     * Exercise 1:
     * Implementing findPhoneByName in PhoneBook class that returns an optional. (No streams)
     *
     * @param name : String type, gets the Name of User
     * @return phoneno : Optional<Long> type
     */
    public Optional findPhoneByName(String name) {
        if (allContacts.containsKey(name)) {
            return Optional.of(allContacts.get(name));
        }
        return Optional.empty();
    }

    /**
     * Exercise 7:
     * Implementing findNameByPhoneNumber in PhoneBook class that returns an optional. Implement findPhoneNumberByNameOrNameByPhoneNumber
     * in PhoneBookCrawler class. First search the phone book by name. If that returns nothing search the phone book by phone number.
     *
     * @param phoneno : Long type
     * @return name: String type
     */
    public Optional findNameByPhoneNumber(Long phoneno) {
        for (Map.Entry<String, Long> entry : allContacts.entrySet()) {
            if (entry.getValue().equals(phoneno)) {
                return Optional.of(entry.getKey());
            }
        }
        return Optional.empty();
    }
}
