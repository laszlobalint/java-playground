package com.company.javapractice.Media;

public class MP3 {
    private String performer;
    private String album;
    private String title;
    private int length;

    public MP3(String performer, String album, String title, int length) {
        this.performer = performer;
        this.album = album;
        this.title = title;
        this.length = length;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "This song was performed by " + performer +
                ", the song's title is " + title +
                ", it was released on " + album + " album" +
                ", the song is " + length + " seconds long. ";
    }
}
