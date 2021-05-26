package com.company.javapractice.Merchandise;

import com.company.javapractice.Merchandise.StoreHouse.BadQuality;

public class DairyProduct implements Merchandise {
    private long produceDate;
    private long warrant;
    private String nameOfProduct;

    public DairyProduct(long warrant, long produceDate, String nameOfProduct) {
        this.produceDate = produceDate;
        this.warrant = warrant;
        this.nameOfProduct = nameOfProduct;
    }

    @Override
    public boolean stillGood() throws BadQuality {
        if (((System.currentTimeMillis() / 1000) - produceDate) < (warrant / 1000)) {
            return true;
        } else {
            throw new BadQuality("The produce warrant date has expired!");
        }
    }

    @Override
    public String toString() {
        return "D;" + warrant + ";" + produceDate + ";" + nameOfProduct + '\n';
        /*return "Your dairy product details: " +
                "Produce date: " + produceDate +
                ", Warranty date: " + warrant +
                ", Name of the product: " + nameOfProduct + ". ";*/
    }
}
