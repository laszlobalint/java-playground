package com.company.javapractice.Player;

import com.company.javapractice.Media.MP3;
import com.company.javapractice.Media.VideoClip;

public class Winamp {

        public static void main(String[] args) {
            Winamp winamp = new Winamp(Integer.parseInt(args[0]));
            MP3 otherside = new MP3("Red Hot Chili Peppers", "Californication", "Otherside", 256);
            MP3 paparazzi = new MP3("Lady Gaga", "The Fame", "Paparazzi", 206);
            MP3 ichwill = new MP3("Rammstein", "Mutter", "Ich will", 246);
            VideoClip stanger = new VideoClip("Metallica", "St. Anger", "St. Anger", 349, 200, 150);
            VideoClip itsmylife = new VideoClip("Bon Jovi", "Crush", "It's My Life", 268, 180, 140);

            winamp.addInto(otherside);
            winamp.addInto(paparazzi);
            winamp.addInto(ichwill);
            winamp.addInto(stanger);
            winamp.addInto(itsmylife);

            for (int i = 0; i < Integer.parseInt(args[0]); i++) {
                winamp.info(winamp.mp3[i]);
            }
            System.out.println("The average length of songs in the playlist: " + winamp.averageLength() + " seconds. ");
        }

    private int sizeArray;
    private int songCount;
    private MP3[] mp3;

    public Winamp(int sizeArray) {
        this.sizeArray = sizeArray;
        this.songCount = 0;
        this.mp3 = new MP3[sizeArray];
    }

    public void addInto(MP3 song) {
        if (songCount < sizeArray) {
            mp3[songCount] = song;
            songCount++;
        }
    }

    public int averageLength() {
        int length = 0;
        for (int i = 0; i < mp3.length; i++) {
            length += mp3[i].getLength();
        }
        return length / mp3.length;
    }

    public MP3 checkFor(int i) {
        return mp3[i];
    }

    public void info(MP3 mp3) {
        System.out.println(mp3);
    }

    public int getSizeArray() {
        return sizeArray;
    }

    public void setSizeArray(int sizeArray) {
        this.sizeArray = sizeArray;
    }

    public MP3[] getMp3() {
        return mp3;
    }

    public void setMp3(MP3[] mp3) {
        this.mp3 = mp3;
    }
}
