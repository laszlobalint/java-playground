package com.company.javapractice.Ticket;

public class Ticket {
    private int distance;
    private String destination;
    private boolean isValid = true;
    private double discount;
    private static int pricePerKm = 25;

    public Ticket(int distance, String destination, int discount) {
        this.distance = distance;
        this.destination = destination;
        this.discount = discount;
    }

    public double calculatePrice () {
        return Math.round(distance * pricePerKm * ((100 - discount) / 100));
    }

    public boolean useTicket () {
        return isValid = false;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public static int getPricePerKm() {
        return pricePerKm;
    }

    public static void setPricePerKm(int pricePerKm) {
        Ticket.pricePerKm = pricePerKm;
    }

    @Override
    public String toString() {
        return "Ticket information: " +
                "Destination: " + destination +
                "; Discount: " + discount + " % " +
                "; Distance: " + distance + " km " +
                "; Price: " + calculatePrice() + " HUF. ";
    }
}
