package com.company.javapractice.Vehicle;

public class LocalTrain extends Railway {
    private int numOfStations;

    public LocalTrain(String departureStation, String destinationStation, int distance, int averageSpeed, int numOfStations) {
        super(departureStation, destinationStation, distance, averageSpeed);
        this.numOfStations = numOfStations;
    }

    @Override
    public double earliest() {
        return super.earliest() + ((getNumOfStations() - 2) * 0.1);
    }

    public int getNumOfStations() {
        return numOfStations;
    }

    public void setNumOfStations(int numOfStations) {
        if (numOfStations < 1) {
            this.numOfStations = numOfStations;
        } else {
            System.out.println("The number of stations cannot be less than two!");
        }
    }

    @Override
    public String toString() {
        return "Local train information: " +
                "number of stops (stations): " + numOfStations +
                ". " + super.toString();
    }
}
