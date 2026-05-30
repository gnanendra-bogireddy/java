package multiThreading;

/**
 * Multithreading is like doing chores with friends!
 * 
 * If you have to clean the whole house by yourself (1 Thread), it takes a long time.
 * But if you get 4 friends to help (Multi-threading), you can clean the living room, 
 * kitchen, bedroom, and bathroom AT THE SAME TIME! It's super fast!
 */
public class MultiThreadingExample extends Thread {

    // When we make a Thread, we HAVE to write a run() method.
    // This is the chore our friend is going to do!
    @Override
    public void run() {
        try {
            // Thread.currentThread().getId() tells us WHICH friend is currently working
            System.out.println("Friend #" + Thread.currentThread().getId() + " is cleaning a room!");
        } catch (Exception e) {
            System.out.println("Oh no, my friend dropped a broom!");
        }
    }

    public static void main(String[] args) {
        
        System.out.println("--- Let's clean the house! ---");
        
        int numberOfFriends = 4; 
        
        // We invite 4 friends over and tell them to start working!
        for (int i = 0; i < numberOfFriends; i++) {
            
            // 1. Create a new Friend (Thread)
            MultiThreadingExample friend = new MultiThreadingExample();
            
            // 2. Tell them to START working! (This magically calls the run() method above)
            friend.start(); 
        }

        // There is ANOTHER way to make friends help, using 'Runnable'.
        // It's like giving them a specific instruction manual to follow.
        for (int i = 0; i < numberOfFriends; i++) {
            Thread anotherFriend = new Thread(new MultithreadingDemo());
            anotherFriend.start();
        }
        
        /*
         * Expected Output (The order might change because they are all working at the same time!):
         * --- Let's clean the house! ---
         * Friend #15 is cleaning a room!
         * Friend #16 is cleaning a room!
         * Friend #18 is cleaning a room!
         * Friend #17 is cleaning a room!
         * Friend #19 is cleaning a room!
         * Friend #20 is cleaning a room!
         * Friend #21 is cleaning a room!
         * Friend #22 is cleaning a room!
         */
    }
}

// This is the instruction manual (Runnable) for the second group of friends
class MultithreadingDemo implements Runnable {
    public void run() {
        try {
            System.out.println("Friend #" + Thread.currentThread().getId() + " is cleaning a room using instructions!");
        } catch (Exception e) {
            System.out.println("Oh no, an error!");
        }
    }
}