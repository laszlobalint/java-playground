package com.company.javapractice;

import com.company.javapractice.Vehicle.Railway;
import com.company.javapractice.Vehicle.GoodsTrain;
import com.company.javapractice.Vehicle.LocalTrain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Train {
    public static void main(String[] args) {

        int step = 0;
        int counter = 0;
        for (int i = 0; i < args.length; i += step) {
            if (args[i].equals("local")) {
                step = 6;
                counter++;
            } else if (args[i].equals("goods")) {
                step = 7;
                counter++;
            } else {
                System.out.println("Wrong input form!");
            }
        }

        Railway[] trains = new Railway[counter];

        step = 0;
        int j = 0;
        for (int i = 0; i < args.length; i += step) {
            if (args[i].equals("local")) {
                trains[j] = new LocalTrain(args[i + 1], args[i + 2], Integer.parseInt(args[i + 3]), Integer.parseInt(args[i + 4]), Integer.parseInt(args[i + 5]));
                step = 6;
                System.out.println(trains[j].toString());
                j++;

            } else if (args[i].equals("goods")) {
                trains[j] = new GoodsTrain(args[i + 1], args[i + 2], Integer.parseInt(args[i + 3]), Integer.parseInt(args[i + 4]), args[i + 5], Integer.parseInt(args[i + 6]));
                step = 7;
                System.out.println(trains[j].toString());
                j++;
            }
        }

        Railway shortest = new Railway();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < trains.length; i++) {
            if (trains[i].earliest() < min) {
                shortest = trains[i];
            }
        }
        System.out.println("The fastest train: " + shortest);
        System.out.println("Time of travel: " + shortest.earliest() + " h");

        System.out.println("Sorted in a better way:");
        List<Railway> trainList = Arrays.asList(trains);
        Collections.sort(trainList);
        System.out.println(trainList);
        System.out.println("The fastest train: " + trainList.get(0));
    }
}
