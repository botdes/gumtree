package com.gumtree.vbatygin;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddressBookParser {
    private final SimpleDateFormat format = new SimpleDateFormat("dd/mm/yy");

    public AddressBook parse(final FileInputStream fileInputStream) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));
            AddressBook addressBook = new AddressBook();
            for(String line; (line = br.readLine()) != null; ) {
                try {
                    final String[] tokens = line.split(", ");
                    if (tokens.length != 3) {
                        throw new IllegalArgumentException("expected 3 tokens in line " + line);
                    }
                    String name = tokens[0];
                    Gender gender = Gender.valueOf(tokens[1].toUpperCase());
                    Date date = format.parse(tokens[2]);
                    addressBook.add(new Person(name, gender, date));
                } catch (Exception e) {
                    throw new RuntimeException("can't create address book due to exception at line " + line, e);
                }

            }
            return addressBook;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
