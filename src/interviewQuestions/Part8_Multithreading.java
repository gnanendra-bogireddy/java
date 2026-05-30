package interviewQuestions;

import java.util.concurrent.*;
import java.util.concurrent.locks.*;

/**
 * ============================================================================
 * INTERVIEW QUESTIONS PART 8: Multithreading & Concurrency
 * ============================================================================
 * This file contains 30 highly detailed Java interview questions.
 * Each question provides a deep-dive English explanation covering the 'What', 
 * 'Why', and 'How', along with practical Java code snippets.
 * ============================================================================
 */
public class Part8_Multithreading {

    public static void main(String[] args) {
        System.out.println("Running Part 8: Multithreading and Concurrency...");
    }

    /**
     * Q1: [Easy] What is a Thread and how does the Thread Class work?
     * 
     * DETAILED EXPLANATION:
     * A Thread is a lightweight, independent path of execution within a program. When a Java program starts, 
     * it begins with one primary thread (the "Main" thread). By creating multiple threads, a program can 
     * perform multiple tasks simultaneously (Concurrency), dramatically utilizing multi-core processors.
     * You can create a custom thread by extending the `java.lang.Thread` class and overriding its `run()` 
     * method to define the specific background task.
     */
    public void threadClass() {
        System.out.println("Thread Class: The foundational OS-level execution path wrapper.");
    }

    /**
     * Q2: [Easy] What is the Runnable Interface and why is it preferred over extending Thread?
     * 
     * DETAILED EXPLANATION:
     * The `Runnable` interface is a Functional Interface containing exactly one method: `run()`. 
     * You implement this interface to define a task, and then hand that task to a Thread object to execute.
     * WHY IT IS BETTER: Java strictly forbids multiple class inheritance. If your class extends `Thread`, it 
     * can NEVER extend any other business-logic class. By implementing `Runnable` instead, your class remains 
     * free to extend whatever parent class it needs to. Furthermore, `Runnable` perfectly separates the "Task" 
     * logic from the "Thread Runner" infrastructure, aligning with clean OOP design.
     */
    public void runnableInterface() {
        System.out.println("Runnable: Decouples the work (task) from the worker (Thread), allowing flexible inheritance.");
    }

    /**
     * Q3: [Medium] Walk through the Java Thread Lifecycle.
     * 
     * DETAILED EXPLANATION:
     * A Thread exists in exactly one of these distinct states at any given moment:
     * 1. NEW: The object is created (`new Thread()`), but `.start()` hasn't been called.
     * 2. RUNNABLE: The thread is actively executing code, OR is waiting in the OS queue for a CPU core.
     * 3. BLOCKED: The thread is waiting to enter a `synchronized` block, but another thread has the lock.
     * 4. WAITING: The thread called `.wait()` or `.join()` and is waiting INDEFINITELY for a signal from someone else.
     * 5. TIMED_WAITING: The thread called `Thread.sleep(1000)` and is taking a timed nap.
     * 6. TERMINATED: The `run()` method has completed its final line of code and the thread is dead.
     */
    public void threadLifecycle() {
        System.out.println("Lifecycle: New -> Runnable -> (Blocked/Waiting/Timed_Waiting) -> Terminated.");
    }

    /**
     * Q4: [Easy] Why must you call start() instead of run()?
     * 
     * DETAILED EXPLANATION:
     * This is a massive interview trap. If you instantiate a Thread and call `.run()` directly, the JVM does 
     * NOT spawn a new thread. It simply executes the code inside `run()` synchronously on the current Main thread, 
     * completely defeating the purpose of concurrency. 
     * Calling `.start()` commands the JVM to communicate with the Operating System, allocate a brand new 
     * Call Stack in memory, spawn a parallel execution path, and THEN the OS invokes the `.run()` method 
     * independently on that new thread.
     */
    public void startVsRun() {
        System.out.println("start() creates new OS infrastructure. run() is just a normal method call.");
    }

    /**
     * Q5: [Easy] What does Thread.sleep() do mechanically?
     * 
     * DETAILED EXPLANATION:
     * `Thread.sleep(milliseconds)` pauses the execution of the CURRENT thread. 
     * The thread releases its grip on the CPU core so other threads can do work, but CRITICALLY: it does NOT 
     * release any object Monitor Locks it might be holding. If a sleeping thread is holding the lock to a 
     * synchronized database method, all other threads will remain severely blocked until it wakes up and finishes.
     */
    public void threadSleep() {
        System.out.println("sleep(): Pauses the thread but strictly maintains all held synchronization locks.");
    }

