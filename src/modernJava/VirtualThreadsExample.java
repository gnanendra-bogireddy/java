package modernJava;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Virtual Threads (Java 21) are like millions of tiny magical helpers!
 * 
 * A normal Thread (Platform Thread) is like a big, strong worker. But they are heavy, 
 * and your computer can only fit a few thousand of them in the room before it crashes.
 * 
 * A Virtual Thread is like a tiny fairy. You can easily have ONE MILLION of them 
 * working at the exact same time without your computer breaking a sweat!
 */
public class VirtualThreadsExample {
    public static void main(String[] args) {

        System.out.println("--- Starting the Tiny Helpers ---");

        // 1. Creating a single Virtual Thread using a factory
        ThreadFactory factory = Thread.ofVirtual().factory();
        Thread tinyHelper = factory.newThread(() -> {
            System.out.println("Hello from a Virtual Thread! My name is: " + Thread.currentThread().getName());
        });
        
        // We have to name it so we can see it!
        tinyHelper.setName("Helper-1");
        tinyHelper.start();

        // 2. A faster way to just run a quick Virtual Thread task
        Thread.startVirtualThread(() -> {
            System.out.println("Hello from another quick Virtual Thread!");
        });

        // 3. (Important) Because Virtual Threads are SO fast and light, 
        // the main program might finish before they do! 
        // So we wait for 1 second just to let them finish speaking.
        try {
            Thread.sleep(Duration.ofSeconds(1));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("--- All helpers are done! ---");

        /*
         * Expected Output (Order might change because they are very fast!):
         * --- Starting the Tiny Helpers ---
         * Hello from another quick Virtual Thread!
         * Hello from a Virtual Thread! My name is: Helper-1
         * --- All helpers are done! ---
         */
    }
}