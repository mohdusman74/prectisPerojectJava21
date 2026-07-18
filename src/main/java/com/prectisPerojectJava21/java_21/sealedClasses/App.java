package com.prectisPerojectJava21.java_21.sealedClasses;

public class App {
    public static void main(String[] args) {
        Animal animal1 = new Dog();
        Animal animal2 = new Cat();

        System.out.println("Animal 1 is a " + animal1.getClass().getSimpleName());
        System.out.println("Animal 2 is a " + animal2.getClass().getSimpleName());
    }
}
