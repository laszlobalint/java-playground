package com.youtube.java.practice;

import com.youtube.java.practice.sentence.SentenceGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FirstProject {

    public static void main(String[] args) throws Exception {

        System.out.println("Hello!");

        FirstProject firstProject = new FirstProject();
        String result = firstProject.censor("The dog is really cute.", "dog", "cat");
        System.out.println(result);

        Human firstHuman = new Human();
        firstHuman.setName("Johnny");
        firstHuman.writeName();

        if (firstHuman.getAge() == 0) {
            System.out.println("No age specified!");
        } else {
            System.out.println("Person's age: " + firstHuman.getAge());
        }

        //** This is the Javadoc format for writing comments */
        boolean isEmpty = (firstHuman.getName() == null);
        System.out.println(isEmpty == true ? "Empty" : "Filled out");

        Cat cat = new Cat("Black cat");
        cat.makeSound();

        System.out.print("\n");

        char firstChar = 'a';
        int secondInt = 2;
        String thirdString = Character.toString(firstChar) + Integer.toString(secondInt);
        System.out.println(thirdString);

        SentenceGenerator sentenceGenerator = new SentenceGenerator();
        System.out.println(sentenceGenerator.makeSentence());

        ArrayList<Animal> cats = new ArrayList<>();
        Cat cuteCat = new Cat("Black cat");
        cats.add(cuteCat);
        if (cats.get(0) instanceof Cat) {
            cat = (Cat) cats.get(0);
        }

        Object objectOne = new Object();
        Object objectTwo = new Object();
        System.out.println(cuteCat.getClass());
        System.out.println(objectOne.hashCode());
        System.out.println(objectOne.equals(objectTwo));
    }

    private String censor(String text, String toChange, String newWord) throws Exception {
        if (text.contains(toChange)) {
            text = text.replaceAll(toChange, newWord);
        }
        return text;
    }

    private void fileReader() {
        File file = new File("testfile.txt");
        try {
            FileReader fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            Logger.getLogger(FirstProject.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            System.out.println("This is shown in all cases!");
        }
    }
}
