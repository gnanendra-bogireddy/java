package basics;

/**
 * Decision Making in Java is like making a choice in real life.
 * Example: "If it's raining, I will take an umbrella. Otherwise, I will wear sunglasses."
 * 
 * We use these main tools to make choices:
 * 1. if (just checking one thing)
 * 2. if-else (checking one thing, with a backup plan)
 * 3. else-if (checking multiple things in a row)
 * 4. switch (like a vending machine: press button 5, get a specific snack)
 */
public class DecisionMaking {

    public static void main(String[] args) {

        int myAge = 10;

        // 1. Simple 'if'
        // Just checking one thing!
        if (myAge < 15) {
            System.out.println("I am younger than 15!"); 
            // Output: I am younger than 15!
        }

        // 2. 'if-else' (Backup plan)
        // If the first thing is true, do it. Otherwise (else), do the backup plan.
        if (myAge >= 18) {
            System.out.println("I am an adult.");
        } else {
            System.out.println("I am still a kid!"); 
            // Output: I am still a kid!
        }

        // 3. 'if-else-if' ladder (Checking a list of things)
        if (myAge == 5) {
            System.out.println("I am a kindergartener.");
        } else if (myAge == 10) {
            System.out.println("I am a 10-year-old!"); 
            // Output: I am a 10-year-old!
        } else {
            System.out.println("I am some other age.");
        }

        // 4. 'switch' statement (Vending Machine)
        // We have a number, and we want to jump exactly to that case (button).
        int vendingMachineButton = 2;
        switch (vendingMachineButton) {
            case 1:
                System.out.println("You get a Chocolate Bar!");
                break; // 'break' means stop here, don't drop the other snacks!
            case 2:
                System.out.println("You get Potato Chips!"); 
                // Output: You get Potato Chips!
                break; 
            case 3:
                System.out.println("You get a Soda!");
                break;
            default: // This is what happens if they press a button that doesn't exist
                System.out.println("Error: Empty slot.");
        }
    }
}