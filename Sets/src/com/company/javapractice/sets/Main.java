package com.company.javapractice.sets;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet <>();
        Set<Integer> set2 = new TreeSet <>();
        Set<String> set3 = new TreeSet <>();
        for (int i = 0; i < 10; i++) {
            int number = (int) Math.floor((Math.random() * 100) + 1);
            set1.add(number);
            set2.add(number);
        }

        for (int i = 0; i < 10; i++) {
            String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            StringBuilder salt = new StringBuilder();
            Random rnd = new Random();
            while (salt.length() < 10) {
                int index = (int) (rnd.nextFloat() * SALTCHARS.length());
                salt.append(SALTCHARS.charAt(index));
            }
            String saltStr = salt.toString();
            set3.add(saltStr);
        }

        System.out.println("Set1 items: " + set1);
        System.out.println("Set2 items: " + set2);
        System.out.println("Set3 items: " + set3);

        if (set1.contains(1)) {
            System.out.println("The set contains 2.");
        } else {
            System.out.println("There is no 2 in the set.");
        }

        // Print out the elements of the set:

        Iterator<Integer> it = set1.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        for (int number : set1) {
            System.out.print(number + " ");
        }
        System.out.println();



        LinkedList<Integer> list = new LinkedList <>();
        for (int i = 0; i < 10; i++) {
            int number = (int) Math.floor((Math.random() * 100) + 1);
            list.add(number);
        }
        System.out.println(list);
        System.out.println(list.get(1));

        // HashMap and TreeMap:
        Map<Integer, String> hash = new HashMap <>();
        Map<Integer, String> tree = new TreeMap <>();
        hash.put(0, "zero");
        hash.put(1, "one");
        hash.put(2, "two");
        tree.put(0, "zero");
        tree.put(1, "one");
        tree.put(2, "two");

        // Print out keys (For each):
        for (int keys : hash.keySet()) {
            System.out.println(keys + " ");
        }

        // Print out keys and values (For each):
        for (int keys : hash.keySet()) {
            System.out.println(keys + " " + hash.get(keys));
        }

        // Print out values (For):
        for (int i = 0; i < hash.size(); i++) {
            System.out.println(hash.get(i));
        }

        // Print out keys and values together (As list):
        System.out.println(Arrays.asList(hash));
        System.out.println(Collections.singletonList(hash));

        // Go through the map and get key and value pairs (Iterator):
        Iterator<Map.Entry<Integer, String>> item = hash.entrySet().iterator();
        while (item.hasNext()) {
            System.out.println(item.next());
        }
    }
}
