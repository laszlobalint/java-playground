package com.flow.pubsimluator;

public class Barkeep extends Human {

    private static int dirtyGlass = 0;

    public Barkeep(String name, int age, boolean gender, int money) {
        super(name, age, gender, money);
    }

    public static int getDirtyGlass() {
        return dirtyGlass;
    }

    public static void setDirtyGlass(int dirtyGlass) {
        Barkeep.dirtyGlass = dirtyGlass;
    }

    void washingUp() {
        if (dirtyGlass !=0) {
            dirtyGlass--;
            System.out.println(getName() + " washed up one of yer mugs.");
        } else {
            System.out.println("Drink up lads! There are no dirty glasses left. Said " + getName());
        }
    }
}
