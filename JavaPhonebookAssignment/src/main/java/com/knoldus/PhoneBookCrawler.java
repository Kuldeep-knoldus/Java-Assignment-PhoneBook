package com.knoldus;

import java.util.Map;
import java.util.Optional;

public class PhoneBookCrawler {
    private PhoneBook phoneBook = new PhoneBook();

    /**
     * Parameterised Constructor
     *
     * @param phoneBook : PhoneBook  type
     */
    public PhoneBookCrawler(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    /**
     * Exercise 2:
     * Implementing findPhoneByNameAndPunishIfNothingFound in PhoneBookCrawler that uses
     * the implementation from exercise 1
     *
     * @param name : String used to take user's name
     * @return Phoneno, if found else return "Phoneno not found"
     */
    public Optional<Long> findPhoneByNameAndPunishIfNothingFound(String name) {
        return Optional.of(phoneBook.findPhoneByName(name)).orElse(Optional.of("Phoneno not found"));
    }

    /**
     * Exercise 3:
     * Implementing findPhoneByNameAndPrintPhoneBookIfNothingFound in PhoneBookCrawler that uses
     * the implementation from exercise 1
     *
     * @param name : String used to take user's name
     * @return Phoneno, if found else return phonebook
     */
    public Optional<Long> findPhoneByNameAndPrintPhoneBookIfNothingFound(String name) {
        return Optional.of(phoneBook.findPhoneByName(name)).orElseGet(
                () -> Optional.of(phoneBook.toString()));
    }

    /**
     * Exercise 5
     * reimplementing exercise 2 using streams instead of using PhoneBook's findPhoneNumberByName
     */
    public Optional findPhoneByNameAndPunishIfNothingFoundUsingStream(String name) {

        Optional<Long> output = null;
        output = phoneBook.getAllContacts().entrySet().stream()
                .filter(map -> name.equals(map.getValue()))
                .map(Map.Entry::getValue)
                .findAny();
        if (output.isPresent())
            return Optional.of(output.get());
        return Optional.of("Phoneno not found");

    }

    /**
     * Exercise 6
     * reimplementing exercise 3 using streams instead of using PhoneBook's findPhoneNumberByName
     */
    public Optional findPhoneByNameAndPrintPhoneBookIfNothingFoundUsingStream(String name) {
        Optional<Long> output = null;
        output = phoneBook.getAllContacts().entrySet().stream()
                .filter(m -> name.equals(m.getValue()))
                .map(Map.Entry::getValue)
                .findAny();
        if (output.isPresent())
            return Optional.of(output.get());
        return Optional.of(phoneBook);

    }

    public Optional findPhoneNumberByNameOrNameByPhoneNumber(String name, long phoneNumber) {
        Optional result = phoneBook.allContacts.entrySet().stream()
                .filter(e -> name.equals(e.getKey()))
                .map(Map.Entry::getValue)
                .findFirst();

        return (result.isPresent()) ? result : phoneBook.allContacts.entrySet().stream()
                .filter(e -> phoneNumber == e.getValue())
                .map(Map.Entry::getValue)
                .findFirst();
    }
}