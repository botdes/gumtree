package com.gumtree.vbatygin;

import junit.framework.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddressBookTest {
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/mm/yyyy");

    @Test(expected = IllegalArgumentException.class)
    public void testAddNull() {
        final AddressBook addressBook = new AddressBook();
        addressBook.add(null);
    }

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
        addressBook.add(new Person("test", Gender.MALE, DATE_FORMAT.parse("20/01/1990")));
        addressBook.add(new Person("test2", Gender.MALE, DATE_FORMAT.parse("20/01/1931")));
        addressBook.add(new Person("test3", Gender.FEMALE, DATE_FORMAT.parse("20/02/1931")));
        addressBook.add(new Person("test4", Gender.MALE, DATE_FORMAT.parse("20/01/1931")));
        Assert.assertEquals("test2", addressBook.getOldestPerson().getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddEqualNames() {
        final AddressBook addressBook = new AddressBook();
        addressBook.add(new Person("test", Gender.MALE, new Date()));
        addressBook.add(new Person("test", Gender.FEMALE, new Date()));
    }

    @Test
    public void testHowManyDaysOlder() throws ParseException {
        final AddressBook addressBook = new AddressBook();
        addressBook.add(new Person("test", Gender.MALE, DATE_FORMAT.parse("20/01/1990")));
        addressBook.add(new Person("test2", Gender.MALE, DATE_FORMAT.parse("20/01/1991")));
        Assert.assertEquals(365, addressBook.howManyDaysOlder("test", "test2"));
    }

    @Test
    public void testHowManyDaysOlderReversed() throws ParseException {
        final AddressBook addressBook = new AddressBook();
        addressBook.add(new Person("test", Gender.MALE, DATE_FORMAT.parse("20/01/1990")));
        addressBook.add(new Person("test2", Gender.MALE, DATE_FORMAT.parse("20/01/1991")));
        Assert.assertEquals(-365, addressBook.howManyDaysOlder("test2", "test"));
    }

    @Test
    public void testHowManyDaysOlderEqual() throws ParseException {
        final AddressBook addressBook = new AddressBook();
        addressBook.add(new Person("test", Gender.MALE, DATE_FORMAT.parse("20/01/1991")));
        addressBook.add(new Person("test2", Gender.MALE, DATE_FORMAT.parse("20/01/1991")));
        Assert.assertEquals(0, addressBook.howManyDaysOlder("test2", "test"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHowManyDaysNonexistentFirst() throws ParseException {
        final AddressBook addressBook = new AddressBook();
        addressBook.add(new Person("test", Gender.MALE, DATE_FORMAT.parse("20/01/1991")));
        addressBook.howManyDaysOlder("stranger", "test");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHowManyDaysNonexistentSecond() throws ParseException {
        final AddressBook addressBook = new AddressBook();
        addressBook.add(new Person("test", Gender.MALE, DATE_FORMAT.parse("20/01/1991")));
        addressBook.howManyDaysOlder("test", "stranger");
    }

}
