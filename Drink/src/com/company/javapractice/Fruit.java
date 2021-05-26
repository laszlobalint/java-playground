package com.company.javapractice;

public class Fruit {
    private String kindOf;
    private String taste;

    public Fruit(String kindOf, String taste) {
        this.kindOf = kindOf;
        this.taste = taste;
    }

    public String whatKindOf() {
        return kindOf;
    }

    public String whatKindOfTaste() {
        return taste;

    }

    @Override
    public String toString() {
        return "This fruit " +
                " is " + kindOf +
                ", and tastes " + taste + ". ";
    }
}
