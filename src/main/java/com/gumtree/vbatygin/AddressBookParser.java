package com.gumtree.vbatygin;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddressBookParser {
    private final SimpleDateFormat format = new SimpleDateFormat("dd/mm/yy");

    public AddressBook parse(final Reader reader, final AddressBook addressBook) {
        try {
            BufferedReader br = new BufferedReader(reader);
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
                    throw new AddressBookParserException("can't create address book due to exception at line " + line, e);
                }

            }
            return addressBook;
        } catch (IOException e) {
            throw new AddressBookParserException(e);
        }
    }

}
