package com.youtube.java.practice;

public class FirstProject {

    public static void main(String[] args) {

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

        Cat cat = new Cat();
        cat.makeSound();
    }

    private String censor(String text, String toChange, String newWord) {
        if (text.contains(toChange)) {
            text = text.replaceAll(toChange, newWord);
        }
        return text;
    }
}
