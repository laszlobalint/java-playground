package com.company.javapractice;

public class humanMain {
    public static void main(String[] args) {
        humanClass jozsef = new humanClass();
        humanClass katalin = new humanClass();
        humanClass tamas = new humanClass("Tamás", 54, true);
        humanClass nikoletta = new humanClass("Nikoletta", 23, false);
        System.out.println(jozsef);
        System.out.println(katalin);
        System.out.println(tamas);
        System.out.println(nikoletta);
        tamas.greetings();
        nikoletta.greetings();
        System.out.println(tamas.getName());
        System.out.println(humanClass.numOfCreation);
        humanClass.goToPub();
        }
    }
