package com.flow.pubsimluator;

public class Bouncer extends Human {
    private boolean working;
    private static int workingBouncers = 0;

    public Bouncer(String name, int age, boolean gender, int money, boolean working) {
        super(name, age, gender, money);
        this.working = working;
        if (this.working) {
            workingBouncers++;
        }
        super.goPub();
    }

    @Override
    public String toString() {
        return super.toString() + " Working: " + working + ".";
    }

    public static int getWorkingBouncers() {
        return workingBouncers;
    }

    public static void setWorkingBouncers(int workingBouncers) {
        Bouncer.workingBouncers = workingBouncers;
    }

    public boolean isWorking() {
        return working;
    }

    public void setWorking(boolean working) {
        this.working = working;
        if (this.working) {
            workingBouncers++;
        } else {
            workingBouncers--;
        }
    }

    void getToWork() {
        setWorking(true);
    }

    void stopWorking() {
        setWorking(false);
    }

    @Override
    void drink(Barkeep barkeep) {
        if (!isWorking()) {
            super.drink(barkeep);
        } else {
            System.out.println("Sadly " + super.getName() + " is currently on the job.");
        }
    }

    @Override
    void drink(Barkeep barkeep, Beverage beverage) {
        if (!isWorking() || beverage.getAlcoholPercent() == 0) {
            super.drink(barkeep, beverage);
        } else {
            System.out.println("Sadly " + super.getName() + " is currently on the job.");
        }
    }
}