    /**
     * Q6: [Medium] What is Thread.join() and when is it used?
     * 
     * DETAILED EXPLANATION:
     * `join()` is a synchronization tool. If the Main Thread spawns a worker thread (`Thread t`), and then 
     * the Main Thread invokes `t.join()`, the Main Thread immediately pauses and goes into a WAITING state. 
     * It will absolutely not execute its next line of code until thread `t` completes its job and TERMINATES. 
     * Use Case: If a background thread is calculating a complex mathematical result, the main thread must wait 
     * via `join()` to receive that result before continuing to print the UI.
     */
    public void threadJoin() {
        System.out.println("join(): Forces the calling thread to wait until the target thread completely finishes and dies.");
    }

    /**
     * Q7: [Medium] What is Thread.yield()?
     * 
     * DETAILED EXPLANATION:
     * A highly rarely used hint mechanism. Calling `Thread.yield()` tells the OS Thread Scheduler: 
     * "I am doing something not very important right now. If there are other threads of the same priority waiting 
     * for CPU time, I will voluntarily step aside and let them run." 
     * Crucially, the OS is entirely free to completely ignore this hint, meaning developers should never rely 
     * on it for strict logical formatting.
     */
    public void threadYield() {
        System.out.println("yield(): A polite, ignorable hint to the CPU scheduler to let other threads process.");
    }

    /**
     * Q8: [Advanced] Why is stop() deprecated and how do you use interrupt() instead?
     * 
     * DETAILED EXPLANATION:
     * The `stop()` method is violently unsafe. It kills a thread instantly. If the thread was halfway through 
     * writing a critical file, the file is permanently corrupted and left locked. 
     * The modern, safe way is `interrupt()`. This sets an "Interrupted Flag" on the thread to true. If the 
     * thread is currently sleeping or waiting, it instantly wakes up and throws an `InterruptedException`. 
     * The thread catches this exception, performs safe cleanup of its files/connections, and shuts down gracefully.
     */
    public void threadInterrupt() {
        System.out.println("interrupt(): The safe, modern signaling mechanism for requesting a thread to shut down.");
    }

    /**
     * Q9: [Medium] Differentiate Daemon Threads from User Threads.
     * 
     * DETAILED EXPLANATION:
     * When the JVM starts, it creates User Threads (like the Main thread). The JVM is programmed to NEVER shut 
     * down as long as even ONE single User Thread is still running. 
     * Daemon Threads are low-priority, background service threads (like the Garbage Collector or memory monitors). 
     * The JVM ignores them during shutdown. If all User Threads finish, the JVM will ruthlessly terminate the 
     * process and kill all active Daemon Threads instantly, regardless of what they are doing.
     */
    public void daemonThreads() {
        System.out.println("Daemon Threads: Expendable background services that do not prevent JVM shutdown.");
    }

    /**
     * Q10: [Easy] How does Thread Priority affect execution?
     * 
     * DETAILED EXPLANATION:
     * Every thread carries an integer priority from 1 (MIN) to 10 (MAX), defaulting to 5 (NORM). 
     * This is merely a suggestion given to the underlying Operating System's Thread Scheduler. The OS tries 
     * to dedicate more CPU cycles to Priority 10 threads, but it does NOT guarantee strict execution order. 
     * Relying on priorities for program correctness is considered an anti-pattern.
     */
    public void threadPriority() {
        System.out.println("Priority: An OS hint allocating CPU focus, but guarantees absolutely nothing regarding execution order.");
    }

    /**
     * Q11: [Medium] Define Synchronization conceptually.
     * 
     * DETAILED EXPLANATION:
     * When multiple threads are running wildly, they might try to read and write to the same exact memory variable 
     * at the exact same millisecond, corrupting the data entirely. 
     * Synchronization is the mechanism of enforcing an orderly queue. It ensures that only ONE single thread is 
     * allowed to enter a critical section of code at a time, completely preventing data corruption.
     */
    public void synchronization() {
        System.out.println("Synchronization: Enforces mutually exclusive access to critical memory structures.");
    }

    /**
     * Q12: [Medium] How do Synchronized Methods work mechanically?
     * 
     * DETAILED EXPLANATION:
     * By adding the `synchronized` keyword to a method signature, you turn the entire method into a vault. 
     * Every object in Java has a hidden, intrinsic "Monitor Lock". When Thread A calls a synchronized method, 
     * it grabs the object's lock and locks the door behind it. 
     * If Thread B tries to call ANY synchronized method on that same object, it finds the door locked and is 
     * placed into a BLOCKED state until Thread A finishes and releases the lock.
     */
    public void syncMethod() {
        System.out.println("Synchronized Method: Acquires the blanket object lock, restricting parallel access to the entire method.");
    }

