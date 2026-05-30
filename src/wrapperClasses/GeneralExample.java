package wrapperClasses;

import java.util.ArrayList;

/**
 * Wrapper Classes are like putting a sweater on a number!
 * 
 * Java has small, simple data types like 'int' and 'char'. (These are primitives).
 * But sometimes Java NEEDS them to be "Objects" (like when putting them in a List).
 * So, we wrap them in a special sweater (Wrapper Class) to make them an Object!
 * 
 * int -> Integer
 * char -> Character
 * double -> Double
 */
public class GeneralExample {
    public static void main(String[] args) {

        System.out.println("--- Autoboxing (Putting the sweater ON) ---");
        
        char tinyLetter = 'a'; // Primitive
        
        // Java magically puts a sweater on the tiny letter to make it a Big Object!
        // This is called Autoboxing.
        Character bigLetter = tinyLetter; 
        System.out.println("Big Letter Object: " + bigLetter);

        // ArrayLists ONLY hold objects. They cannot hold primitive 'int'.
        ArrayList<Integer> numberList = new ArrayList<>();
        
        // We type '25' (an int), but Java automatically wraps it in an Integer sweater!
        numberList.add(25);
        System.out.println("Number from list: " + numberList.get(0));

        
        System.out.println("\n--- Unboxing (Taking the sweater OFF) ---");
        
        Character fancyLetter = 'z'; // An Object
        
        // Java automatically takes the sweater off to make it a tiny primitive again!
        char normalLetter = fancyLetter;
        System.out.println("Normal tiny letter: " + normalLetter);


        System.out.println("\n--- Type Casting (Squeezing into a smaller box) ---");
        
        double bigDecimal = 100.99; // Takes up a lot of space
        
        // We FORCE the big decimal into an integer box. 
        // It's too big, so the decimal part (.99) gets chopped off and thrown away!
        int choppedNumber = (int) bigDecimal; 
        
        System.out.println("Original big decimal: " + bigDecimal);
        System.out.println("Chopped integer: " + choppedNumber); // It is now just 100!
        
        /*
         * Expected Output:
         * --- Autoboxing (Putting the sweater ON) ---
         * Big Letter Object: a
         * Number from list: 25
         * 
         * --- Unboxing (Taking the sweater OFF) ---
         * Normal tiny letter: z
         * 
         * --- Type Casting (Squeezing into a smaller box) ---
         * Original big decimal: 100.99
         * Chopped integer: 100
         */
    }
}