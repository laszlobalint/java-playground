package com.company.javapractice.vehicle.vhs;

import com.company.javapractice.vehicle.vhs.InvalidRentException;

public interface Rentable {

    boolean rentFor(int ageOfRenter, int daysForRent) throws InvalidRentException;

    boolean bringBack();
}
