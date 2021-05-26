package com.company.javapractice.Merchandise.StoreHouse;

public class BadQuality extends Throwable {

    public BadQuality() {
        super();
    }

    public BadQuality(String message) {
        super(message);
        System.out.println();
    }
}
