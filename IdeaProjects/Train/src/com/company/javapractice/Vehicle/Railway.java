package com.company.javapractice.Vehicle;

public class Railway implements Comparable<Railway> {
    private String departureStation;
    private String destinationStation;
    private float distance;
    private int averageSpeed;

    public Railway(String departureStation, String destinationStation, int distance, int averageSpeed) {
        this.departureStation = departureStation;
        this.destinationStation = destinationStation;
        this.distance = distance;
        this.averageSpeed = averageSpeed;
    }

    public Railway() {
    }

    public double earliest() {
        return this.getDistance() / this.getAverageSpeed();
    }

    public String getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(String departureStation) {
        this.departureStation = departureStation;
    }

    public String getDestinationStation() {
        return destinationStation;
    }

    public void setDestinationStation(String destinationStation) {
        this.destinationStation = destinationStation;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public int getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(int averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    @Override
    public String toString() {
        return "Railway information: " +
                "Departure: " + departureStation +
                ", Destination: " + destinationStation +
                " (distance: " + distance + " km)" +
                ", average speed: " + averageSpeed + " km/h." + '\n';
    }

    @Override
    public int compareTo(Railway railway) {
        if (this.earliest() == railway.earliest()) {
            return 0;
        } else if (this.earliest() > railway.earliest()) {
            return 1;
        } else {
            return -1;
        }
    }
}


