package com.knoldus;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

class PhoneBookTest {

    PhoneBook phoneBook = new PhoneBook();

    @Test
        // Name is Available in Map<String, Long> allContacts
    void findPhoneByNameAvailable() {
        Optional<Long> phoneBookPhoneByName = phoneBook.findPhoneByName("Kuldeep");
        Assert.assertTrue(Optional.of(8755142655L).equals(phoneBookPhoneByName));
    }

    @Test
        // Name is NOT Available in Map<String, Long> allContacts
    void findPhoneByNameNotAvailable() {
        Optional<Long> phoneBookPhoneByName = phoneBook.findPhoneByName("Kuldeep");
        Assert.assertFalse(Optional.of(1234567890L).equals(phoneBookPhoneByName));
    }

    @Test
        // Phoneno is Available in Map<String, Long> allContacts
    void findNameByPhoneNumberAvailable() {
        Optional NameByPhoneNumber = phoneBook.findNameByPhoneNumber(8755142655L);
        Assertions.assertTrue(Optional.of("Kuldeep").equals(NameByPhoneNumber));
    }

    @Test
        // Phoneno is NOT Available in Map<String, Long> allContacts
    void findNameByPhoneNumberNotAvailable() {
        Optional NameByPhoneNumber = phoneBook.findNameByPhoneNumber(1234567890L);
        Assert.assertFalse(Optional.of("Kuldeep").equals(NameByPhoneNumber));
    }
}