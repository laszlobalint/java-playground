package com.flow.pubsimluator;

public class Human {

    private String name;
    private int age;
    private boolean gender;
    private boolean inPub;
    private int money;
    private int drunkness;

    Human (String name, int age, boolean gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Human (String name, int age, boolean gender, int money) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.money = money;
        this.drunkness = 0;
        this.inPub = false;
    }

    public String toString () {
        return "Name: " + name +
                ", Age: " + age +
                ", Gender: " + gender +
                ", Money: " + money +
                ", Drunkness: " + drunkness +
                ", is in pub: " + inPub;
    }

    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }

    public boolean isInPub() {
        return inPub;
    }
    public void setInPub(boolean inPub) {
        this.inPub = inPub;
    }

    public int getDrunkness() {
        return drunkness;
    }
    public void setDrunkness(int drunkness) {
        this.drunkness = drunkness;
    }

    public String getName () {
        return this.name;
    }
    public void setName(String newName) {
        this.name = newName;
    }

    public int getAge () {
        return this.age;
    }
    public void setAge(int newAge) {
        if (newAge < 0) {
            this.age = newAge;
        } else {
            System.out.println("Age must be a positive number");
        }
    }

    public boolean isGender () {
        return gender;
    }
    public void setGender(boolean gender) {
        this.gender = gender;
    }

    void sayHi () {
        if (this.gender) {
            System.out.println("Hi! My name is " + name + ". I'm currently " + age + " old. And I'm a guy.");
        } else {
            System.out.println("Hi! My name is " + name + ". I'm currently " + age + " old. And I'm a girl.");

        }
    }

    void drink (Barkeep barkeep) {
        if (inPub) {
            money--;
            drunkness++;
            Barkeep.setDirtyGlass(Barkeep.getDirtyGlass() + 1);
            barkeep.setMoney(barkeep.getMoney() + 1);
            System.out.println(name + " just drank some Horsepiss.");
            if (drunkness >= 40) {
                sleep();
            }
        } else {
            System.out.println("Sorry, but " + name + " is sadly not in the pub.");
        }
    }

    void drink (Barkeep barkeep, Beverage beverage) {
        if (inPub) {
            money -= beverage.getPrice();
            drunkness += beverage.getAlcoholPercent();
            Barkeep.setDirtyGlass(Barkeep.getDirtyGlass() + 1);
            barkeep.setMoney(barkeep.getMoney() + beverage.getPrice());
            System.out.println(name + " just drank something fancy.");
            if (drunkness >= 40) {
                sleep();
            }
        } else {
            System.out.println("Sorry, but " + name + " is sadly not in the pub.");
        }
    }

    void sleep () {
        drunkness = 0;
        System.out.println("Zzzz - " + name + " fell asleep");
    }

    void goHome () {
        inPub = false;
        System.out.println("See you guys! " + name + " is going home.");
    }

    void goPub () {
        inPub = true;
        System.out.println("Oh happy day! " + name + " went to the pub.");
    }

    void oiCunt (Human withWhom) {
        if (Bouncer.getWorkingBouncers() == 0) {
            System.out.println(name + " got into a fight with " + withWhom.name);
        } else {
            goHome();
            System.out.println(name + " has been sent home for starting a fight with " + withWhom.name);
        }
    }
}
