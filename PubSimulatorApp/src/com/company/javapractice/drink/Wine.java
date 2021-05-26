package com.company.javapractice.drink;

import com.company.javapractice.Drink;

public class Wine extends Drink {
    private String type;
    private int vintage;

    public Wine(String name, int price, int alcoholCont, String type, int vintage) {
        super(name, price, alcoholCont);
        this.type = type;
        this.vintage = vintage;
    }

    public Wine(int vintage) {
        this.vintage = vintage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getVintage() {
        return vintage;
    }

    public void setVintage(int vintage) {
        if (vintage >= 0) {
            this.vintage = vintage;
        }
    }

    @Override
    public String toString() {
        return "This wine " +
                "is " + type + " type" +
                ", and its vintage is " + vintage +
                ". " + super.toString();
    }
}
