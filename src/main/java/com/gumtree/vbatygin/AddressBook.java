package com.gumtree.vbatygin;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class AddressBook {

    private int maleCount = 0;
    private int femaleCount = 0;
    private Person oldest = null;
    private final Map<String, Date> nameToDayOfBirth = new HashMap<String, Date>();

    public int countByGender(Gender gender) {
        return gender == Gender.MALE ? maleCount : femaleCount;
    }

    public Person getOldestPerson() {
        return oldest;
    }

    public long howManyDaysOlder(String firstPerson, String secondPerson) {
        final Date firstDay = getDate(firstPerson);
        final Date secondDay = getDate(secondPerson);
        return TimeUnit.MILLISECONDS.toDays(secondDay.getTime() - firstDay.getTime());
    }

    private Date getDate(final String person) {
        final Date date = nameToDayOfBirth.get(person);
        if (date == null) {
            throw new IllegalArgumentException("person do not exist in address book " + person);
        }
        return date;
    }

    public void add(final Person person) {
        if (person == null) {
            throw new IllegalArgumentException("person must not be null");
        }
        if (nameToDayOfBirth.containsKey(person.getName())) {
            throw new IllegalArgumentException("person with name " + person.getName() + " already exist in addressBook");
        }
        if (person.getGender() == Gender.MALE) {
            maleCount++;
        } else {
            femaleCount++;
        }

        if (oldest == null || person.getDayOfBirth().before(oldest.getDayOfBirth())) {
            oldest = person;
        }
        nameToDayOfBirth.put(person.getName(), person.getDayOfBirth());
    }
}
