package inputOutput;

import java.util.Scanner;

/**
 * Scanner is the easiest way to talk to your computer program!
 * 
 * Think of it as a tool that waits for you to type something and press Enter.
 * It has different "grabbers" depending on what you type (numbers, words, decimals).
 */
public class ScannerDemo {

    public static void main(String[] args) {
        
        System.out.println("--- The Scanner Tool ---");
        
        // 1. Turn on the Scanner to listen to the keyboard (System.in)
        Scanner scn = new Scanner(System.in);

        // 2. Grab a SINGLE WORD
        // next() stops grabbing as soon as it sees a space!
        System.out.print("Type a single word: ");
        String oneWord = scn.next();
        System.out.println("You typed the word: " + oneWord);

        // We have to use nextLine() here to clean up the "Enter" key press we left behind
        // otherwise the next question gets skipped!
        scn.nextLine(); 

        // 3. Grab a WHOLE SENTENCE
        // nextLine() grabs everything until you press Enter.
        System.out.print("Type a whole sentence: ");
        String sentence = scn.nextLine();
        System.out.println("You typed the sentence: " + sentence);

        // 4. Grab an INTEGER (a whole number)
        System.out.print("Type a whole number (like 5): ");
        int wholeNumber = scn.nextInt();
        System.out.println("You typed the number: " + wholeNumber);

        // 5. Grab a FLOAT (a number with a decimal, like 3.14)
        System.out.print("Type a decimal number (like 3.5): ");
        float decimalNumber = scn.nextFloat();
        System.out.println("You typed the decimal: " + decimalNumber);
        
        // Always close your Scanner when you are done playing with it!
        scn.close();
        
        /*
         * Expected Output (if you type 'Hello', 'I love Java', '10', '9.9'):
         * --- The Scanner Tool ---
         * Type a single word: Hello
         * You typed the word: Hello
         * Type a whole sentence: I love Java
         * You typed the sentence: I love Java
         * Type a whole number (like 5): 10
         * You typed the number: 10
         * Type a decimal number (like 3.5): 9.9
         * You typed the decimal: 9.9
         */
    }
}