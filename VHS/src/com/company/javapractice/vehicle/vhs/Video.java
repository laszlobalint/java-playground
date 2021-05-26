package com.company.javapractice.vehicle.vhs;

import java.io.Serializable;

public class Video implements Rentable, Serializable {
    private String titleMovie;
    private boolean isRented;
    private String rentableFor; // {"One-day", "two days", "Unlimited"};
    private int ageLimit;       // {0, 12, 16, 18};

    public Video(String titleMovie, String rentableFor, int ageLimit) {
        this.titleMovie = titleMovie;
        this.isRented = true;
        this.rentableFor = rentableFor;
        this.ageLimit = ageLimit;
    }

    @Override
    public boolean rentFor(int ageOfRenter, int daysForRent) throws InvalidRentException {
        if (ageOfRenter >= ageLimit && !isRented) {
            if (daysForRent == 1) {
                isRented = true;
                return true;
            } else if (daysForRent == 2 && !rentableFor.equals("One-day")) {
                isRented = true;
                return true;
            } else if (daysForRent > 0 && rentableFor.equals("Unlimited")) {
                isRented = true;
                return true;
            } else {
                throw new InvalidRentException("Invalid renting time!");
            }
        }
        return false;
    }

    @Override
    public boolean bringBack() {
        return isRented = false;
    }

    public String getTitleMovie() {
        return titleMovie;
    }

    public void setTitleMovie(String titleMovie) {
        this.titleMovie = titleMovie;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public String getRentableFor() {
        return rentableFor;
    }

    public void setRentableFor(String rentableFor) {
        this.rentableFor = rentableFor;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(int ageLimit) {
        this.ageLimit = ageLimit;
    }

    @Override
    public String toString() {
        return "Video details - " +
                "Title of the movie: " + titleMovie +
                "; Rentable; " + isRented +
                "; Rentable for: " + rentableFor + " days" +
                "; Age limit of the movie: " + ageLimit + " years. ";
    }
}
