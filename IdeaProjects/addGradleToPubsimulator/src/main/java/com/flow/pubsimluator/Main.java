package com.flow.pubsimluator;

import sun.util.resources.cldr.bas.CalendarData_bas_CM;

public class Main {
    public static void main(String[] args) {
        Human Pisti = new Human("Pisti", 22, true, 30);
        Human Feri = new Human("Feri", 24, true, 1000);
        Human Mari = new Human("Mari", 45, false, 15);

        Barkeep Béla = new Barkeep("Béla", 15, true, 50);
        Barkeep Kati = new Barkeep("Kati", 18, false, 600);

        Bouncer Boris = new Bouncer("Boris", 30, true, 30, true);
        Bouncer Katya = new Bouncer("Katya", 28, false, 40, false);

        Student Bálint = new Student("Bálint", 27, true, 15, 50);
        Student Anna = new Student("Anna", 31, false, 200, 150);

        Beer Soproni = new Beer(3, 2);
        Beer Kőbambi = new Beer(1, 2);
        Beer Guiness = new Beer(10, 5);

        Wine CabernetSauvignon = new Wine(15, 8, 1984);
        Wine Merlot = new Wine(20, 9, 1995);
        Wine Dankó = new Wine(5, 7, 2017);

        Beverage Abszint = new Beverage(10, 10);
        Beverage Rum = new Beverage(8, 8);
        Beverage Pálinka = new Beverage(5, 7);
        Beverage RostosBarack = new Beverage(3, 0);

        Mixture Vaddisznó = new Mixture(Abszint, Rum, Pálinka, RostosBarack);
        Mixture Rumba = new Mixture(Rum, Merlot);
        Mixture NeIddMeg = new Mixture(CabernetSauvignon, Soproni, Pálinka);

        Béla.goPub();
        Kati.goPub();
        Mari.goPub();
        Pisti.goPub();
        Feri.drink(Kati, Guiness);
        Mari.drink(Béla);
        Pisti.drink(Kati, Merlot);
        Mari.drink(Béla);
        Feri.drink(Kati, Guiness);
        Boris.goPub();
        Katya.goPub();
        Kati.washingUp();
        Kati.washingUp();
        Kati.washingUp();
        Kati.washingUp();
        Boris.drink(Kati, NeIddMeg);
        Boris.drink(Béla, RostosBarack);
        Katya.drink(Béla, Rumba);
        Feri.goPub();
        Mari.drink(Béla, Dankó);
        Mari.drink(Béla);
        Mari.drink(Béla, Kőbambi);
        Mari.drink(Béla, Rumba);
        Mari.oiCunt(Kati);
        Béla.washingUp();
        Bálint.goPub();
        Anna.goPub();
        Feri.drink(Kati, Guiness);
        Feri.drink(Kati, Guiness);
        Bálint.drink(Kati, Vaddisznó);
        Bálint.learn();
        Béla.washingUp();
        Feri.drink(Kati, Guiness);
        Anna.drink(Kati, RostosBarack);
        Boris.stopWorking();
        Boris.drink(Kati, Pálinka);
        Boris.drink(Kati, Pálinka);
        Boris.drink(Kati, Pálinka);
        Boris.drink(Kati, Pálinka);
        Boris.oiCunt(Feri);
        Anna.drink(Kati, RostosBarack);
        Béla.washingUp();
        Feri.drink(Kati, Guiness);
        Kati.oiCunt(Anna);
        Pisti.drink(Kati, Merlot);
        Anna.drink(Kati, RostosBarack);
        Anna.learn(3);
        Katya.getToWork();
        Feri.drink(Kati, Vaddisznó);
        Anna.goHome();
        Bálint.goHome();
        Feri.drink(Kati, Vaddisznó);
        Feri.drink(Kati, Vaddisznó);
        Feri.drink(Kati, NeIddMeg);
        Feri.oiCunt(Boris);
        Boris.goHome();
        Béla.washingUp();
        Béla.washingUp();
        Béla.washingUp();
        Béla.washingUp();
        Béla.washingUp();
        Béla.washingUp();
        Béla.washingUp();
        Béla.washingUp();
        Béla.washingUp();
        Béla.washingUp();
        Béla.washingUp();
        Béla.washingUp();
        Béla.washingUp();
        Béla.washingUp();
        Béla.washingUp();
        Béla.washingUp();
        Béla.washingUp();
        Béla.washingUp();
        Béla.washingUp();
        Béla.washingUp();
        Pisti.goHome();
        Kati.goHome();
        System.out.println(Pisti);
        System.out.println(Feri);
        System.out.println(Mari);
        System.out.println(Béla);
        System.out.println(Kati);
        System.out.println(Bálint);
        System.out.println(Anna);
        System.out.println(Boris);
        System.out.println(Katya);
    }
}
