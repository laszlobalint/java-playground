package com.company.javapractice;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.readFile("/home/laszlobalint/IdeaProjects/ReadFromFile/src/com/company/javapractice/file.txt");
        main.writeContentToFile("file_2.txt", "Yolo");
        System.out.println(main.readFile("./file_2.txt"));
        main.copyFile("./from.txt", "./to.txt");
    }

    public String readFile(String fileName) {
        StringBuilder sb = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader(new java.io.File(fileName)));
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();
            System.out.println(everything);

            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public void writeContentToFile(String fileName, String content) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(fileName, true));
            bw.write(content);
            bw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void copyFile(String from, String to) throws IOException {
        BufferedReader br = null;
        BufferedWriter bw = null;

        br = new BufferedReader(new FileReader(from));
        bw = new BufferedWriter(new FileWriter(to));

        String line;
        while ((line = br.readLine()) != null) {
            bw.write(line + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    public void copyFile2(String from, String to) {
        writeContentToFile(to, readFile(from));
    }
}
