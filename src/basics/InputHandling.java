package basics;

import java.util.Scanner;

/**
 * Input Handling is how we let the computer talk to us!
 * Imagine the computer is asking you a question, and you type the answer on your keyboard.
 * 
 * We use a special tool called a 'Scanner' to read what you type.
 * Think of the Scanner like a microphone for the computer.
 */
public class InputHandling {

    public static void main(String[] args) {

        // 1. Turn on the "microphone" (Scanner) to listen to the keyboard (System.in)
        Scanner mic = new Scanner(System.in); 

        System.out.println("Hello! What is your favorite number?");
        
        // 2. Wait for the person to type a number and press Enter
        // nextInt() grabs the number they typed.
        if(mic.hasNextInt()) {
            int favNumber = mic.nextInt(); 
            System.out.println("Wow, " + favNumber + " is a great number!");
        }

        // We have to clear out the "Enter" key press that was left behind
        mic.nextLine(); 

        System.out.println("What is your name?");
        
        // 3. Wait for the person to type words and press Enter
        // nextLine() grabs the whole sentence they typed.
        String name = mic.nextLine();
        System.out.println("Nice to meet you, " + name + "!");

        // 4. Turn off the microphone when we are done so it doesn't waste battery (memory)
        mic.close(); 
        
        /* 
         * Expected Output if I typed '7' and 'Hero':
         * Hello! What is your favorite number?
         * 7
         * Wow, 7 is a great number!
         * What is your name?
         * Hero
         * Nice to meet you, Hero!
         */
    }
}