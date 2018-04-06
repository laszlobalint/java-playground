package com.company.javapractice;

import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        //Splits string by "-" into different elements.
        String phone = "012-3456789";
        String[] output = phone.split("-");
        System.out.println(output[0]);
        System.out.println(output[1]);

        System.out.println();


        //Split a Period / dot
        String test = "abc.def.123";
        String[] out1 = test.split("\\.");
        System.out.println(out1[0]);
        System.out.println(out1[1]);
        System.out.println(out1[2]);

        System.out.println();

        //Or - Alternative method:
        String[] out2 = test.split(Pattern.quote("."));
        System.out.println(out2[0]);
        System.out.println(out2[1]);
        System.out.println(out2[2]);

        System.out.println();


        /*Some common checking before split:
        String testNew = "abc.def.123";
        if (testNew.contains(".")) {
            String[] outputNew = testNew.split("\\.");
            if (output.length != 3) {
                throw new IllegalArgumentException(testNew + " - invalid format!");
            } else {
                System.out.println(outputNew[0]);
                System.out.println(outputNew[1]);
                System.out.println(outputNew[2]);
            }
        } else {
            throw new IllegalArgumentException(testNew + " - invalid format!");
        }

        System.out.println();

        */


        // Split by words.
        String str1 = "I have a cat. I play cricket with bat. I don't like rat," + "I hate mats, now break it.";
        Pattern ptn = Pattern.compile("(cat|rat|mat|bat)");
        String[] parts = ptn.split(str1);
        for (String p : parts) {
            System.out.println(p);
        }

        System.out.println();


        // java.lang.String.split() method:
        String str = "a d, m, i.n";
        String delimiters = "\\s+|,\\s*|\\.\\s*";

        // Analyzing the string:
        String[] tokensVal = str.split(delimiters);

        // Prints the number of tokens:
        System.out.println("Count of tokens = " + tokensVal.length);

        for (int i = 0; i < tokensVal.length; i++) {
            String token = tokensVal[i];
            System.out.print(token);
        }

        System.out.println();

        for (String token : tokensVal) {
            System.out.print(token);
        }

        System.out.println();
    }
}
