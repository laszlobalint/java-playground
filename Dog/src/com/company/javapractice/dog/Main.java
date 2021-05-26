package com.company.javapractice.dog;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Dog gd = new Dog("green", "Dingo");
        Dog pd = new Dog("pink", "Frakk");
        Dog wd = new Dog("white", "Buksi");
        Dog rd = new Dog("pink", "Frakk");
        Set <Dog> dogs = new HashSet <>();
        HashMap<Dog, Integer> dogMap = new HashMap <>();

        dogMap.put(gd, 5);
        dogMap.put(pd, 6);
        dogMap.put(wd, 7);
        dogMap.put(rd, 8);
        System.out.println(pd.equals(rd));
        System.out.println(dogs.contains(new Dog("pink", "Pincsi")));
        System.out.println(dogMap.containsKey(new Dog("pink", "Frakk")));

        Dog newDog = new Dog("pink", "Pointy");
        dogs.add(newDog);
        newDog.setColor("green");
        System.out.println(dogs.contains(newDog));
        System.out.println(wd.getColor().hashCode());

        // Serializable:
        Dog doggy = new Dog("brown", "Hapci");
        FileOutputStream fout = new FileOutputStream("doggy.txt");
        ObjectOutputStream out = new ObjectOutputStream(fout);
        out.writeObject(doggy);
        out.flush();
        out.close();
        System.out.println("Successful serialization!");

        // Deserializable:
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("doggy.txt"));
        Dog dog = (Dog) in.readObject();
        System.out.println(dog);
        in.close();

        Snauzer snaudog = new Snauzer("purple", "BloodDrinker", "New Snau");
        FileOutputStream fout2 = new FileOutputStream("snau.txt");
        ObjectOutputStream out2 = new ObjectOutputStream(fout2);
        out2.writeObject(snaudog);
        out2.flush();
        out2.close();
        System.out.println("Successful serialization for the second time!");

        Person balint = new Person(1, "Bálint");
        FileOutputStream fout3 = new FileOutputStream("owner.txt");
        ObjectOutputStream out3 = new ObjectOutputStream(fout3);
        out3.writeObject(balint);
        out3.flush();
        out3.close();
        System.out.println("Successful serialization for the third time!");

        // Transient keyword excludes variable from serializing. 
    }

    public static class Dog extends Animal implements Serializable {
        private String color;
        private String name;
        private Person owner;

        public Dog(String color, String name) {
            this.color = color;
            this.name = name;
        }

        public Dog(String color, String name, Person owner) {
            this.color = color;
            this.name = name;
            this.owner = owner;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Dog dog = (Dog) o;

            if (color != null ? !color.equals(dog.color) : dog.color != null) return false;
            return name != null ? name.equals(dog.name) : dog.name == null;
        }

        @Override
        public int hashCode() {
            int result = color != null ? color.hashCode() : 0;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            return result;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return "The dog's " +
                    "color is " + color +
                    ", and it's name is " + name +
                    '.';
        }
    }
}
