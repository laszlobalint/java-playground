package com.youtube.java.practice;

import com.youtube.java.practice.intermediatejava.Bat;
import com.youtube.java.practice.intermediatejava.Fly;
import com.youtube.java.practice.intermediatejava.Reader;
import com.youtube.java.practice.intermediatejava.Writer;

import java.io.IOException;

public class IntermediateMain {

    public static void main(String[] args) throws IOException {

        Bat batman = new Bat();
        process(batman);

        System.out.println("Output stream");

        int inputStream = System.in.read();
        System.out.println((char) inputStream);
        System.in.read();

        System.err.println("Error stream");

        Writer w = new Writer();
        w.writeSingleChar();
        Reader r = new Reader();
        r.readSingleChar();

        w.writeMultipleCharacters();
        r.readMultipleCharacters();

        w.bufferedWriter();
        r.bufferedReader();
    }

    public static void process(Fly animal) {
        animal.ascend();
    }
}
