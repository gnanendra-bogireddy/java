package oop.interfaces;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.BiFunction;

/**
 * Functional Interfaces are special Contracts that ONLY have ONE rule!
 * 
 * Imagine a contract that says: "You MUST jump once." That's it. Nothing else.
 * Because there is only ONE rule, we can write the code super fast using "Lambdas" (like a shortcut).
 */
@FunctionalInterface
interface FunctionalInterfaceExample {
    // This is the ONE rule!
    void jump();
}

class RunClass implements FunctionalInterfaceExample {

    // The old, long way to follow the rule
    @Override
    public void jump() {
        System.out.println("I jumped the old, slow way!");
    }

    public static void main(String[] args) {
        RunClass runner = new RunClass();
        runner.jump();
        
        // --- THE FAST WAY (Lambdas) ---
        // Since there is only ONE rule in the FunctionalInterfaceExample, 
        // Java knows exactly what method we mean! So we just write the code!
        FunctionalInterfaceExample fastJumper = () -> System.out.println("I jumped the fast, Lambda way!");
        fastJumper.jump();

        // --- Built-in Java Functional Interfaces (Java already made these for us!) ---
        
        // 1. Consumer: Takes a toy, does something with it, gives NOTHING back. (Like eating candy)
        Consumer<String> eatCandy = (candy) -> System.out.println("Yum, eating " + candy);
        eatCandy.accept("Chocolate");
        
        // 2. Predicate: Takes a toy, and answers a YES or NO question about it.
        Predicate<Integer> isAdult = (age) -> age >= 18;
        System.out.println("Am I an adult? " + isAdult.test(10)); // false
        
        // 3. BiFunction: Takes TWO toys, does math, and gives ONE thing back.
        BiFunction<Integer, Integer, Integer> addNumbers = (a, b) -> a + b;
        System.out.println("5 + 5 = " + addNumbers.apply(5, 5));
        
        /*
         * Expected Output:
         * I jumped the old, slow way!
         * I jumped the fast, Lambda way!
         * Yum, eating Chocolate
         * Am I an adult? false
         * 5 + 5 = 10
         */
    }
}