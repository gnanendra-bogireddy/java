package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Generic Methods are like a magic backpack that changes its shape for whatever you put in it!
 * 
 * You don't always need a whole Generic Class. Sometimes you just need a single method 
 * that can handle different types of data.
 * 
 * Key Concepts:
 * 1. Method-level Generics: The <T> is defined right before the return type.
 * 2. Multiple Type Parameters: You can have <T, V> for multiple different types.
 * 3. Wildcards (?): Used when you don't care exactly what the type is, but you want to work with a Collection of it.
 */
public class GenericsMethodDemo {

    // 1. Simple Generic Method
    // The <T> before 'void' tells Java this method uses a magic type.
    public <T> void printItem(T item) {
        System.out.println("Item: " + item + " (Type: " + item.getClass().getSimpleName() + ")");
    }

    // 2. Multiple Type Parameters
    // T and V can be two different things (like a name and an age).
    public <T, V> void printPair(T first, V second) {
        System.out.println("Pair: " + first + " and " + second);
    }

    // 3. Wildcard (?)
    // List<?> means "A list of something, I don't care what!"
    public void printAnyList(List<?> list) {
        System.out.println("List elements: " + list);
    }

    public static void main(String[] args) {
        GenericsMethodDemo demo = new GenericsMethodDemo();

        System.out.println("--- 1. Generic Methods ---");
        demo.printItem("Coffee");    // Works with String
        demo.printItem(15.99);       // Works with Double
        demo.printItem(true);        // Works with Boolean

        System.out.println("\n--- 2. Multiple Types ---");
        demo.printPair("ID", 101);
        demo.printPair(202, "Active");

        System.out.println("\n--- 3. Wildcards ---");
        List<String> names = List.of("Alice", "Bob");
        List<Integer> scores = List.of(95, 88);

        demo.printAnyList(names);
        demo.printAnyList(scores);

        /*
         * Expected Output:
         * --- 1. Generic Methods ---
         * Item: Coffee (Type: String)
         * Item: 15.99 (Type: Double)
         * Item: true (Type: Boolean)
         * 
         * --- 2. Multiple Types ---
         * Pair: ID and 101
         * Pair: 202 and Active
         * 
         * --- 3. Wildcards ---
         * List elements: [Alice, Bob]
         * List elements: [95, 88]
         */
    }
}
