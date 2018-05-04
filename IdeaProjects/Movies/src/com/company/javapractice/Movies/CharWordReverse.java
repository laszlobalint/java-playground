package com.company.javapractice.Movies;

public class CharWordReverse {
    public void reverse() {
        String sentence = "The Greek goes to sleep";

        // Reverse by characters:
        System.out.println("Reverse the whole sentence: " + new StringBuilder(sentence).reverse().toString());

        String[] words = sentence.split(" ");

        StringBuilder reversedString = new StringBuilder();
        StringBuilder reversedString2 = new StringBuilder();

        // Reverse by words:
        for (int i = words.length - 1; i >= 0; i--) {
            reversedString2.append(words[i]).append(" ");
        }

        // Reversed characters in words, and reverse by words:
        for (String word : words) {
            String reverseWord = "";
            for (int j = word.length() - 1; j >= 0; j--) {
                reverseWord = reverseWord + word.charAt(j);
            }
            reversedString.append(reverseWord).append(" ");
        }
        System.out.println(sentence);
        System.out.println(reversedString);
        System.out.println(reversedString2);
    }
}
