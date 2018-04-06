package com.company.javapractice;

public class CakeMain {
    public static void main(String[] args) {
        Cake strawberry = new Cake(12, "strawberry");
        Cake chocolate = new Cake(8, "chocolate");
        Cake champagne = new Cake(16, "champagne");
        Cake birthday = new BirthdayCake(16, "caramel", 20);

        Cake[] cakeArray = new Cake[4];
        cakeArray[0] = strawberry;
        cakeArray[1] = chocolate;
        cakeArray[2] = champagne;
        cakeArray[3] = birthday;

        for (int i = 0; i < cakeArray.length; i++) {
            cakeArray[i].info();
        }
    }
}
