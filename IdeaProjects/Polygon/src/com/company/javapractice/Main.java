/*      1. Írj egy programot ami egy általad választott adatból kiszámítja egy tetraéder felszínét és térfogatát!
        2. Írj egy programot ami egy általad választott adatból kiszámítja egy hexaéder felszínét és térfogatát!
        3. Írj egy programot ami egy általad választott adatból kiszámítja egy oktaéder felszínét és térfogatát!
        4. Írj egy programot ami egy általad választott adatból kiszámítja egy ikozaéder felszínét és térfogatát!
        5. Írj egy programot ami egy általad választott adatból kiszámítja egy dodekaéder felszínét és térfogatát! */

package com.company.javapractice;

public class Main {

    public static void main(String[] args) {
        tetrahedron(11);
        hexahedron(11);
        octahedron(11);
        dodecahedron(11);
        icosahedron(11);
    }

    public static void tetrahedron(double a) {
        double surface = Math.pow(a, 2) * Math.sqrt(3);
        double volume = Math.pow(a, 3) * Math.sqrt(2) / 12;
        System.out.println("Surface of the tetrahedron: " + Math.round(surface));
        System.out.println("Volume of the tetrahedron: " + Math.round(volume));
    }

    public static void hexahedron(double a) {
        double surface = 6* Math.pow(a, 2);
        double volume = Math.pow(a, 3);
        System.out.println("Surface of the hexahedron: " + Math.round(surface));
        System.out.println("Volume of the hexahedron: " + Math.round(volume));
    }

    public static void octahedron(double a) {
        double surface = Math.pow(a, 2) * 2 * Math.sqrt(3);
        double volume = Math.pow(a, 2) * Math.sqrt(2) / 3;
        System.out.println("Surface of the octahedron: " + Math.round(surface));
        System.out.println("Volume of the octahedron: " + Math.round(volume));
    }

    public static void dodecahedron(double a) {
        double surface = Math.pow(a, 2) * 3 * Math.sqrt(25 + 10 * Math.sqrt(5));
        double volume = Math.pow(a, 2) * (15 + 7 * Math.sqrt(5)) / 4;
        System.out.println("Surface of the dodecahedron: " + Math.round(surface));
        System.out.println("Volume of the dodecahedron: " + Math.round(volume));
    }

    public static void icosahedron(double a) {
        double surface = Math.pow(a, 2) * 5 * Math.sqrt(3);
        double volume = Math.pow(a, 3) * (15 + 5 * Math.sqrt(5)) / 12;
        System.out.println("Surface of the icosahedron: " + Math.round(surface));
        System.out.println("Volume of the icosahedron: " + Math.round(volume));
    }
}
