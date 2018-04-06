package com.company.javapractice.dog;

import java.util.Comparator;

public class IdComparator implements Comparator<Person> {

    @Override
    public int compare(Person person, Person t1) {
        if (t1.getId() == person.getId()) {
            return 0;
        } else if (t1.getId() > person.getId()) {
            return -1;
        } else {
            return 1;
        }
    }
}
