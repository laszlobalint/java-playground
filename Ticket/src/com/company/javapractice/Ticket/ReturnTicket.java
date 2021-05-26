package com.company.javapractice.Ticket;

public class ReturnTicket extends Ticket {
    private int timesUsed = 0;

    public ReturnTicket(int distance, String destination, int discount) {
        super(distance, destination, discount);
        this.timesUsed = timesUsed;
    }

    public int getTimesUsed() {
        return timesUsed;
    }

    public void setTimesUsed(int timesUsed) {
        this.timesUsed = timesUsed;
    }

    @Override
    public boolean isValid() {
        if (timesUsed == 2) {
            return false;
        } return true;
    }

    @Override
    public double calculatePrice() {
        return super.calculatePrice() * 2;
    }

    @Override
    public String toString() {
        return "Type: return ticket; " +
                "Ticket information: " +
                "Destination: " + getDestination() +
                "; Discount: " + getDiscount() + " % " +
                "; Distance: " + getDistance() * 2 + " km " +
                "; Price: " + calculatePrice() + " HUF. ";
    }
}
