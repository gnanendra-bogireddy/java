package inputOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BufferedReader is like a big sponge that soaks up a lot of words at once!
 * 
 * We learned about Scanner, which is easy. But BufferedReader is FASTER for reading LOTS of text.
 * Imagine Scanner reading one letter at a time, while BufferedReader scoops up whole sentences in a bucket.
 */
public class BufferedReaderExample {
    
    // We add 'throws IOException' because reading from the keyboard can sometimes cause errors.
    public static void main(String[] args) throws IOException {
        
        System.out.println("--- Welcome to the Fast Reader ---");
        
        // 1. Set up the sponge (BufferedReader)
        // InputStreamReader takes the raw keyboard clicks and turns them into characters (letters).
        // BufferedReader puts those letters into a big bucket so we can read them fast!
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Type your favorite food: ");
        // 2. Read a whole line of text
        String food = reader.readLine();

        System.out.print("Type your age: ");
        // 3. BufferedReader ONLY reads Strings (words). 
        // If we want a number, we have to magically transform the word into a number!
        // Integer.parseInt() is the magic wand that turns the word "10" into the math number 10.
        int age = Integer.parseInt(reader.readLine());

        System.out.println("\nWow! You are " + age + " years old and love " + food + "!");
        
        /*
         * Expected Output (if you type 'Pizza' and '10'):
         * --- Welcome to the Fast Reader ---
         * Type your favorite food: Pizza
         * Type your age: 10
         * 
         * Wow! You are 10 years old and love Pizza!
         */
    }
}