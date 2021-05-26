package com.company.javapractice;

public class Human {

    private String name;
    private int age;
    private boolean gender;
    private int money;
    private int drunkenness = 0;
    private boolean inPub = false;

    public Human(String name, int age, boolean gender, int money, int drunkenness, boolean inPub) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.money = money;
        this.drunkenness = drunkenness;
        this.inPub = inPub;
    }

    public void drink(Innkeeper innkeeper) {
        if (inPub) {
            this.money--;
            this.drunkenness++;
            innkeeper.setDirtyCup(innkeeper.getDirtyCup() + 1);
            innkeeper.setMoney(innkeeper.getMoney() + 1);
            System.out.println("Mmm... That was a refreshing drink.");
            if (this.drunkenness >= 40) {
                sleep();
            }
        } else {
            System.out.println(this.name + " is not in the pub!");
        }
    }

    public void drink(Innkeeper innkeeper, Drink drink) {
        if (inPub) {
            this.money -= drink.getPrice();
            innkeeper.setMoney(innkeeper.getMoney() + drink.getPrice());
            innkeeper.setDirtyCup(innkeeper.getDirtyCup() + 1);
            this.drunkenness += drink.getAlcoholCont();
            System.out.println("Mmm... That was a nice " + drink.getName() + ".");
            if (this.drunkenness >= 40) {
                sleep();
            }
        } else {
            System.out.println(this.name + " is not in the pub!");
        }
    }

    public void banter(Human withWhom) {
        if (Security.getNumOfWorkingSecurities() > 0) {
            System.out.println(this.name + " wants to argue with " + withWhom.name + ", but the security guy solves the problem. ");
            goHome();
        } else {
            System.out.println(this.name + " had a great banter, and punched " + withWhom.name + "! ");
        }
    }

    private void sleep() {
        this.drunkenness = 0;
        System.out.println("This is enough for today. " + this.name + " has gone to sleep.");
    }

    public void goHome() {
        this.inPub = false;
        System.out.println(this.name + " went home for some rest.");
    }

    public void goPub() {
        this.inPub = true;
        System.out.println("Oh yeah! " + this.name + " entered the pub!");
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getDrunkenness() {
        return drunkenness;
    }

    public void setDrunkenness(int drunkenness) {
        this.drunkenness = drunkenness;
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
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return  "\n" +
                "The guy's " +
                "name is " + name +
                ", he is " + age + " years old" +
                (gender ? ", he is male " : ", she is female ") +
                ", has " + money + " dollars" +
                ", his/her drunkenness level is " + drunkenness +
                (inPub ? ", is in the pub." : ", is not in the pub.");
    }
}
