package com.company.javapractice;

public class Wine extends AlcoholicDrink {
    private String grape;
    private String area;

    public String getGrape() {
        return grape;
    }

    public void setGrape(String grape) {
        this.grape = grape;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public double howMuchAlcoholContains() {
        return 0;
    }

    @Override
    public String toString() {
        return "This wine " +
                "was made of " + grape + " type of grape" +
                ", and was grown in " + area + " area. ";
    }
}
