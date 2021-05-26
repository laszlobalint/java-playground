package com.company.javapractice.vehicle.vhs;

public final class EducationVideo extends Video {

    public EducationVideo(String titleMovie, String rentableFor) {
        super(titleMovie, rentableFor, 0);
    }

    @Override
    public boolean rentFor(int ageOfRenter, int daysForRent) throws InvalidRentException {
        if (!isRented()) {
            if (daysForRent == 1) {
                setRented(true);
                return true;
            } else if (daysForRent == 2 && !getRentableFor().equals("One-day")) {
                setRented(true);
                return true;
            } else if (daysForRent > 0 && getRentableFor().equals("Unlimited")) {
                setRented(true);
                return true;
            } else {
                throw new InvalidRentException("Invalid renting time!");
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Education videos: " + super.toString();
    }
}

