package com.youtube.java.practice.sentence;

public class SentenceGenerator {
    public SentenceGenerator() {
    }

    public String makeSentence() {
        String[] firstWord = {"Good", "Perfect", "Incredible", "Amazing"};
        String[] secondWord = {"solution", "result", "implementation", "score"};
        String[] thirdWord = {"is happening.", "was made.", "will be done.", "used to be achived."};

        int oneLength = firstWord.length;
        int twoLength = secondWord.length;
        int threeLength = thirdWord.length;

        int randomOne = (int) (Math.random() * oneLength);
        int randomTwo = (int) (Math.random() * twoLength);
        int randomThree = (int) (Math.random() * threeLength);

        String sentence = firstWord[randomOne] + " " + secondWord[randomTwo] + " " + thirdWord[randomThree];

        return sentence;
    }
}
