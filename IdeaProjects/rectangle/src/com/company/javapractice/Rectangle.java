package com.company.javapractice;

public class Rectangle {
    private int a;
    private int b;

    public Rectangle(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public Rectangle(int a) {
        this.a = this.b = a;
    }

    public int getDistrict() {
        return (2 * this.a) + (2 * this.b);
    }

    public int getArea() {
        return this.a * this.b;
    }
}
