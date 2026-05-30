package basics;

/**
 * 'Return' is like sending a package in the mail.
 * 
 * Imagine you ask your friend to build a LEGO car for you.
 * You give them the LEGO pieces (inputs).
 * They build the car, and then they 'return' the finished car back to you!
 */
public class ReturnExample {
    
        // This is our "Friend" who builds things. 
        // We tell them we want an 'int' (a number) back.
        // We give them two pieces: num1 and num2.
        public static int addNumbers(int num1, int num2) {
            
            System.out.println("Friend: I am adding " + num1 + " and " + num2);
            int total = num1 + num2;
            
            // This is where the friend gives the finished total back to us!
            // Once they say 'return', their job is completely done.
            return total; 
        }
        
        public static void main(String[] args) {
            
            System.out.println("Me: Hey Friend, what is 5 + 10?");
            
            // We call our friend and wait for the package (result) to arrive.
            int myAnswer = addNumbers(5, 10);
            
            // We open the package!
            System.out.println("Me: Thanks! The answer is " + myAnswer);
            
            /*
             * Expected Output:
             * Me: Hey Friend, what is 5 + 10?
             * Friend: I am adding 5 and 10
             * Me: Thanks! The answer is 15
             */
        }
    }