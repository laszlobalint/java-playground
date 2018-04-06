package com.company.javapractice;

import java.io.*;
import com.company.javapractice.Movies.ActionMovie;
import com.company.javapractice.Movies.Movies;

public class OscarGala {

    private int yearOfGala;
    static Movies[] nominated;
    static String founder = "Louis B. Mayer";

    public OscarGala(int yearOfGala, Movies[] nominated, String founder) {
        this.yearOfGala = yearOfGala;
        this.nominated = nominated;
        this.founder = founder;
    }

    public static void main(String[] args) {
        reverse();

        int movieCount = 0;
        for(int i = 0; i < args.length; i++) {
            if (args[i].equals("action") || args[i].equals("movie")) {
                movieCount++;
            }
        }
        System.out.println("Number of nominated movies: " + movieCount);
        Movies[] nominated = new Movies[movieCount];

        int j = 0;
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("action")) {
                ActionMovie action = new ActionMovie(args[i + 1].replace('_', ' '), args[i + 2].replace('_', ' '), Integer.parseInt(args[i + 3]), args[i + 4].replace('_', ' '), Integer.parseInt(args[i + 5]));
                nominated[j] = action;
                j++;
                i+=5;
            } else if (args[i].equals("movie")) {
                Movies movie = new Movies(args[i + 1].replace('_', ' '), args[i + 2].replace('_', ' '), Integer.parseInt(args[i + 3]));
                nominated[j] = movie;
                j++;
                i+=3;
            }
        }

        // Construct an Oscar:
        OscarGala oscar = new OscarGala(2016, nominated, founder);

        // Who won an award?
        for (int i = 0; i < nominated.length; i++) {
            if (nominated[i] != null) {
                System.out.println(nominated[i].getTitle() + " movie won the Oscar: " + nominated[i].nominationForOscar(2016));
            }
        }

        // Give information about the ceremony:
        System.out.println(oscar.toString());

        // Show all the nominated movies:
        for (int i = 0; i < nominated.length; i++) {
            System.out.println(nominated[i].toString());
            }
    }

    public static void reverse() {
        String sentence = "The Greek goes to sleep";

        // Reverse by characters:
        System.out.println("Reverse the whole sentence: " + new StringBuilder(sentence).reverse().toString());

        String[] words = sentence.split(" ");

        String reversedString = "";
        String reversedString2 = "";

        // Reverse by words:
        for (int i = words.length - 1; i >= 0; i--) {
            reversedString2 = reversedString2 + words[i] + " ";
        }

        // Reversed characters in words, and reverse by words:
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String reverseWord = "";
            for (int j = word.length()-1; j >= 0; j--) {
                reverseWord = reverseWord + word.charAt(j);
            }
            reversedString = reversedString + reverseWord + " ";
        }
        System.out.println(sentence);
        System.out.println(reversedString);
        System.out.println(reversedString2);
        System.out.println();
    }

    @Override
    public String toString() {
        return "The Oscar Gala was held in "+ yearOfGala + ", and it was founded by " + founder + ". ";
    }
}
