package com.company.javapractice;

public abstract class AlcoholicDrink extends Drink implements Alcoholic {

    private String tasteOf;
    private double alcoholCont;

    public AlcoholicDrink(String tasteOf, double alcoholCont) {
        this.tasteOf = tasteOf;
        this.alcoholCont = alcoholCont;
    }

    public AlcoholicDrink() {

    }

    @Override
    public String madeOf() {
        return null;
    }

    @Override
    public String tasteOf() {
        return null;
    }

    @Override
    public String toString() {
        return "This alcoholic drink " +
                "has a taste of " + tasteOf +
                ", and contains " + alcoholCont + " % of alcohol.";
    }
}
