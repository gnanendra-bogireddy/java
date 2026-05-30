package multiThreading;

/**
 * Thread States are like a person's daily routine!
 * 
 * 1. NEW: A baby is born, but hasn't started doing anything yet.
 * 2. RUNNABLE: Awake and doing chores (or ready to do chores).
 * 3. BLOCKED: Waiting in line for the bathroom (stuck behind someone else).
 * 4. WAITING: Waiting for a friend to finish their chore before you can start yours.
 * 5. TIMED_WAITING: Taking a quick nap for exactly 5 minutes.
 * 6. TERMINATED: Finished all chores and went to sleep for the night!
 */
public class ThreadExample implements Runnable {

    // This is the chore for Thread 2
    public void run() {
        try {
            // Thread 2 takes a quick nap (TIMED_WAITING)
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("State of Thread 1 while waiting for Thread 2: " + Test.thread1.getState());
        
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Test implements Runnable {
    public static Thread thread1;
    public static Test obj;

    public static void main(String[] args) {
        obj = new Test();
        thread1 = new Thread(obj);

        // thread1 is just born!
        System.out.println("State of Thread 1 when just born: " + thread1.getState()); 
        
        // Wake up thread 1!
        thread1.start();
        
        System.out.println("State of Thread 1 after waking up (.start): " + thread1.getState()); 
    }

    // This is the chore for Thread 1
    public void run() {
        ThreadExample myThread = new ThreadExample();
        Thread thread2 = new Thread(myThread);

        // thread2 is just born!
        System.out.println("State of Thread 2 when just born: " + thread2.getState());
        thread2.start();

        System.out.println("State of Thread 2 after waking up (.start): " + thread2.getState());

        try {
            // Thread 1 takes a tiny nap while Thread 2 starts doing work
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Since Thread 2 called Thread.sleep(1500) up above, it is taking a nap now!
        System.out.println("State of Thread 2 while taking a nap (.sleep): " + thread2.getState());

        try {
            // Thread 1 says: "I will WAIT until Thread 2 is completely finished!" (WAITING)
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Thread 2 is completely done with its work!
        System.out.println("State of Thread 2 when completely finished: " + thread2.getState());
        
        /*
         * Expected Output:
         * State of Thread 1 when just born: NEW
         * State of Thread 1 after waking up (.start): RUNNABLE
         * State of Thread 2 when just born: NEW
         * State of Thread 2 after waking up (.start): RUNNABLE
         * State of Thread 2 while taking a nap (.sleep): TIMED_WAITING
         * State of Thread 1 while waiting for Thread 2: WAITING
         * State of Thread 2 when completely finished: TERMINATED
         */
    }
}