package multiThreading;

public class DeadLockingExample {
    // Java program to demonstrate deadlock
    // using Main thread

    // Main driver method
    public static void main(String[] args) {

        // Try block to check for exceptions
        try {

            System.out.println("Thread state is : " + Thread.currentThread().getState());

            // Print statement
            System.out.println("Entering into Deadlock");

            // Joining the current thread
            Thread.currentThread().join();

            System.out.println("Thread state is : " + Thread.currentThread().getState());

            // This statement will never execute
            System.out.println("This statement will never execute");
        }

        // Catch block to handle the exceptions
        catch (InterruptedException e) {

            // Display the exception along with line number
            // using printStackTrace() method
            e.printStackTrace();
        }
    }
}

