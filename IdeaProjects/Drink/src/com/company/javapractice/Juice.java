package com.company.javapractice;

public class Juice extends Drink {
    private String kindOf;
    private String taste;

    public Juice(Fruit fruit) {
        this.kindOf = fruit.whatKindOf().;
        this.taste = fruit.whatKindOfTaste();
    }

    @Override
    public String madeOf() {
        return "It is fruity!";
    }

    @Override
    public String tasteOf() {
        return null;
    }

    @Override
    public String toString() {
        return "This juice was squeezed of " + kindOf + " fruits" +
                ", and has a taste of " + taste + ". ";
    }
}
