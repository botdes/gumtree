package com.gumtree.vbatygin;

import junit.framework.Assert;
import org.junit.Test;

import java.util.Date;

public class AddressBookTest {

    @Test
    public void testMaleCountEmptyBook() {
        Assert.assertEquals(0, new AddressBook().countByGender(Gender.MALE));
    }

    @Test
    public void testMaleCount() {
        final AddressBook addressBook = new AddressBook();
        addressBook.add(new Person("test", Gender.MALE, new Date()));
        addressBook.add(new Person("test2", Gender.MALE, new Date()));
        addressBook.add(new Person("test3", Gender.FEMALE, new Date()));
        addressBook.add(new Person("test4", Gender.MALE, new Date()));
        Assert.assertEquals(3, addressBook.countByGender(Gender.MALE));
        Assert.assertEquals(1, addressBook.countByGender(Gender.FEMALE));
    }
}
