package exceptions;

/**
 * User-Defined Exceptions are like making up your own rule!
 * 
 * Imagine you have a rule: "No eating cookies before dinner!"
 * Java doesn't know about cookies, so you have to create your own Exception for it.
 */

// 1. First, we make our own Exception by adding "extends Exception"
class NoCookiesException extends Exception {
    
    // We create a constructor to pass our custom message to the big Exception boss (super)
    public NoCookiesException(String message) {
        super(message);
    }
}

// 2. Then, we use it!
public class UserDefinedException {
    
    public static void main(String args[]) {
        
        boolean ateCookieBeforeDinner = true;
        
        try {
            System.out.println("Checking if you ate a cookie...");
            
            if (ateCookieBeforeDinner) {
                // Uh oh, you broke the rule! We THROW our custom error!
                throw new NoCookiesException("Hey! No eating cookies before dinner!");
            }
            
            System.out.println("Good job, you waited for dinner.");
            
        } catch (NoCookiesException ex) {
            // Our helmet catches our custom error!
            System.out.println("Uh oh... Rule broken!");
            System.out.println("Message: " + ex.getMessage());
        }
        
        /*
         * Expected Output:
         * Checking if you ate a cookie...
         * Uh oh... Rule broken!
         * Message: Hey! No eating cookies before dinner!
         */
    }
}