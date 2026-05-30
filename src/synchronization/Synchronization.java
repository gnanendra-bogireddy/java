package synchronization;

/**
 * Synchronization is like taking turns on a slide!
 * 
 * Imagine 3 kids want to go down the same slide at the same time. They will crash!
 * To fix this, we put a "Lock" on the slide.
 * When Kid 1 goes down, they take the Lock. Kid 2 and 3 MUST wait until Kid 1 is done.
 * 
 * In Java, the slide is a "Resource" and the kids are "Threads".
 */
public class Synchronization {

    public static void main(String[] args) {

        System.out.println("--- Kids want to send messages! ---");
        
        // This is our slide (The shared resource)
        Sender slide = new Sender();
        
        // These are our kids (Threads) who both want to use the slide!
        ThreadedSend kid1 = new ThreadedSend("Hello from Kid 1!", slide);
        ThreadedSend kid2 = new ThreadedSend("Hello from Kid 2!", slide);

        // Start them both at the exactly same time!
        kid1.start();
        kid2.start();

        try {
            kid1.join();
            kid2.join();
        } catch (Exception e) {
            System.out.println("Interrupted");
        }
    }
}

// The Slide!
class Sender {
    // We add 'synchronized' so only ONE kid can use this method at a time!
    // If we remove 'synchronized', their messages will get all mixed up.
    public synchronized void send(String msg) {
        System.out.println("Typing: " + msg);
        try {
            // It takes 1 second to type the message (simulating work)
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Thread interrupted.");
        }
        System.out.println("Sent: " + msg + "\n");
    }
}

// The Kids (Threads)
class ThreadedSend extends Thread {
    private String msg;
    Sender senderSlide;

    ThreadedSend(String m, Sender obj) {
        msg = m;
        senderSlide = obj;
    }

    public void run() {
        // The kid tries to use the slide to send their message!
        senderSlide.send(msg);
    }
}