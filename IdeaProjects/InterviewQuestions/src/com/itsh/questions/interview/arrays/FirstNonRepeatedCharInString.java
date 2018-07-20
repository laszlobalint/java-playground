package com.itsh.questions.interview.arrays;

import java.util.*;

public class FirstNonRepeatedCharInString {
    // Three solutions to find first non-repeated character in a string.
    private static final String WORD = "Privileges";

    public static void main(String[] args) {
        System.out.println("First non-repeated character in the string " + WORD + " is "+ getFirstNonRepeatedChar(WORD));
        System.out.println("First non-repeated character in the string " + WORD + " is "+ firstNonRepeatingChar(WORD));
        System.out.println("First non-repeated character in the string " + WORD + " is "+ firstNonRepeatedCharacter(WORD));
    }

    // Used: LinkedHashMap - 1. Get character array and loop through it to build a hash table with char and their count. 2. Loop through LinkedHashMap to find an entry with value 1, that's your first non-repeated character, as LinkedHashMap maintains insertion order.
    public static char getFirstNonRepeatedChar(String str) {
        Map<Character, Integer> counts = new LinkedHashMap<>(str.length());

        for (char ch : str.toCharArray()) {
            counts.put(ch, counts.containsKey(ch) ? counts.get(ch) + 1 : 1);
        }

        for (Map.Entry<Character, Integer> entry :  counts.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        throw new RuntimeException(("Did not find any non-repeated character."));
    }

    // Used: Set and List - It uses two storage to cut down one iteration, standard space vs. time trade-off.
    public static char firstNonRepeatingChar(String word) {
        Set<Character> repeating = new HashSet<>();
        List<Character> nonRepeating = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (repeating.contains(letter)) {
                continue;
            }
            if (nonRepeating.contains(letter)) {
                nonRepeating.remove((Character) letter);
            } else {
                nonRepeating.add(letter);
            }
        }
        return nonRepeating.get(0);
    }

    // Used: HashMap - 1. Scan string and store count of each character in HashMap. 2. Traverse string and get count for each character from map.
    public static char firstNonRepeatedCharacter(String word) {
        HashMap<Character, Integer> scoreBoard = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (scoreBoard.containsKey(c)) {
                scoreBoard.put(c, scoreBoard.get(c) + 1);
            } else {
                scoreBoard.put(c, 1);
            }
        }

        // Since HashMap does not maintain order, going through string again.
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (scoreBoard.get(c) == 1) {
                return c;
            }
        }
        throw new RuntimeException("Undefined behaviour.");
    }
}
