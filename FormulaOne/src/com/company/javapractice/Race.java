package com.company.javapractice;

import com.company.javapractice.Vehicle.Car;
import com.company.javapractice.Vehicle.F1Auto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Race {

    public static void main(String[] args) {

    F1Auto alonso = new F1Auto(850, 370, "McLaren", "Alonso", 0.9f);
    F1Auto verstappen = new F1Auto(850, 380, "RedBull", "Verstappen", 0.95f);
    F1Auto vettel = new F1Auto(900, 385, "Ferrari", "Vettel", 0.90f);
    F1Auto hamilton = new F1Auto(920, 380, "Mercedes", "Hamilton", 0.85f);
    F1Auto stroll = new F1Auto(920, 370, "Williams", "Stroll", 0.8f);

    F1Auto[] cars = {alonso, verstappen, vettel, hamilton, stroll};
    List<F1Auto> carList = Arrays.asList(cars);
    Collections.sort(carList);
    System.out.println("Sorted in a better way:");
    System.out.println(carList);
    //sortCars(cars);
    printCar(cars);
}

    public static void sortCars (Car[] cars) {
        boolean sorted = false;
        Car car;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < cars.length - 1; i++) {
                if (cars[i].competitiveness() < cars[i + 1].competitiveness()) {
                    car = cars[i + 1];
                    cars[i + 1] = cars[i];
                    cars[i] = car;
                    sorted = false;
                }
            }
        }
    }

    public static void printCar(Car[] cars) {
        for(int i = 0; i < cars.length; i++) {
            System.out.println("Position " + (i + 1) + ":");
            System.out.print(cars[i]);
            System.out.println("Competitiveness: " + cars[i].competitiveness());
        }
    }
}