package com.company.javapractice.vehicle.vhs;

public class InvalidRentException extends Throwable {
    public InvalidRentException() {
    }

    public InvalidRentException(String s) {
        super(s);
    }
}
