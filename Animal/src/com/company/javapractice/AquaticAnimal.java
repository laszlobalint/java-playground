package com.company.javapractice;

public abstract class AquaticAnimal extends Animal {
    public AquaticAnimal(String name) {

        super(name);
    }

    @Override
    public String makeSound() {
        return "Cannot be heard in the water.";
    }
}
