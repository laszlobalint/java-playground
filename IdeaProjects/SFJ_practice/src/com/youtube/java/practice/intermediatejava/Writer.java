package com.youtube.java.practice.intermediatejava;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Writer {

    public void writeSingleChar() {
        try {
            FileOutputStream fos = new FileOutputStream("./test.txt");
            fos.write(65);
            fos.flush();
            fos.close();
            System.out.println("Done writing to file.");
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    public void writeMultipleCharacters() {
        try {
            FileOutputStream fout = new FileOutputStream("./test.txt");
            String text = "Practice Java Day And Night";
            byte[] arr = text.getBytes();
            fout.write(arr);
            fout.flush();
            fout.close();
            System.out.println("Done writing multiple characters.");
        } catch (Exception ex) {
            System.out.println("" + ex);
        }
    }

    public void bufferedWriter() throws IOException {
        FileOutputStream fout = new FileOutputStream("./test.txt");
        BufferedOutputStream bout = new BufferedOutputStream(fout);
        String text = "Using Buffered Method";
        byte[] arr = text.getBytes();
        bout.write(arr);
        bout.flush();
        bout.close();
        fout.close();
        System.out.println("Ended writing with buffered method.");
    }
}
