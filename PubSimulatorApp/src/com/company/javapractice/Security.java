package com.company.javapractice;

public class Security extends Human {
    private boolean works;
    private static int numOfWorkingSecurities = 0;

    public Security(String name, int age, boolean gender, int money, int drunkenness, boolean inPub, boolean works) {
        super(name, age, gender, money, drunkenness, inPub);
        this.works = works;
    }

    public void drink(Innkeeper innkeeper, Drink drink) {
        if (isInPub() == true && isWorks() == true && drink.getAlcoholCont() == 0) {
            setMoney(getMoney() - drink.getPrice());
            innkeeper.setMoney(innkeeper.getMoney() + drink.getPrice());
            innkeeper.setDirtyCup(innkeeper.getDirtyCup() + 1);
            System.out.println("Yammy... That was a non-alcoholic " + drink.getName() + ".");
        } else if (!isWorks()) {
            drink(innkeeper, drink);
        } else {
            System.out.println("The security is not in the pub, or he is in, but cannot have alcoholic drink on duty!");
        }
    }

    public static int getNumOfWorkingSecurities() {
        return numOfWorkingSecurities;
    }

    public static void setNumOfWorkingSecurities(int numOfWorkingSecurities) {
        Security.numOfWorkingSecurities = numOfWorkingSecurities;
    }

    public void isOnDuty() {
        setNumOfWorkingSecurities(getNumOfWorkingSecurities() + 1);
        works = true;
        isInPub();
        System.out.println("The security has started to work.");
    }

    public void isOffDuty() {
        setNumOfWorkingSecurities(getNumOfWorkingSecurities() - 1);
        works = false;
        goHome();
        setNumOfWorkingSecurities(getNumOfWorkingSecurities() - 1);
        System.out.println("The security finished working.");
    }

    public boolean isWorks() {
        return works;
    }

    @Override
    public String toString() {
        return "The security guy" +
                (works ? ", is on duty. " : ", is off duty. ") +
                "There are currently " + numOfWorkingSecurities + " securities working in the pub." +
                super.toString();
    }
}
