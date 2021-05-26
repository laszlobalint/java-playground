package com.flow.pubsimluator;

public class Wine extends  Beverage{
    private int vintage;

    public Wine(int price, int alcoholPercent, int vintage) {
        super(price, alcoholPercent);
        this.vintage = vintage;
    }

    public int getVintage() {
        return vintage;
    }

    public void setVintage(int vintage) {
        this.vintage = vintage;
    }
}
