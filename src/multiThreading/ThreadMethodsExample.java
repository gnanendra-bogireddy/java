package multiThreading;

/**
 * Thread Methods (Like Priority) are like deciding who gets to play on the swing first!
 * 
 * If you have 3 friends wanting to swing, who goes first?
 * You give them a "Priority" number from 1 to 10.
 * 10 = SUPER IMPORTANT! Let them swing right now!
 * 1 = Not important, they can wait.
 */
public class ThreadMethodsExample extends Thread {

    public void run() {
        System.out.println("Hello from Thread: " + Thread.currentThread().getName() + 
                           " (Priority: " + Thread.currentThread().getPriority() + ")");
                           
        try {
            // Take a 1-second nap
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Woke up early!");
        }
    }

    public static void main(String[] args) {
        
        // Create 3 friends (Threads)
        ThreadMethodsExample friend1 = new ThreadMethodsExample();
        ThreadMethodsExample friend2 = new ThreadMethodsExample();
        ThreadMethodsExample friend3 = new ThreadMethodsExample();

        // Give them names so we know who is who!
        friend1.setName("Alice");
        friend2.setName("Bob");
        friend3.setName("Charlie");

        // Set Priorities! (1 is lowest, 10 is highest)
        friend1.setPriority(2); // Alice can wait
        friend2.setPriority(5); // Bob is in the middle
        friend3.setPriority(8); // Charlie really wants to go!

        // Let's look at the "Main" thread (the boss running this whole program)
        Thread mainBoss = Thread.currentThread();
        mainBoss.setName("The Boss Thread");
        mainBoss.setPriority(10); // The boss is the most important!
        
        System.out.println("I am: " + mainBoss.getName() + " with priority " + mainBoss.getPriority());

        // Tell all friends to start!
        // Note: Even with priorities, we can't GUARANTEE Charlie finishes first, 
        // but the computer will try its best to let high priority threads go faster!
        friend3.start();
        friend1.start();
        friend2.start();
        
        /*
         * Expected Output (Order might change slightly, but usually high priority starts first):
         * I am: The Boss Thread with priority 10
         * Hello from Thread: Charlie (Priority: 8)
         * Hello from Thread: Bob (Priority: 5)
         * Hello from Thread: Alice (Priority: 2)
         */
    }
}