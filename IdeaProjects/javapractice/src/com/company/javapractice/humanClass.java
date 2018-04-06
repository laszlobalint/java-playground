package com.company.javapractice;

import java.io.*;

public class humanClass {

    private String name;
    private int age;
    private boolean gender;
    public static int numOfCreation = 0;
    private int money;
    private int drunkLevel = 0;
    private boolean inPub = false;

    /*
    public String getName() { return this.name; }
    public void setName() { this.name = name; }
    public void setAge() { if (age > 0) { this.age = age; } else { System.err.println("The age cannot be a negative number!"); } }
    */

    public humanClass(String name, int age, boolean gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getDrunkLevel() {
        return drunkLevel;
    }

    public void setDrunkLevel(int drunkLevel) {
        this.drunkLevel = drunkLevel;
    }

    public boolean isInPub() {
        return inPub;
    }

    public void setInPub(boolean inPub) {
        this.inPub = inPub;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        numOfCreation ++;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        numOfCreation ++;
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        numOfCreation ++;
        this.gender = gender;
    }

    public static void goToPub() {
        System.out.println("I have gone to drink!");
    }

    public humanClass() {
        name = "unnamed";
        age = 0;
        gender = false;
        numOfCreation ++;
    }

    public String toString() {
        return "Name: " + name + "; " + "Age: " + age + "; " + "Gender: " + gender + "; Message: Little puppy";
    }

    void greetings() {
        if (gender) {
            System.out.println("Hello! My name is " + name + ", and I am " + age + " years old. By the way, I am a man. How are you?");
        } else {
            System.out.println("Hello! My name is " + name + ", and I am " + age + " years old. By the way, I am a woman. How are you?");
        }
    }
}
