package com.company.javapractice.vehicle;

public class NoFuelException extends BrokenException {

    public NoFuelException() {
    }

    public NoFuelException(String s) {
        super(s);
    }
}
