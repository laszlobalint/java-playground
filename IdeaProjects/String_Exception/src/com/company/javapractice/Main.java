package com.company.javapractice;

import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {

        //Print by separator:
        String sentence1 = "This_sentence_exists_of_six_words.";
        String sentence2 = "This sentence exists of six words.";
        String[] words1 = sentence1.split("_");
        String[] words2 = sentence2.split(" ");

        for (int i = 0; i < words1.length; i++) {
            System.out.println("The " + (i + 1) + ". word: " + words1[i]);
        }

        for (int i = 0; i < words2.length; i++) {
            System.out.println("The " + (i + 1) + ". word: " + words2[i]);
        }


        //Print with StringTokenizer:
        String str = "abcd, text, something puppy;doggy;bear snowman carriage";
        StringTokenizer st = new StringTokenizer(str);
        System.out.println("StringTokenizer first run on str: (with default separators)");
        while (st.hasMoreTokens()) {
            String tmp = st.nextToken();
            System.out.println(tmp);
        }
        System.out.println();
        System.out.println("StringTokenizer second run on str: (with ; , . separators)");
        st = new StringTokenizer(str, ";.,");
        while (st.hasMoreTokens()) {
            String tmp = st.nextToken();
            System.out.println(tmp);
        }


        //Print "sentence2" with StringTokenizer:
        StringTokenizer strNew = new StringTokenizer(sentence2);
        strNew = new StringTokenizer(sentence2, "_");
        while (strNew.hasMoreTokens()) {
            String temp = strNew.nextToken();
            System.out.println(temp);
        }

        // Replace all with regular expressions:
        String phoneNumber = new String("The given string is a 0662 446-363 which makes me happy.");
        String replaceString = phoneNumber.replaceAll("[\\d+\\s+\\d+\\-\\d+]{6,18}", " telephone ");
        System.out.println(replaceString);


        // Value of - Converts different types of values into string:
        int value = 30;
        String s1 = String.valueOf(value);
        System.out.println(s1 + 40);

    }
}
