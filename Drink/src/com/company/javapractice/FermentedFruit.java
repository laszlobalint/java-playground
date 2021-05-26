package com.company.javapractice;

public class FermentedFruit extends Fruit implements Alcoholic {

    private double alcoholCont;

    public FermentedFruit(String kindOf, String taste, double alcoholCont) {
        super(kindOf, taste);
        this.alcoholCont = alcoholCont;
    }

    @Override
    public double howMuchAlcoholContains() {
        return alcoholCont;
    }

    @Override
    public String toString() {
        return "The fermented fruit " +
                "contains " + alcoholCont + " % of alcohol.";
    }
}