    /**
     * Q13: [Medium] Why are Synchronized Blocks superior to Synchronized Methods?
     * 
     * DETAILED EXPLANATION:
     * Synchronizing an entire 100-line method creates massive performance bottlenecks because only one thread 
     * can run it at a time. 
     * Often, only 3 lines of that method actually modify shared data. A Synchronized Block allows you to lock 
     * ONLY those 3 specific lines (e.g., `synchronized(this) { ... }`). The other 97 lines remain completely 
     * open for parallel multi-threading, massively improving application throughput.
     */
    public void syncBlock() {
        System.out.println("Synchronized Block: Minimizes the locked footprint, drastically improving concurrency speed.");
    }

    /**
     * Q14: [Medium] Differentiate Object Level Lock vs Class Level Lock.
     * 
     * DETAILED EXPLANATION:
     * - Object Level Lock: `synchronized(this)`. Restricts threads from concurrently executing synchronized 
     *   blocks on the EXACT SAME physical object instance in the heap.
     * - Class Level Lock: `synchronized(MyClass.class)` or a `static synchronized` method. Restricts threads 
     *   across EVERY SINGLE INSTANCE of that class globally. If you have 50 'Car' objects, and one thread enters 
     *   a Class Level lock, NO other thread can enter that static block on ANY of the 50 Car objects.
     */
    public void classLock() {
        System.out.println("Class Lock: A global lock affecting every single instantiated object of the class.");
    }

    /**
     * Q15: [Advanced] Detail the mechanics of wait(), notify(), and notifyAll().
     * 
     * DETAILED EXPLANATION:
     * These methods belong to the `Object` class, not the `Thread` class, because they manipulate the object's Monitor Lock. 
     * They are the foundation of Inter-Thread Communication. 
     * - `wait()`: The thread immediately releases the lock it is holding and goes to sleep indefinitely, allowing 
     *   other threads to enter the synchronized block.
     * - `notify()`: Another thread finishes its work and calls this to wake up ONE single waiting thread.
     * - `notifyAll()`: Wakes up EVERY thread that is waiting on this specific object lock. 
     * Rule: These methods MUST be called from completely inside a synchronized block, or they throw an IllegalMonitorStateException.
     */
    public void interThreadComm() {
        System.out.println("Wait/Notify: Communication orchestration. Wait RELEASES the lock, sleep() does not.");
    }

    /**
     * Q16: [Advanced] Dissect a Thread Deadlock. How does it happen?
     * 
     * DETAILED EXPLANATION:
     * A Deadlock is a fatal architectural flaw where the entire application freezes permanently. 
     * It occurs when multiple threads hold locks that the other threads need to proceed.
     * Example: Thread 1 locks Resource A, and then tries to lock Resource B. Simultaneously, Thread 2 locks 
     * Resource B, and then tries to lock Resource A. 
     * Both threads are now waiting forever for the other to release their lock. The JVM cannot resolve this, 
     * and the application must be manually restarted.
     */
    public void deadlock() {
        System.out.println("Deadlock: A permanent structural freeze caused by cyclical lock dependencies.");
    }

    /**
     * Q17: [Advanced] What is a Livelock and how is it worse than a Deadlock?
     * 
     * DETAILED EXPLANATION:
     * In a Deadlock, threads are completely frozen (Blocked). They consume zero CPU. 
     * In a Livelock, threads are NOT blocked. They are actively changing states, trying to resolve the conflict, 
     * but they end up in an infinite, active loop doing zero productive work. 
     * Analogy: Two people meet in a hallway. Both step to the left to let the other pass. Then both step to 
     * the right. They repeat this dance forever. Because they are active, Livelocks completely max out the CPU at 100%.
     */
    public void livelock() {
        System.out.println("Livelock: An active, infinite resolution loop that completely spikes CPU usage to 100%.");
    }

    /**
     * Q18: [Advanced] Explain Thread Starvation.
     * 
     * DETAILED EXPLANATION:
     * Starvation occurs when a low-priority thread is perpetually denied access to the CPU or a shared resource 
     * because greedy, high-priority threads constantly monopolize the system. 
     * The starved thread never gets a chance to make progress, causing specific features of the application 
     * to silently fail or hang. Java's `ReentrantLock` offers "Fairness Policies" to ensure the longest-waiting 
     * thread gets the lock next, preventing starvation.
     */
    public void starvation() {
        System.out.println("Starvation: A thread is perpetually bypassed by greedy/higher-priority threads.");
    }

