package com.youtube.java.practice.basicjava;

public class Human {
    private String name = "Test Name";
    private int age;

    public void writeName() {
        System.out.println("My name: " + this.name);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
