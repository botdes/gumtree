package com.gumtree.vbatygin;

import java.util.Date;

public class Person {
    private final String name;
    private final Gender gender;
    private final Date dayOfBirth;

    public Person(final String name, final Gender gender, final Date dayOfBirth) {
        this.name = name;
        this.gender = gender;
        this.dayOfBirth = dayOfBirth;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public Date getDayOfBirth() {
        return dayOfBirth;
    }
}
