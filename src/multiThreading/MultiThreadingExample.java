package multiThreading;

public class MultiThreadingExample extends Thread {

    // Multithreading is a Java feature that allows concurrent execution of two or more parts
    // of a program for maximum utilization of CPU. Each part of such program is called a thread.
    // So, threads are light-weight processes within a process.
    // Threads can be created by using two mechanisms
    // Extending the Thread class
    // Implementing the Runnable Interface

    @Override
    public void run() {
        try {
            // Displaying the thread that is running
            System.out.println("Thread " + Thread.currentThread().getId() + " is running");
        } catch (Exception e) {
            // Throwing an exception
            System.out.println("Exception is caught");
        }
    }

    public static void main(String[] args) {
        int n = 8; // Number of threads
        for (int i = 0; i < n; i++) {
            MultiThreadingExample object = new MultiThreadingExample();
            object.start();
        }

        for (int i = 0; i < n; i++) {
            Thread object = new Thread(new MultithreadingDemo());
            object.start();
        }
    }
}

class MultithreadingDemo implements Runnable {
    public void run() {
        try {
            // Displaying the thread that is running
            System.out.println("Thread " + Thread.currentThread().getId() + " is running");
        } catch (Exception e) {
            // Throwing an exception
            System.out.println("Exception is caught");
        }
    }
}
