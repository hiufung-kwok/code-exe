package com.lang.reflectionTest;

class Animal {
}

class Dog extends Animal {
}

class Cat extends Animal {
}

public class IsAssignableFromTest {
    public static void main(String[] args) {
        // Class objects for each class
        Class<Animal> animalClass = Animal.class;
        Class<Dog> dogClass = Dog.class;
        Class<Cat> catClass = Cat.class;

        // Check if Dog and Cat are assignable to Animal
        System.out.println("Animal is assignable from Dog: " + animalClass.isAssignableFrom(dogClass)); // true
        System.out.println("Animal is assignable from Cat: " + animalClass.isAssignableFrom(catClass)); // true

        // Check if Dog is assignable from Animal
        System.out.println("Dog is assignable from Animal: " + dogClass.isAssignableFrom(animalClass)); // false

        // Check if Cat is assignable from Dog
        System.out.println("Cat is assignable from Dog: " + catClass.isAssignableFrom(dogClass)); // false

        // Check if Dog is assignable from Dog
        System.out.println("Dog is assignable from Dog: " + dogClass.isAssignableFrom(dogClass)); // true
    }
}
