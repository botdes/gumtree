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

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Person person = (Person) o;

        if (dayOfBirth != null ? !dayOfBirth.equals(person.dayOfBirth) : person.dayOfBirth != null) return false;
        if (gender != person.gender) return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (dayOfBirth != null ? dayOfBirth.hashCode() : 0);
        return result;
    }
}
