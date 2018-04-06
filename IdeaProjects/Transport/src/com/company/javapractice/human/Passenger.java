package com.company.javapractice.human;

public class Passenger extends Human {
    int tickets;
    boolean isSeasonTicket = false;
    boolean isValidTicket = false;

    public Passenger(String name, int age, int tickets, boolean seasonTicket) {
        super(name, age);
        this.tickets = tickets;
        this.isSeasonTicket = seasonTicket;
    }

    public void getOn() {
        if (isSeasonTicket == false && tickets > 0) {
            tickets--;
            isValidTicket = true;
            System.out.println(getName() + " got on the bus, and validated a ticket.");
        } else if (isSeasonTicket == false && tickets == 0) {
            System.out.println(getName() + " got on the bus but does not have a season ticket, neither a ticket, so maybe he/she will get fined.");
        } else if (isSeasonTicket == true) {
            System.out.println(getName() + " got on the but with a valid season ticket.");
        }
    }

    public int getTickets() {
        return tickets;
    }

    public void setTickets(int tickets) {
        this.tickets = tickets;
    }

    public boolean isSeasonTicket() {
        return isSeasonTicket;
    }

    public void setSeasonTicket(boolean seasonTicket) {
        isSeasonTicket = seasonTicket;
    }

    public boolean isValidTicket() {
        return isValidTicket;
    }

    public void setValidTicket(boolean validTicket) {
        isValidTicket = validTicket;
    }

    @Override
    public String toString() {
        return "The passenger " +
                "has " + tickets + " tickets" +
                (isSeasonTicket ? ", has a season ticket" : ", does not have a season ticket") +
                (isValidTicket ? ", and has a valid ticket. " : ", and does not have a valid ticket. ") +
                super.toString();
    }
}
