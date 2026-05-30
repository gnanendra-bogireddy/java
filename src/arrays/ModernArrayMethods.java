package arrays;

import java.util.Arrays;

/**
 * Modern Array Methods are like cool toys to play with your boxes!
 * 
 * Java added a bunch of helper tools inside the 'Arrays' class so you 
 * don't have to write boring 'for' loops all the time.
 */
public class ModernArrayMethods {
    public static void main(String[] args) {

        System.out.println("--- Cool Array Tricks ---");

        int[] boxA = {1, 2, 3, 4, 5};
        int[] boxB = {1, 2, 99, 4, 5};

        // 1. Arrays.mismatch() (Java 9)
        // The Magnifying Glass! It finds the EXACT spot where two boxes are different.
        // It returns the index. If they are exactly the same, it returns -1.
        int brokenSpot = Arrays.mismatch(boxA, boxB);
        System.out.println("The boxes are different at spot (index): " + brokenSpot);

        // 2. Arrays.copyOf()
        // The Cloning Machine! Make a perfect copy of a box.
        int[] cloneBox = Arrays.copyOf(boxA, boxA.length);
        System.out.println("Clone box: " + Arrays.toString(cloneBox));

        // 3. Arrays.fill()
        // The Magic Wand! Turns EVERY toy in the box into the same thing.
        int[] emptyBox = new int[5];
        Arrays.fill(emptyBox, 7); // Fill the whole box with lucky number 7!
        System.out.println("Magic filled box: " + Arrays.toString(emptyBox));
        
        // 4. Arrays.equals()
        // The Judge! Are these two boxes EXACTLY the same?
        boolean areSame = Arrays.equals(boxA, cloneBox);
        System.out.println("Are boxA and cloneBox exactly the same? " + areSame);

        /*
         * Expected Output:
         * --- Cool Array Tricks ---
         * The boxes are different at spot (index): 2
         * Clone box: [1, 2, 3, 4, 5]
         * Magic filled box: [7, 7, 7, 7, 7]
         * Are boxA and cloneBox exactly the same? true
         */
    }
}