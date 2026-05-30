package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Generic Methods are like a magic backpack that changes its size for whatever you put in it!
 * 
 * We don't have to just make generic classes; we can make single generic METHODS.
 */
public class GenericsMethodDemo {

    // See the <T> before the 'void'? That means this method is magic!
    // If you hand it a Number, T becomes a Number. 
    // If you hand it a Word (String), T becomes a Word.
    public <T> void magicPrint(T item) {
        System.out.println("Magic Print: " + item + " (Type: " + item.getClass().getSimpleName() + ")");
    }

    // We can even use TWO magic letters! <T, V> 
    // Think of T as "Thing 1" and V as "Thing 2".
    public <T, V> void doubleMagicPrint(T item1, V item2) {
        System.out.println("Double Magic: " + item1 + " and " + item2);
    }

    // The Wildcard '?' is like saying: "I don't care what it is, just give me a List of it!"
    // It is a super flexible way to accept any kind of List.
    public void printAnyList(List<?> theList) {
        System.out.println("Here is the list: " + theList);
    }

    public static void main(String[] args) {
        GenericsMethodDemo demo = new GenericsMethodDemo();

        System.out.println("--- Magic Methods ---");
        
        // Watch the same method accept completely different things!
        demo.magicPrint(24);         // Accepts an Integer
        demo.magicPrint("Hello");    // Accepts a String
        demo.magicPrint(3.14);       // Accepts a Double
        
        System.out.println("\n--- Double Magic ---");
        demo.doubleMagicPrint("Apples", 10); // T is String, V is Integer
        
        System.out.println("\n--- Wildcard '?' List ---");
        // We make a list of numbers
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        
        // We make a list of words
        List<String> words = new ArrayList<>();
        words.add("Dog");
        words.add("Cat");
        
        // The wildcard method takes BOTH!
        demo.printAnyList(numbers);
        demo.printAnyList(words);
        
        /*
         * Expected Output:
         * --- Magic Methods ---
         * Magic Print: 24 (Type: Integer)
         * Magic Print: Hello (Type: String)
         * Magic Print: 3.14 (Type: Double)
         * 
         * --- Double Magic ---
         * Double Magic: Apples and 10
         * 
         * --- Wildcard '?' List ---
         * Here is the list: [1, 2, 3]
         * Here is the list: [Dog, Cat]
         */
    }
}