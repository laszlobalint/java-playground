package com.youtube.java.practice.intermediatejava;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class Reader {

    public void  readSingleChar() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("./test.txt");
            int i = fis.read();
            System.out.println((char) i);
            fis.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    public void readMultipleCharacters() {
        try {
            FileInputStream fis = new FileInputStream("./test.txt");
            int i = 0;
            StringBuilder result = new StringBuilder();
            while ((i = fis.read()) != -1) {
                result.append((char) i);
            }
            System.out.println(result);
            fis.close();
        } catch (Exception ex) {
            System.out.println("" + ex);
        }
    }

    public void bufferedReader() {
        try {
            FileInputStream fis = new FileInputStream("./test.txt");
            BufferedInputStream bin = new BufferedInputStream(fis);
            int i = 0;
            StringBuilder result = new StringBuilder();
            while ((i = bin.read()) != -1) {
                result.append((char) i);
            }
            System.out.println(result);
            fis.close();
            bin.close();
        } catch (Exception ex) {
            System.out.println("" + ex);
        }
    }
}
