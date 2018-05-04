package com.company.javapractice;

import com.company.javapractice.Movies.ActionMovie;
import com.company.javapractice.Movies.CharWordReverse;
import com.company.javapractice.Movies.Movies;

public class OscarGala {
    private int yearOfGala;
    private int movieCount;
    private static Movies[] nominated;
    private static String founder = "Louis B. Mayer";

    public OscarGala(int yearOfGala, Movies[] nominated) {
        this.yearOfGala = yearOfGala;
        this.nominated = nominated;
    }

    public static void main(String[] args) {
        OscarGala oscar = new OscarGala(2016, nominated);
        CharWordReverse charWordReverse = new CharWordReverse();
        oscar.countMovies(args);
        oscar.decideMovie(args);
        oscar.awardWinning(nominated);
        System.out.println(oscar);
        oscar.showAllNominations();
        System.out.println();
        charWordReverse.reverse();
    }

    private void countMovies(String[] args) {
        for(int i = 0; i < args.length; i++) {
            if (args[i].equals("action") || args[i].equals("movie")) {
                movieCount++;
            }
        }
        System.out.println("Number of nominated movies: " + movieCount);
        nominated = new Movies[movieCount];
    }

    private void decideMovie(String[] args) {
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
    }

    private void awardWinning(Movies[] nominated) {
        for (Movies aNominated : nominated) {
            if (aNominated != null) {
                System.out.println(aNominated.getTitle() + " movie won the Oscar: " + aNominated.nominationForOscar(2016));
            }
        }
    }

    private void showAllNominations() {
        for (Movies aNominated : nominated) {
            System.out.println(aNominated.toString());
        }
    }

    @Override
    public String toString() { return "The Oscar Gala was held in "+ yearOfGala + ", and it was founded by " + founder + ". "; }
}
