package com.company.javapractice.Merchandise;

import com.company.javapractice.Merchandise.StoreHouse.BadQuality;

public class Fruit implements Merchandise {

    private String fruitName;

    public Fruit(String fruitName) {
        this.fruitName = fruitName;
    }

    @Override
    public boolean stillGood() throws BadQuality {
        int num = (int) Math.floor((Math.random() * 6) + 1);
        if (num == 3) {
            throw new BadQuality("This fruit is rotten, I would not like to buy it!");
        } else if ((num % 2) == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "F;" + fruitName + '\n';
        /*return "The fruit details: " +
                "Name of the fruit: " + fruitName + ". ";*/
    }
}