    /**
     * Q19: [Medium] Define a Race Condition in raw memory terms.
     * 
     * DETAILED EXPLANATION:
     * A Race Condition occurs when a read-modify-write operation (like `counter++`) is not synchronized. 
     * `counter++` is actually 3 operations: Read memory, Add 1, Write memory. 
     * If Thread A and Thread B both read the counter at value 10 simultaneously, they both add 1 to it in their 
     * local cache, and both write 11 back to memory. Two increments occurred, but the counter only went up by one. 
     * The threads "raced" to overwrite each other, causing silent, massive data corruption.
     */
    public void raceCondition() {
        System.out.println("Race Condition: Silent data corruption caused by simultaneous, unsynchronized Read-Modify-Write operations.");
    }

    /**
     * Q20: [Advanced] What is the true purpose of the 'volatile' Keyword?
     * 
     * DETAILED EXPLANATION:
     * To improve speed, every Thread creates a local "CPU Cache" of shared variables. If a thread loops while 
     * `isRunning` is true, it checks its local cache. If another thread changes `isRunning` to false in main 
     * memory, the first thread might never see it and loops forever. 
     * Marking a variable as `volatile` destroys the caching mechanism. It forces every single thread to bypass 
     * their local CPU cache and read/write the variable directly from the system's Main Memory, guaranteeing 
     * instantaneous visibility of changes to all threads.
     */
    public void volatileKeyword() {
        System.out.println("Volatile: Forces strict Main-Memory read/writes to guarantee cross-thread visibility.");
    }

    /**
     * Q21: [Medium] Why is ThreadLocal critical for SDETs and WebDrivers?
     * 
     * DETAILED EXPLANATION:
     * `ThreadLocal` creates a unique, isolated instance of a variable for EVERY single thread that accesses it. 
     * In Parallel Test Automation, if you use a static `WebDriver driver`, Thread 1 will open a browser, and 
     * Thread 2 will instantly overwrite that variable with a new browser, causing Thread 1's test to crash. 
     * By wrapping the WebDriver in a `ThreadLocal<WebDriver>`, Thread 1 gets Chrome, and Thread 2 gets Firefox. 
     * They are perfectly isolated in their own memory silos and will never conflict.
     */
    public void threadLocalExample() {
        System.out.println("ThreadLocal: Generates totally isolated variable instances per thread, crucial for parallel testing.");
    }

    /**
     * Q22: [Medium] How does the Callable Interface differ from Runnable?
     * 
     * DETAILED EXPLANATION:
     * The `Runnable` interface has a strict `public void run()` method. It cannot return any data to the main 
     * program, and it cannot throw checked exceptions. 
     * The `Callable<V>` interface was introduced later to fix this. It has a `public V call() throws Exception` 
     * method. It allows a background thread to calculate a complex result (like parsing a massive file) and 
     * securely return that specific result Object back to the calling thread.
     */
    public void callableInterface() {
        System.out.println("Callable: An advanced task interface capable of returning data and throwing checked exceptions.");
    }

    /**
     * Q23: [Medium] Describe the Future Interface.
     * 
     * DETAILED EXPLANATION:
     * When you submit a `Callable` to an ExecutorService, the Executor instantly hands you back a `Future` object. 
     * A Future is basically a tracking receipt for a background job that hasn't finished yet. 
     * You can use it to check `isDone()`, attempt to `cancel()` the task, or call `.get()`. 
     * Calling `future.get()` will block the current thread until the background job finishes, and then it extracts 
     * the return value from the Callable.
     */
    public void futureInterface() {
        System.out.println("Future: An asynchronous tracking receipt used to extract results from background Callable tasks.");
    }

    /**
     * Q24: [Medium] What is a FutureTask?
     * 
     * DETAILED EXPLANATION:
     * The `FutureTask` class is a concrete utility class that implements BOTH the `Runnable` and `Future` interfaces. 
     * You can wrap a `Callable` inside a `FutureTask`. Because it implements Runnable, you can hand it directly 
     * to a raw `Thread` object to execute, and because it implements Future, you can still call `.get()` on it 
     * later to retrieve the result. It acts as the perfect bridge between raw threads and Callables.
     */
    public void futureTask() {
        System.out.println("FutureTask: A wrapper combining Runnable execution properties with Future result-extraction properties.");
    }

