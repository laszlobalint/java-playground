package com.company.javapractice.machine;

import com.company.javapractice.machine.Machine.HydraulicShovel;
import com.company.javapractice.machine.Machine.Lorry;
import com.company.javapractice.machine.Machine.LorryAutoStat;
import com.company.javapractice.machine.Machine.TransloadWrapper;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        LorryAutoStat stat = new LorryAutoStat();
        HashMap <HydraulicShovel, Lorry> vehicle = new HashMap <>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("./src/HydarulicShovel.txt"));
            String line;
            line = null;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split("\\W");
                HydraulicShovel shovel = null;
                Lorry lorry = null;
                if (details[0].equals("Hydraulic")) {
                    shovel = new HydraulicShovel(Integer.parseInt(details[2]), details[1], Integer.parseInt(details[3]));
                }
                if (details[4].equals("Lorry")) {
                    lorry = new Lorry(Integer.parseInt(details[6]), details[5], Integer.parseInt(details[7]));
                    stat.carryingDatabase(lorry);
                }
                if (shovel != null && lorry != null) {
                    vehicle.put(shovel, lorry);
                } else {
                    throw new Exception("No vehicle!");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        for (HydraulicShovel keys : vehicle.keySet()) {
            System.out.println(keys + " " + vehicle.get(keys));
        }

        int numberOfTruck = 0;
        for (HydraulicShovel keys : vehicle.keySet()) {
            numberOfTruck++;
            System.out.println(numberOfTruck + ". truck - Time of transload with 600 kg of sand and 200 meters distance: " + keys.transloading(600, 200, vehicle.get(keys)) + " units of time");
        }
        System.out.println();
        serialize(vehicle);
        System.out.println();
        deserialize("./src/vehicles.ser");
        System.out.println();
        System.out.println("Trucks by carrying capacity: " + stat.getPower());

        List <TransloadWrapper> list = new ArrayList <>();
        for (HydraulicShovel key : vehicle.keySet()) {
            list.add(new TransloadWrapper(key, vehicle.get(key), key.transloading(600, 200, vehicle.get(key))));
        }
        Collections.sort(list);
        System.out.println("Fastest transload:\n" + list.get(0));
    }

    public static void serialize(HashMap map) {
        try {
            FileOutputStream fileOut =
                    new FileOutputStream("./src/vehicles.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(map);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in /src/vehicles.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static void deserialize(String filename) {
        HashMap map = null;
        try {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            map = (HashMap) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("HashMap class not found.");
            c.printStackTrace();
            return;
        }

        System.out.println();
        System.out.println(map.entrySet());

        System.out.println("Number of vehicles: " + map.size() * 2);
    }
}
