package com.company.javapractice.dog;

import java.util.Comparator;

public class NameComparator implements Comparator<Person> {

    @Override
    public int compare(Person person, Person t1) {
        return person.compareTo(t1);
    }
}
