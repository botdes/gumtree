package com.gumtree.vbatygin;

import junit.framework.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddressBookTest {
    private final SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");

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

    @Test
    public void testGetOldestEmptyBook() {
        Assert.assertNull(new AddressBook().getOldestPerson());
    }

    @Test
    public void testGetOldest() throws ParseException {
        final AddressBook addressBook = new AddressBook();
         addressBook.add(new Person("test", Gender.MALE, format.parse("20/01/1990")));
        addressBook.add(new Person("test2", Gender.MALE, format.parse("20/01/1931")));
        addressBook.add(new Person("test3", Gender.FEMALE, format.parse("20/02/1931")));
        addressBook.add(new Person("test4", Gender.MALE, format.parse("20/01/1931")));
        Assert.assertEquals("test2", addressBook.getOldestPerson().getName());
    }
}
