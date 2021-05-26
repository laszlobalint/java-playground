package com.company.javapractice.human;

public class Inspector extends Human {
    static int numOfFinedPeople;

    public Inspector(String name, int age, int numOfFinedPeople) {
        super(name, age);
        this.numOfFinedPeople = numOfFinedPeople;
    }

    public void inspect(Passenger passenger) {
        if (!passenger.isSeasonTicket()) {
            if (!passenger.isValidTicket()) {
                System.out.println(passenger.toString() + "The inspector has to fine the passenger who has to pay 20 pounds.");
                numOfFinedPeople++;
            }
        }
    }

    public int getNumOfFinedPeople() {
        return numOfFinedPeople;
    }

    public void setNumOfFinedPeople(int numOfFinedPeople) {
        this.numOfFinedPeople = numOfFinedPeople;
    }

    @Override
    public String toString() {
        return "The inspector's name is " + getName() +
                " , and he fined " + numOfFinedPeople + " person(s) so far.";
    }
}

