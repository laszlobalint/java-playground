package com.company.javapractice;

public class BirthdayCake extends Cake {
    private int numberOfCandles;

    public BirthdayCake(int slice, String taste, int numberOfCandles) {
        super(slice, taste);
        this.numberOfCandles = numberOfCandles;
    }

    public void info() {
        System.out.println("This birthday cake tastes " + getTaste() + ", and has " + this.slice + " slices and has " + numberOfCandles + " candles." );
    }
}
