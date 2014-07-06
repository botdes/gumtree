package com.gumtree.vbatygin;

public class AddressBook {

    private int maleCount = 0;
    private int femaleCount = 0;

    public Person getOldestPerson() {
        throw new UnsupportedOperationException();
    }

    public int countByGender(Gender gender) {
       return gender == Gender.MALE ? maleCount : femaleCount;
    }

    public int howManyDaysOlder(String firstPerson, String secondPerson) {
        throw new UnsupportedOperationException();
    }

    public void add(final Person person) {
        if (person.getGender() == Gender.MALE) {
            maleCount++;
        } else {
            femaleCount ++;
        }
    }
}
