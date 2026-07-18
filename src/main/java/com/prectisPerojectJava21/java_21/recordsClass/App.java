package com.prectisPerojectJava21.java_21.recordsClass;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiFunction;

public class App {
        public static void main(String[] args) {

//            Employee s = new Employee(101, "Usman", "IT");
//            Employee s1 = new Employee(101, "Usman", "IT");
//
//
//            System.out.println(s.id());
//            System.out.println(s.name());
//            System.out.println(s.department());
//            System.out.println(s);
//            System.out.println(s.hashCode());
//            System.out.println(s1.hashCode());

            BiFunction<String, String, Integer> length =
                    (var a, var b) -> a.length() + b.length();

            System.out.println(length.apply("Usman", "Khan"));


//            try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
//                executor.submit(() -> {
//                    System.out.println("Task executed");
//                });
//            }

//        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()){
//
//        for (int i = 1; i <= 5; i++) {
//            int id = i;
//
//            executor.submit(() -> {
//                System.out.println("Processing Request " + id);
//                Thread.sleep(3000); // Simulating API call
//                System.out.println("Completed Request " + id);
//                return null;
//            });
//        }
//    }

            try (ExecutorService executor =
                         Executors.newVirtualThreadPerTaskExecutor()) {
                System.out.println("Task start execution");
                for (int i = 0; i < 1000; i++) {
                    int finalI = i;
                    executor.submit(() -> getUser(finalI));
                }
            }
//            ExecutorService executor = Executors.newFixedThreadPool(10);
//            for (int i = 0; i < 1000; i++) {
//                int finalI = i;
//                executor.submit(() -> getUser(finalI));
//            }
        }

    public static String getUser(int i) throws Exception {
        Thread.sleep(2000); // Simulate database call
        System.out.println("User " + i + " fetched from database");
        return "User";
    }
}
