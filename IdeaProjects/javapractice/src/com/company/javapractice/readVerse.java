/*
Írj egy programot, ami bekér egy N számot, majd kiírja egy általad választott vers elsõ 12 sorát, kihagyva az elsõ N sort.
        Ha több versszakot kell kiírni, akkor két-két versszak sorai között legyen  egy-egy üres sor is. [a,b,c,d] ->
        A vers bekérése egy külön fájlból történt.
    */

package com.company.javapractice;

    import java.io.*;
    import java.util.ArrayList;
    import java.util.Scanner;

    public class readVerse {
        public static void main(String[] args) {
            Scanner reader = new Scanner(System.in);
            System.out.print("Enter the number of line from which you want to see the part of the verse: ");
            int n = reader.nextInt();
            ArrayList<String> VerseByLine = new ArrayList<String >();
                try{
                    FileInputStream fstream = new FileInputStream("/home/laszlobalint/IdeaProjects/javapractice/src/com/company/javapractice/verse");
                    DataInputStream in = new DataInputStream(fstream);
                    BufferedReader br = new BufferedReader(new InputStreamReader(in));
                    String strLine;
                    while ((strLine = br.readLine()) != null)   {
                        VerseByLine.add(strLine);
                    }
                    in.close();
                }catch (Exception e){//
                    System.err.println("Error: " + e.getMessage());
                }
                for (int i = n; i <= 13; i++) {
                    System.out.println(VerseByLine.get(i));
                }
            }
        }
