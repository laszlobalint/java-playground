package com.company.javapractice.Movies;

import java.util.Random;

public class Movies {
    protected String title;
    protected String producerName;
    protected int releaseYear;
    private Random random;

    public Movies() {
    }

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Override
    public String toString() {
        return "Movie - " +
                "Title: " + title + '\'' +
                ", Producer: " + producerName + '\'' +
                ", Released: " + releaseYear +
                ". ";
    }
}
