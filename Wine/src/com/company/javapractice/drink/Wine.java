package com.company.javapractice.drink;

public class Wine {
    private String type;
    private int vintage;

    public Wine(String type, int vintage) {
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
