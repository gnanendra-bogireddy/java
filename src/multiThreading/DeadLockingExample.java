package multiThreading;

/**
 * Deadlock is like a silly argument over toys!
 * 
 * Imagine two kids, Alice and Bob. 
 * Alice has the toy Car, but wants the toy Train.
 * Bob has the toy Train, but wants the toy Car.
 * 
 * Alice says: "I won't give you the Car until you give me the Train!"
 * Bob says: "I won't give you the Train until you give me the Car!"
 * 
 * Now they are STUCK FOREVER! This is called a Deadlock.
 */
public class DeadLockingExample {
    
    public static void main(String[] args) {

        try {

            System.out.println("Main Thread state: " + Thread.currentThread().getState());

            // A thread is telling ITSELF to wait for ITSELF to finish!
            // It's like saying "I won't eat my dessert until I finish eating my dessert."
            // It gets stuck forever!
            System.out.println("Uh oh, entering a Deadlock...");

            // .join() means "wait for this thread to finish".
            // Since we are calling it on ourself, we wait forever.
            Thread.currentThread().join(); 

            // WE WILL NEVER REACH THIS LINE! The program is completely stuck above.
            System.out.println("You will never see this message!");

        } catch (InterruptedException e) {
            System.out.println("Someone interrupted our waiting!");
        }
        
        /*
         * Expected Output:
         * Main Thread state: RUNNABLE
         * Uh oh, entering a Deadlock...
         * (The program gets stuck here forever and never finishes!)
         */
    }
}