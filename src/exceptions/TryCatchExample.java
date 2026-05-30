package exceptions;

/**
 * Try-Catch is like wearing a helmet when riding a bike!
 * 
 * 'try' means: "I'm going to try this dangerous trick (code)."
 * 'catch' means: "If I fall (get an error), my helmet will catch me so I don't get hurt (crash)!"
 * 'finally' means: "No matter what happens, I will put my bike away when I'm done."
 */
public class TryCatchExample {

    public static void main(String[] args) {

        System.out.println("--- Trying a math trick ---");
        
        try {
            // We are going to TRY something dangerous.
            // You can't divide by zero! It's against math rules!
            int a = 5;
            int b = 0;
            System.out.println("Let's divide 5 by 0: " + (a / b)); 
            
        } catch (ArithmeticException exception) {
            // Oh no, we fell! But our catch block (helmet) saved us!
            System.out.println("Caught an error! You can't divide by zero, silly!");
            
        } finally {
            // This ALWAYS runs, whether we fell or not.
            System.out.println("Putting the math book away. (I am in the finally block)");
        }

        /*
         * Expected Output:
         * --- Trying a math trick ---
         * Caught an error! You can't divide by zero, silly!
         * Putting the math book away. (I am in the finally block)
         */
    }
}