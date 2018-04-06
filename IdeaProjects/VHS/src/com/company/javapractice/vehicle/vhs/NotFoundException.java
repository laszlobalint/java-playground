package com.company.javapractice.vehicle.vhs;

public class NotFoundException extends InvalidRentException {
    public NotFoundException() {
    }

    public NotFoundException(String s) {
        super(s);
    }
}
