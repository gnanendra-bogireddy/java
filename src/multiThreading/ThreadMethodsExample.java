package multiThreading;

public class ThreadMethodsExample extends Thread {

    // Java Program to Illustrate Priorities in Multithreading
    //  via help of getPriority() and setPriority() method


    // Method 1
    // run() method for the thread that is called
    // as soon as start() is invoked for thread in main()
    public void run() {
        // Print statement
        System.out.println("Inside run method from " + Thread.currentThread().getId());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread name : " + Thread.currentThread().getName());
        System.out.println("Thread state is : " + Thread.currentThread().getState());
        System.out.println("After sleeping for 5 sec " + Thread.currentThread().getId());
    }

    // Main driver method
    public static void main(String[] args) throws InterruptedException {
        // Creating random threads
        // with the help of above class
        ThreadMethodsExample t1 = new ThreadMethodsExample();
        ThreadMethodsExample t2 = new ThreadMethodsExample();
        ThreadMethodsExample t3 = new ThreadMethodsExample();

        // Thread 1
        // Display the priority of above thread
        // using getPriority() method
        System.out.println("t1 thread priority : " + t1.getPriority());

        // Thread 2
        // Display the priority of above thread
        System.out.println("t2 thread priority : " + t2.getPriority());

        // Thread 3
        System.out.println("t3 thread priority : " + t3.getPriority());

        // Setting priorities of above threads by
        // passing integer arguments
        t1.setPriority(2);
        t2.setPriority(5);
        t3.setPriority(8);

        // t3.setPriority(21); will throw
        // IllegalArgumentException
        // 2
        System.out.println("t1 thread priority : " + t1.getPriority());

        // 5
        System.out.println("t2 thread priority : " + t2.getPriority());

        // 8
        System.out.println("t3 thread priority : " + t3.getPriority());


        // Main thread
        // Displays the name of
        // currently executing Thread
        System.out.println("Currently Executing Thread : " + Thread.currentThread().getName());

        System.out.println("Main thread priority : " + Thread.currentThread().getPriority());

        // Main thread priority is set to 10
        Thread.currentThread().setPriority(10);
        Thread.currentThread().setName("High priority thread");

        System.out.println("Main thread priority : " + Thread.currentThread().getPriority());
        System.out.println("Main thread name : " + Thread.currentThread().getName());
        System.out.println("Main thread state is : " + Thread.currentThread().getState());

        t3.start();
        t1.start();
        t2.start();
    }
}

