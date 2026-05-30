package methods;

/**
 * The Call Stack is like stacking pancakes!
 * 
 * When one method calls another method, it puts the new method ON TOP of the stack.
 * You ALWAYS have to finish eating the top pancake before you can get to the one underneath it!
 */
public class CallStackExample {

        public static void D() {
            // Method D is a tiny pancake. It prints and finishes right away.
            System.out.println("In Method D (Top Pancake finished!)");
        }

        public static void C() {
            // Method C is also a tiny pancake.
            System.out.println("In Method C (Top Pancake finished!)");
        }

        public static void B() {
            // Method B gets paused because it calls Method C!
            System.out.println("Method B called Method C... waiting...");
            C(); // Stack: Main -> A -> B -> [C is on top!]
            System.out.println("In Method B (Finished!)");
        }

        public static void A() {
            // Method A gets paused because it calls Method B!
            System.out.println("Method A called Method B... waiting...");
            B(); // Stack: Main -> A -> [B is on top!]
            System.out.println("In Method A (Finished!)");
        }

        public static void main(String[] args) {
            System.out.println("Main method started (Bottom Pancake)");
            
            // 1. We call A. Main pauses.
            A(); 
            
            // 2. When A, B, and C are completely finished, we call D!
            System.out.println("\nMain method is awake again! Now calling D...");
            D(); 
            
            System.out.println("Main method finished!");
            
            /*
             * Expected Output:
             * Main method started (Bottom Pancake)
             * Method A called Method B... waiting...
             * Method B called Method C... waiting...
             * In Method C (Top Pancake finished!)
             * In Method B (Finished!)
             * In Method A (Finished!)
             * 
             * Main method is awake again! Now calling D...
             * In Method D (Top Pancake finished!)
             * Main method finished!
             */
        }
}