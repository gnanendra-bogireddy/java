package wrapperClasses;

/**
 * Wrapper Classes have Magic Tools!
 * 
 * Since they are big objects (and not just tiny primitives), they come with
 * built-in tools to help us do math, find max/min, or check what a character is!
 */
public class WrapperClassCreation {
    public static void main(String[] args) {

        System.out.println("--- Math Tools (Integer) ---");
        
        // 1. Parsing (Turning Words into Numbers)
        // This tool takes the WORD "101" and does magic to turn it into the NUMBER 101!
        int value = Integer.parseInt("101");
        System.out.println("Word '101' is now the number: " + (value + 9)); // Prints 110!

        // 2. Finding Max and Min
        // It's a referee! It looks at two numbers and tells you who wins.
        int maxValue = Integer.max(100, 198);
        System.out.println("Who is bigger (100 or 198)? " + maxValue);

        int minValue = Integer.min(100, 198);
        System.out.println("Who is smaller (100 or 198)? " + minValue);

        
        System.out.println("\n--- Inspector Tools (Character) ---");
        
        // These tools inspect a single character and answer YES (true) or NO (false).
        
        // Is 'A' a letter?
        System.out.println("Is 'A' a letter? " + Character.isLetter('A')); // true
        System.out.println("Is '0' a letter? " + Character.isLetter('0')); // false

        // Is '7' a digit (number)?
        System.out.println("Is '7' a digit? " + Character.isDigit('7')); // true

        // Is ' ' just empty space?
        System.out.println("Is ' ' a space? " + Character.isWhitespace(' ')); // true

        // Is it shouting (Upper Case)?
        System.out.println("Is 'U' uppercase? " + Character.isUpperCase('U')); // true
        System.out.println("Is 'l' lowercase? " + Character.isLowerCase('l')); // true
        
        /*
         * Expected Output:
         * --- Math Tools (Integer) ---
         * Word '101' is now the number: 110
         * Who is bigger (100 or 198)? 198
         * Who is smaller (100 or 198)? 100
         * 
         * --- Inspector Tools (Character) ---
         * Is 'A' a letter? true
         * Is '0' a letter? false
         * Is '7' a digit? true
         * Is ' ' a space? true
         * Is 'U' uppercase? true
         * Is 'l' lowercase? true
         */
    }
}