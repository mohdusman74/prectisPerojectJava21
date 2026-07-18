package com.prectisPerojectJava21.java_21;

public class PatternMatching {

    public static void main(String[] args) {
        Object obj = "Hello";

        if (obj instanceof String str) {
            System.out.println("String length: " + str.length());
        }else {
            System.out.println("Not a string");
        }
    }
}
