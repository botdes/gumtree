package com.gumtree.vbatygin;

public class AddressBook {

    private int maleCount = 0;
    private int femaleCount = 0;
    private Person oldest = null;

    public int countByGender(Gender gender) {
       return gender == Gender.MALE ? maleCount : femaleCount;
    }

    public Person getOldestPerson() {
        return oldest;
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

        if (oldest == null || person.getDayOfBirth().before(oldest.getDayOfBirth())) {
            oldest = person;
        }


    }
}
