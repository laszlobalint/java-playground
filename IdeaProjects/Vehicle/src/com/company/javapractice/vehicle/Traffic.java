package com.company.javapractice.vehicle;

import java.util.ArrayList;

public class Traffic {

    public static void main(String[] args) {
        ArrayList<Vehicle> vehicles = new ArrayList <>();
        Bicycle mountainbike = new Bicycle(10, 0);
        Bicycle racebike = new Bicycle(8, 0);
        racebike.setBroken(true);
        Car audi = new Car(1200, 220);
        Car mercedes = new Car(1500, 250);
        audi.fillingFuel(20);
        vehicles.add(mountainbike);
        vehicles.add(racebike);
        vehicles.add(audi);
        vehicles.add(mercedes);
        for (int i = 0; i < vehicles.size(); i++) {
            try {
                vehicles.get(i).starts();
            } catch (BrokenException e) {
                e.printStackTrace();
            }
            System.out.println(vehicles.get(i).toString());
        }
        Vehicle lada = new Car(850, 110);
        while (true) {
            try {
                lada.starts();
            } catch (BrokenException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
