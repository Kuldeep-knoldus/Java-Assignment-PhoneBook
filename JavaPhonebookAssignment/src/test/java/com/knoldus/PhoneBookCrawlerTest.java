package com.knoldus;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Optional;

class PhoneBookCrawlerTest {

    PhoneBook phoneBook = new PhoneBook();
    PhoneBookCrawler phoneBookCrawler = new PhoneBookCrawler(phoneBook);

    @Test
    void findPhoneByNameAndPunishIfNothingFound() {
        Optional expectedPhoneno = phoneBookCrawler.findPhoneByNameAndPunishIfNothingFound("Kuldeep");
        Assert.assertEquals(Optional.of(8755142655L), expectedPhoneno);
    }

    @Test
    void findPhoneByNameAndPrintPhoneBookIfNothingFound() {
        Optional expectedPhoneno = phoneBookCrawler.findPhoneByNameAndPrintPhoneBookIfNothingFound("Kuldeep");
        Assert.assertEquals(Optional.of(8755142655L), expectedPhoneno);
    }

    @Test
    void findPhoneByNameAndPunishIfNothingFoundUsingStream() {
        Optional expectedPhoneno = phoneBookCrawler.findPhoneByNameAndPunishIfNothingFoundUsingStream("Pradeep");
        Assert.assertEquals(Optional.of("Phoneno not found"), expectedPhoneno);
    }

    @Test
    void findPhoneByNameAndPrintPhoneBookIfNothingFoundUsingStream() {
        Optional expectedPhoneno = phoneBookCrawler.findPhoneByNameAndPrintPhoneBookIfNothingFoundUsingStream("Pradeep");
        Assert.assertEquals(Optional.of(phoneBook), expectedPhoneno);
    }

    @Test
    public void findPhoneNumberByNameOrNameByPhoneNumber() {

        Optional expectedPhoneno = phoneBookCrawler.findPhoneNumberByNameOrNameByPhoneNumber("Kuldeep", 8755142655L);
        Assert.assertEquals(Optional.of(8755142655L), expectedPhoneno);
    }
}