package com.gumtree.vbatygin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        final String path = "./data/address-book.csv";
        AddressBook addressBook = new AddressBookParser().parse(new InputStreamReader(new FileInputStream(path)), new AddressBook());

        System.out.println("How many males are in the address book? " + addressBook.countByGender(Gender.MALE) );

        final Person oldestPerson = addressBook.getOldestPerson();
        System.out.println("Who is the oldest person in the address book? " + oldestPerson.getName() + " "
        + oldestPerson.getGender() + " " + oldestPerson.getDayOfBirth());

        System.out.println("How many days older is Bill than Paul? "
            + addressBook.howManyDaysOlder("Bill McKnight", "Paul Robinson") );
    }
}