    /**
     * Q25: [Medium] Why use an ExecutorService instead of creating raw Threads?
     * 
     * DETAILED EXPLANATION:
     * Creating a brand new `Thread` object requires the OS to allocate heavy memory and CPU architecture. 
     * If a web server receives 10,000 requests and spawns 10,000 raw threads, the server will crash from OutOfMemory. 
     * `ExecutorService` implements Thread Pooling. It creates a fixed number of threads (e.g., 50) at startup. 
     * When the 10,000 tasks arrive, they are placed in a queue. The 50 threads process tasks, and when finished, 
     * the thread is NOT destroyed; it is recycled to grab the next task. This ensures the system runs at maximum 
     * speed without ever exhausting memory.
     */
    public void executorService() {
        System.out.println("ExecutorService: Manages a recycled Thread Pool, preventing OS architecture exhaustion.");
    }

    /**
     * Q26: [Medium] What is a ThreadPoolExecutor?
     * 
     * DETAILED EXPLANATION:
     * The `ThreadPoolExecutor` is the highly configurable core engine that powers the `ExecutorService` interfaces. 
     * It allows advanced developers to fine-tune threading behavior by manually setting the 'core pool size' 
     * (minimum threads kept alive), 'maximum pool size', the 'keep-alive time' for idle threads, and explicitly 
     * defining the type of Queue (ArrayBlockingQueue vs LinkedBlockingQueue) used to hold pending tasks.
     */
    public void threadPoolExecutor() {
        System.out.println("ThreadPoolExecutor: The granular configuration engine behind high-performance thread pools.");
    }

    /**
     * Q27: [Medium] When do you use a ScheduledExecutorService?
     * 
     * DETAILED EXPLANATION:
     * This is a specialized sub-interface of ExecutorService replacing the legacy `java.util.Timer` class. 
     * It is designed to execute tasks after a specific delay (e.g., "Run this logic 5 seconds from now") or 
     * to execute them repeatedly on a fixed interval (e.g., "Ping the database health check every 10 seconds").
     */
    public void scheduledExecutorService() {
        System.out.println("ScheduledExecutorService: Handles delayed execution and fixed-rate recurring background tasks.");
    }

    /**
     * Q28: [Advanced] Detail the ForkJoinPool architecture.
     * 
     * DETAILED EXPLANATION:
     * Introduced in Java 7, ForkJoinPool is designed for raw, massive mathematical processing. 
     * It uses a "Divide and Conquer" approach. If it receives a task to process a 1,000,000 element array, 
     * it recursively "Forks" (splits) the array into tiny 100-element chunks and distributes them across threads. 
     * It employs a "Work-Stealing" algorithm: If Thread A finishes its chunks early, it will sneak over to Thread B's 
     * queue and steal its pending tasks, ensuring absolutely zero CPU cores sit idle. Finally, it "Joins" all the 
     * results back together.
     */
    public void forkJoinPool() {
        System.out.println("ForkJoinPool: Recursive split-task architecture utilizing aggressive Work-Stealing algorithms.");
    }

    /**
     * Q29: [Advanced] What is a CountDownLatch and its use case?
     * 
     * DETAILED EXPLANATION:
     * A `CountDownLatch` is a highly robust synchronization aid initialized with a specific count (e.g., 3). 
     * The Main Thread calls `latch.await()` and is completely blocked. 
     * Three separate worker threads do their tasks, and as each finishes, they call `latch.countDown()`, reducing 
     * the count. The exact millisecond the count hits 0, the Main Thread is instantly unblocked. 
     * Use Case: An automation framework waiting for the App Server, Database, and Cache Server to all boot up 
     * concurrently before starting the first test case.
     */
    public void countDownLatch() {
        System.out.println("CountDownLatch: Orchestration tool that blocks execution until a precise number of external events completes.");
    }

    /**
     * Q30: [Advanced] How does ReentrantLock surpass the standard 'synchronized' keyword?
     * 
     * DETAILED EXPLANATION:
     * `ReentrantLock` (from `java.util.concurrent.locks`) is an advanced replacement for basic synchronized blocks. 
     * Advantages:
     * 1. Fairness: You can initialize it as a "Fair" lock, ensuring the thread waiting the longest gets access 
     *    next, completely preventing Starvation.
     * 2. tryLock(): A thread can attempt to grab the lock. If it's taken, instead of being BLOCKED forever, 
     *    it immediately returns `false` and can go do other work.
     * 3. Interruptible: A thread waiting for a ReentrantLock can be safely interrupted by another thread, breaking deadlocks.
     */
    public void reentrantLock() {
        System.out.println("ReentrantLock: Provides granular locking control, Fairness policies, and non-blocking tryLock() attempts.");
    }
}