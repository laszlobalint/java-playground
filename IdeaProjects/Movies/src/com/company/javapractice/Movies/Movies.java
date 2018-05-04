package com.company.javapractice.Movies;

import java.util.Random;

public class Movies {
    private String title;
    private String producerName;
    private int releaseYear;

    public Movies(String title, String producerName, int releaseYear) {
        this.title = title;
        this.producerName = producerName;
        this.releaseYear = releaseYear;
    }

    public boolean nominationForOscar(int yearOfNomination) {
        if (yearOfNomination == releaseYear || yearOfNomination == (releaseYear + 1)) {
            Random random = new Random();
            return random.nextBoolean();
        } else {
            return false;
        }
    }

    public String getTitle() { return title; }

    @Override
    public String toString() { return "Movie - " + "Title: " + title + '\'' + ", Producer: " + producerName + '\'' + ", Released: " + releaseYear + ". "; }
}
