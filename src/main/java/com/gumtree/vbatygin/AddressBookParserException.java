package com.gumtree.vbatygin;

public class AddressBookParserException extends RuntimeException {

    public AddressBookParserException() {
    }

    public AddressBookParserException(final String s) {
        super(s);
    }

    public AddressBookParserException(final String s, final Throwable throwable) {
        super(s, throwable);
    }

    public AddressBookParserException(final Throwable throwable) {
        super(throwable);
    }
}
