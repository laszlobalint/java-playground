package com.company.javapractice.dog;

import java.io.Serializable;

public class Person implements Serializable, Comparable<Person> {
    private int id;
    private String name;
    private int age;
    private int tailWiggle;

    public Person(int id, String name, int age, int tailWiggle) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.tailWiggle = tailWiggle;
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return  name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTailWiggle() {
        return tailWiggle;
    }

    public void setTailWiggle(int tailWiggle) {
        this.tailWiggle = tailWiggle;
    }

    @Override
    public int compareTo(Person person) {
        if (name.equals(person.name)) {
            return 0;
        } else if (name.compareTo(person.name) > 0) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", tailWiggle=" + tailWiggle +
                '}';
    }
}
