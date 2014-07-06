package com.gumtree.vbatygin;

import org.junit.Test;
import org.mockito.Mockito;

import java.io.StringReader;

import static com.gumtree.vbatygin.AddressBookTest.DATE_FORMAT;
import static org.mockito.Mockito.*;

public class AddressBookParserTest {

    @Test
    public void testParse() throws Exception {
        final AddressBook mock = mock(AddressBook.class);
        new AddressBookParser().parse(new StringReader("Bill McKnight, Male, 16/03/77\n" +
            "Paul Robinson, Male, 15/01/85"), mock);
        verify(mock).add(new Person("Bill McKnight", Gender.MALE, DATE_FORMAT.parse("16/03/1977")));
        verify(mock).add(new Person("Paul Robinson", Gender.MALE, DATE_FORMAT.parse("15/01/1985")));
    }

    @Test(expected = AddressBookParserException.class)
    public void testWrongGender() throws Exception {
        final AddressBook mock = mock(AddressBook.class);
        new AddressBookParser().parse(new StringReader("Bill McKnight, Male, 16/03/77\n" +
            "Paul Robinson, Unknown, 15/01/85"), mock);
    }

    @Test(expected = AddressBookParserException.class)
    public void testWrongDateFormat() throws Exception {
        final AddressBook mock = mock(AddressBook.class);
        new AddressBookParser().parse(new StringReader("Bill McKnight, Male, 16/03/77\n" +
            "Paul Robinson, Male, 15.01.1885"), mock);
    }

    @Test(expected = AddressBookParserException.class)
    public void testWrongRecordFormat() throws Exception {
        final AddressBook mock = mock(AddressBook.class);
        new AddressBookParser().parse(new StringReader("Bill McKnight, Male, 16/03/77\n" +
            "Paul Robinson, Male"), mock);
    }
}
