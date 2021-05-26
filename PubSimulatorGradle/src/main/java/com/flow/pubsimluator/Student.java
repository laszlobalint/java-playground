package com.flow.pubsimluator;

public class Student extends Human {
    private int scholarship;

    public Student(String name, int age, boolean gender, int money, int scholarship) {
        super(name, age, gender, money);
        this.scholarship = scholarship;
    }

    @Override
    public String toString() {
        return super.toString() + " Scholarship: " + scholarship + ".";
    }

    public int getScholarship() {
        return scholarship;
    }

    public void setScholarship(int scholarship) {
        this.scholarship = scholarship;
    }

    void learn() {
        setMoney(getMoney() + scholarship);
    }

    void learn(int howMuch) {
        setMoney(getMoney() + (howMuch * scholarship));
    }
}
