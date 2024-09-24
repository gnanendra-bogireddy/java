package synchronization;

// A Java program to demonstrate working of synchronization
public class Synchronization {
    // Java Synchronization is used to make sure by some synchronization method that only one thread
    // can access the resource at a given point in time.


    // Only one thread can execute at a time.
    // sync_object is a reference to an object
    // whose lock associates with the monitor.
    // The code is said to be synchronized on
    // the monitor object
    // synchronized(sync_object)

    {
        // Access shared variables and other
        // shared resources
    }

    // Two types of Synchronization
    // Process and Thread synchronization
    // Thread synchronization has two types i.e
    // Mutual Exclusive
    // Cooperation (Inter-thread communication in Java)

    public static void main(String[] args) {

        {
            Sender send = new Sender();
            ThreadedSend S1 = new ThreadedSend(" Hi ", send);
            ThreadedSend S2 = new ThreadedSend(" Bye ", send);

            // Start two threads of ThreadedSend type
            S1.start();
            S2.start();

            // wait for threads to end
            try {
                S1.join();
                S2.join();
            } catch (Exception e) {
                System.out.println("Interrupted");
            }
        }

    }

}

// A Class used to send a message
class Sender {
    public void send(String msg) {
        System.out.println("Sending\t" + msg);
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Thread interrupted.");
        }
        System.out.println("\n" + msg + "Sent");
    }
}

// Class for send a message using Threads
class ThreadedSend extends Thread {
    private String msg;
    Sender sender;

    // Receives a message object and a string
    // message to be sent
    ThreadedSend(String m, Sender obj) {
        msg = m;
        sender = obj;
    }

    public void run() {
        // Only one thread can send a message
        // at a time.
        synchronized (sender) {
            // synchronizing the send object
            sender.send(msg);
        }
    }

    // An alternate implementation to demonstrate
    // that we can use synchronized with method also.

    class SenderOne {
        public synchronized void send(String msg) {
            System.out.println("Sending\t" + msg);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("Thread interrupted.");
            }
            System.out.println("\n" + msg + "Sent");
        }
    }

    // One more alternate implementation to demonstrate
    // that synchronized can be used with only a part of method
    class SenderTwo {
        public void send(String msg) {
            synchronized (this) {
                System.out.println("Sending\t" + msg);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println("Thread interrupted.");
                }
                System.out.println("\n" + msg + "Sent");
            }
        }
    }
}
