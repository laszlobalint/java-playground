package com.company.javapractice.vehicle.dynamicstack;

public class Main {
    public static void main(String[] args) {
        DynamicStack dynamic = new DynamicStack();
        for (int i = 0; i < 10; i++) {
            dynamic.push((int) Math.floor((Math.random() * 10) + 1));
        }
        System.out.println(dynamic.toString());
    dynamic.pop();
    dynamic.pop();
    System.out.println(dynamic.getSize());
    System.out.println(dynamic.isEmpty());
    System.out.println(dynamic.toString());
    }
}
