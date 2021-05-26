package com.company.javapractice;

public class Student extends Human {
    private int scholarship;

    public Student(String name, int age, boolean gender, int money, int drunkenness, boolean inPub, int scolarship) {
        super(name, age, gender, money, drunkenness, inPub);
        this.scholarship = scholarship;
    }

    public void learn(int scholarship) {
        setMoney(getMoney() + scholarship);
    }

    public void learn(int howMuch, int earnMoney) {
        if (howMuch > 5) {
            earnMoney = 10;
        } else if (howMuch < 5 && howMuch > 0) {
            earnMoney = 5;
            setMoney(getMoney() + earnMoney);
        }
        System.out.println("The student learned well, so he got some extra money for it.");
    }

    public int getScholarship() {
        return scholarship;
    }

    public void setScholarship(int scholarship) {
        this.scholarship = scholarship;
    }

    @Override
    public String toString() {
        return "The student has " +
                "scholarship of " + scholarship + " dollars/month." +
                super.toString();
    }
}
