package interviewQuestions;

import java.util.*;
import java.util.concurrent.*;

/**
 * ============================================================================
 * INTERVIEW QUESTIONS PART 6: Collections (Maps & Queues)
 * ============================================================================
 * This file contains 30 highly detailed Java interview questions.
 * Each question provides a deep-dive English explanation covering the 'What', 
 * 'Why', and 'How', along with practical Java code snippets.
 * ============================================================================
 */
public class Part6_CollectionsMapsQueues {

    public static void main(String[] args) {
        System.out.println("Running Part 6: Collections Maps and Queues...");
    }

    /**
     * Q1: [Easy] Define the core attributes of the Map Interface.
     * 
     * DETAILED EXPLANATION:
     * The `java.util.Map` interface is structurally unique because it does NOT inherit from the `Collection` 
     * interface. It is entirely separate. 
     * A Map stores data exclusively in Key-Value pairs. 
     * Core Rule: A Map absolutely cannot contain duplicate Keys. If you attempt to put a new value using a Key 
     * that already exists in the Map, the old value is permanently overwritten and replaced by the new value. 
     * Multiple different keys, however, CAN map to the exact same value.
     */
    public void mapInterface() {
        System.out.println("Map: A separate hierarchy designed strictly for Key-Value data association.");
    }

    /**
     * Q2: [Medium] How does a HashMap operate under the hood?
     * 
     * DETAILED EXPLANATION:
     * HashMap relies on Hashing algorithms. It uses an internal array of "Buckets" (Nodes). 
     * When you execute `put("Name", "John")`, the HashMap calls the `hashCode()` method on "Name", performs a 
     * bitwise operation to find a specific index (bucket), and places the entry there. 
     * When you call `get("Name")`, it repeats the math, instantly jumping to the exact bucket without needing to 
     * search the rest of the array. This grants it an exceptionally fast O(1) constant time complexity for reads 
     * and writes. It allows ONE null key and multiple null values.
     */
    public void hashMap() {
        System.out.println("HashMap: Extremely fast O(1) Key-Value lookups using hash algorithms.");
    }

    /**
     * Q3: [Medium] What problem does LinkedHashMap solve?
     * 
     * DETAILED EXPLANATION:
     * The major flaw of a standard HashMap is that it does not remember the order in which items were inserted; 
     * iterating over it yields a seemingly random order. 
     * LinkedHashMap extends HashMap but weaves a Doubly-Linked List through every single bucket entry. 
     * This linked list physically maintains the exact chronological "Insertion Order". When you iterate over a 
     * LinkedHashMap, you get the items back exactly in the order you put them in. This is highly useful for building 
     * predictable cache mechanisms or displaying sorted UI data.
     */
    public void linkedHashMap() {
        System.out.println("LinkedHashMap: A standard HashMap that preserves strict Insertion Order.");
    }

    /**
     * Q4: [Medium] Describe the architecture of a TreeMap.
     * 
     * DETAILED EXPLANATION:
     * TreeMap implements the `NavigableMap` interface and does not use hashing at all. Instead, it places every 
     * Key-Value pair into a highly structured Red-Black Tree. 
     * The moment you add an entry, the tree dynamically re-balances itself to ensure the Keys remain sorted in strict 
     * ascending mathematical or alphabetical order (or based on a provided Comparator). 
     * Because of the tree traversal, `put` and `get` operations are much slower than HashMap, operating at O(log N).
     */
    public void treeMap() {
        System.out.println("TreeMap: A Red-Black tree that constantly sorts Keys in ascending order. Slower (O(log N)).");
    }

    /**
     * Q5: [Medium] What is a Hashtable and why is it obsolete?
     * 
     * DETAILED EXPLANATION:
     * Hashtable is a legacy class from Java 1.0. It performs the exact same function as HashMap. 
     * The difference is that EVERY method in Hashtable is synchronized to prevent threading issues. If Thread A is 
     * reading from the table, Thread B is completely blocked from writing, reading, or modifying it, leading to a 
     * massive performance bottleneck in high-traffic applications. Furthermore, Hashtable strictly forbids `null` keys 
     * or `null` values, throwing NullPointerExceptions instantly. 
     * Modern developers use `ConcurrentHashMap` instead.
     */
    public void hashtable() {
        System.out.println("Hashtable: A heavily synchronized, slow, legacy Map that rejects nulls.");
    }

    /**
     * Q6: [Advanced] Why is ConcurrentHashMap the gold standard for Multithreading?
     * 
     * DETAILED EXPLANATION:
     * ConcurrentHashMap is an engineering masterpiece. Instead of locking the entire Map like Hashtable does, it uses 
     * a technique called "Lock Striping" (in Java 7) or "CAS Node-level locking" (in Java 8+). 
     * The internal array is divided into numerous segments or buckets. If Thread A is writing to Bucket 1, only Bucket 1 
     * is locked! Thread B can perfectly read or write to Bucket 5 simultaneously without any blocking or waiting. 
     * This provides incredible concurrency and throughput.
     */
    public void concurrentHashMap() {
        System.out.println("ConcurrentHashMap: Locks exclusively at the node/bucket level, allowing massive parallel operations.");
    }

    /**
     * Q7: [Advanced] What is a WeakHashMap and its impact on Memory Management?
     * 
     * DETAILED EXPLANATION:
     * A standard HashMap holds a "Strong Reference" to its Keys. Even if the rest of your application deletes the Key, 
     * the HashMap holds onto it, preventing the Garbage Collector from cleaning it up (causing a Memory Leak). 
     * A WeakHashMap holds "Weak References" to its Keys. If the application deletes all other references to a Key, 
     * the Garbage Collector will detect this, physically delete the Key, and the WeakHashMap will automatically and 
     * silently remove that entire Key-Value entry. Highly useful for volatile Caching.
     */
    public void weakHashMap() {
        System.out.println("WeakHashMap: Keys are automatically purged when external references are destroyed by the GC.");
    }

    /**
     * Q8: [Advanced] What distinguishes an IdentityHashMap?
     * 
     * DETAILED EXPLANATION:
     * A normal HashMap compares Keys using the `.equals()` method (logical equivalence). 
     * An IdentityHashMap blatantly ignores `.equals()`. It compares Keys using strict reference equality (`==`). 
     * This means it will only consider two Keys as identical if they point to the exact same physical memory address 
     * in the Heap. It is rarely used in standard applications, mostly reserved for deep-system topology traversal 
     * where distinguishing physical objects is required.
     */
    public void identityHashMap() {
        System.out.println("IdentityHashMap: Keys are compared purely by Heap memory address (==).");
    }

    /**
     * Q9: [Medium] What makes EnumMap so exceptionally fast?
     * 
     * DETAILED EXPLANATION:
     * An EnumMap is a highly specialized Map designed exclusively for use with Enum Keys. 
     * Because the Java compiler knows exactly how many Enum constants exist (e.g., 7 days of the week), the EnumMap 
     * doesn't bother using complex hashing algorithms or LinkedLists. It simply instantiates a primitive, fixed-size 
     * array. When you query an Enum key, it accesses the array index directly. It is blazing fast and has almost 
     * zero memory overhead.
     */
    public void enumMap() {
        System.out.println("EnumMap: Backed by a flat, highly optimized Array rather than complex hash buckets.");
    }

    /**
     * Q10: [Advanced] Explain HashMap Collisions and the Java 8 improvement.
     * 
     * DETAILED EXPLANATION:
     * A Collision happens when two completely different Keys generate the exact same HashCode, or when their HashCodes 
     * compress down to the same array Bucket index. 
     * Prior to Java 8, HashMap handled this by chaining the entries in a LinkedList inside that bucket. If 10,000 items 
     * collided, reading became an O(N) nightmare. 
     * Java 8+ Enhancement: Once a bucket's LinkedList reaches a threshold of 8 items, the HashMap instantly transforms 
     * that LinkedList into a Balanced Red-Black Tree. This restores lookup performance to a highly manageable O(log N).
     */
    public void hashMapCollisions() {
        System.out.println("Collisions are resolved by chaining. Long chains dynamically convert into Red-Black Trees (Java 8).");
    }

    /**
     * Q11: [Advanced] Detail the concept of the HashMap Load Factor.
     * 
     * DETAILED EXPLANATION:
     * The Load Factor is a mathematical threshold that balances memory efficiency against lookup speed. 
     * By default, a HashMap has a Load Factor of 0.75f. This means when the map becomes 75% full of data relative 
     * to its bucket capacity, it triggers an expensive 'Rehashing' operation. The map allocates a new array double 
     * the size of the old one, and recalculates the hash positions for every single existing element.
     */
    public void hashMapLoadFactor() {
        System.out.println("Load Factor (0.75): The fullness threshold that triggers the array to double in size.");
    }

    /**
     * Q12: [Advanced] Detail HashMap Capacity and bitwise optimization.
     * 
     * DETAILED EXPLANATION:
     * Capacity is the number of raw buckets (slots) in the hash table. The default starting capacity is 16. 
     * Crucially, Java forces the capacity to ALWAYS be a power of two (16, 32, 64, 128). 
     * Why? To figure out which bucket an item belongs in, Java uses a Bitwise AND operation `(n - 1) & hash` 
     * instead of the expensive modulo `%` operation. The bitwise math only works flawlessly if the capacity is a power of 2.
     */
    public void hashMapCapacity() {
        System.out.println("Capacity is forced to powers of 2 (16, 32, 64) to optimize bitwise bucket allocation.");
    }

    /**
     * Q13: [Medium] What is Map.Entry?
     * 
     * DETAILED EXPLANATION:
     * `Map.Entry` is a static nested interface defined inside the Map interface. It represents a single, cohesive 
     * Key-Value pair "node". When you call `map.entrySet()`, the Map packages every single node into a Set of 
     * `Map.Entry` objects. It is the core molecular building block of HashMaps.
     */
    public void mapEntry() {
        System.out.println("Map.Entry: The foundational object encapsulating a single Key and its Value.");
    }

    /**
     * Q14: [Easy] How do you efficiently Iterate Maps?
     * 
     * DETAILED EXPLANATION:
     * The worst way to iterate is looping through `map.keySet()`, and then calling `map.get(key)` inside the loop, 
     * as this forces the map to recalculate hashes thousands of times unnecessarily.
     * The optimal way is a for-each loop over `map.entrySet()`. This hands you the physical Map.Entry object, giving 
     * you instant, simultaneous access to both `.getKey()` and `.getValue()` with zero extra calculation overhead.
     */
    public void iteratingMaps() {
        System.out.println("Optimal Iteration: for (Map.Entry<K,V> entry : map.entrySet()) { ... }");
    }

    /**
     * Q15: [Easy] Define the Queue Interface.
     * 
     * DETAILED EXPLANATION:
     * The Queue interface extends Collection. It is designed to hold elements prior to processing them. 
     * By default, most Queues enforce a strict FIFO (First-In-First-Out) protocol, just like a line of people at a 
     * grocery store. Elements are appended to the tail (rear), and extracted from the head (front).
     */
    public void queueInterface() {
        System.out.println("Queue: A collection enforcing processing order, typically First-In-First-Out (FIFO).");
    }

    /**
     * Q16: [Medium] Detail the PriorityQueue.
     * 
     * DETAILED EXPLANATION:
     * A PriorityQueue blatantly violates the standard FIFO queue rules. Instead of placing new items at the back of 
     * the line, it places them based on their Priority. It relies on a Binary Heap structure. 
     * The "Head" of the queue is always guaranteed to be the "smallest" or "most important" element, as determined 
     * by natural ordering or a custom Comparator. 
     * Warning: Iterating through a PriorityQueue will NOT yield sorted data; only calling `poll()` repeatedly 
     * guarantees sorted extraction.
     */
    public void priorityQueue() {
        System.out.println("PriorityQueue: Extracts the mathematically 'lowest' or 'highest priority' element first.");
    }

    /**
     * Q17: [Medium] Define the Deque Interface.
     * 
     * DETAILED EXPLANATION:
     * Deque (pronounced "deck") stands for Double-Ended Queue. 
     * It is an immensely flexible interface that allows you to insert, retrieve, or remove elements from BOTH the 
     * head (front) and the tail (rear) of the queue. Because of this dual-access, a Deque can be utilized as both 
     * a standard FIFO Queue and a standard LIFO Stack.
     */
    public void dequeInterface() {
        System.out.println("Deque: Double-Ended Queue. Capable of acting as both a Stack and a Queue.");
    }

    /**
     * Q18: [Medium] What makes ArrayDeque superior?
     * 
     * DETAILED EXPLANATION:
     * ArrayDeque is the premier implementation of the Deque interface, backed by a resizable cyclic array. 
     * Because it operates on contiguous memory blocks without the massive object-creation overhead of Linked nodes, 
     * it heavily outperforms the legacy `Stack` class when used as a stack, and it heavily outperforms `LinkedList` 
     * when used as a standard Queue. It is the modern standard for linear buffering.
     */
    public void arrayDeque() {
        System.out.println("ArrayDeque: The most memory-efficient and performant implementation for Stacks and Queues.");
    }

    /**
     * Q19: [Advanced] What is a BlockingQueue and why is it critical?
     * 
     * DETAILED EXPLANATION:
     * Found in the `java.util.concurrent` package, BlockingQueue is the absolute backbone of the Producer-Consumer 
     * multithreading design pattern. 
     * It introduces thread-blocking behavior: If a "Consumer" thread tries to pull data from an empty queue, the 
     * queue forces the thread to wait (block) until a "Producer" inserts data. If a Producer tries to insert data 
     * into a full queue, it is blocked until a Consumer removes data. This seamlessly regulates speed disparities 
     * between high-speed threads.
     */
    public void blockingQueue() {
        System.out.println("BlockingQueue: Automatically blocks and wakes threads, managing Producer-Consumer data flow.");
    }

    /**
     * Q20: [Advanced] Detail the ArrayBlockingQueue.
     * 
     * DETAILED EXPLANATION:
     * A classic Bounded BlockingQueue backed by an array. "Bounded" means you MUST define its absolute maximum 
     * capacity in its constructor (e.g., `new ArrayBlockingQueue<>(100)`). Once created, its capacity can never 
     * be altered. It uses a single global lock for both putting and taking elements, which can cause slight thread 
     * contention compared to linked queues, but it prevents OutOfMemory errors by strictly limiting size.
     */
    public void arrayBlockingQueue() {
        System.out.println("ArrayBlockingQueue: A strict, fixed-size queue with a single lock.");
    }

    /**
     * Q21: [Advanced] Detail the LinkedBlockingQueue.
     * 
     * DETAILED EXPLANATION:
     * A blocking queue backed by linked nodes. It is "optionally-bounded". If you do not specify a capacity, it 
     * defaults to `Integer.MAX_VALUE` (virtually unbounded). 
     * Crucially, it utilizes TWO separate locks: one lock for putting elements, and a completely separate lock for 
     * taking elements. This means a Producer thread and a Consumer thread can operate on the queue completely 
     * concurrently, providing vastly superior throughput compared to ArrayBlockingQueue in highly active systems.
     */
    public void linkedBlockingQueue() {
        System.out.println("LinkedBlockingQueue: Dual-lock architecture for massive concurrent throughput.");
    }

    /**
     * Q22: [Advanced] Explain the PriorityBlockingQueue.
     * 
     * DETAILED EXPLANATION:
     * Combines the behavior of a PriorityQueue with thread-blocking capabilities. It is unbounded by default. 
     * It does not act as a FIFO queue; items inserted by producers are dynamically sorted according to priority rules, 
     * and consumers will always be handed the highest priority item currently residing in the queue.
     */
    public void priorityBlockingQueue() {
        System.out.println("PriorityBlockingQueue: A thread-safe queue where highest priority items are extracted first.");
    }

    /**
     * Q23: [Advanced] Explain the DelayQueue.
     * 
     * DETAILED EXPLANATION:
     * A highly specialized queue where elements must implement the `Delayed` interface. Each element contains an 
     * internal expiration timer. 
     * A consumer thread attempting to pull an element from the DelayQueue will be blocked until the timer on the 
     * head element reaches zero. It is perfect for scheduling tasks, managing timeouts, or delaying processing operations.
     */
    public void delayQueue() {
        System.out.println("DelayQueue: Elements are held captive until their specific delay timer expires.");
    }

    /**
     * Q24: [Advanced] Explain the SynchronousQueue.
     * 
     * DETAILED EXPLANATION:
     * The strangest queue in Java: It has an internal capacity of strictly ZERO. 
     * It does not hold data. It acts as a direct hand-off point. A Producer attempting to insert an item must block 
     * until a Consumer arrives to take the item directly from its hands. It is extremely fast for direct thread-to-thread 
     * handoffs (like passing tasks to the CachedThreadPool executor).
     */
    public void synchronousQueue() {
        System.out.println("SynchronousQueue: A zero-capacity queue functioning as a direct thread rendezvous point.");
    }

    /**
     * Q25: [Medium] Modern Maps: What is computeIfAbsent()?
     * 
     * DETAILED EXPLANATION:
     * Introduced in Java 8, it massively cleans up code. 
     * If you want to get an ArrayList from a Map, you previously had to check if it exists, and if not, instantiate a 
     * new ArrayList and put it in the map. 
     * `computeIfAbsent(key, lambda)` does this in one line. If the key exists, it returns the value. If not, it runs 
     * the lambda code to create the value, instantly puts it in the Map, and returns it. Perfect for building nested maps.
     */
    public void mapComputeIfAbsent() {
        System.out.println("computeIfAbsent: Initializes and stores data dynamically if the key is missing.");
    }

    /**
     * Q26: [Easy] Modern Maps: What is getOrDefault()?
     * 
     * DETAILED EXPLANATION:
     * Traditional `map.get("MissingKey")` returns `null`, which often causes NullPointerExceptions if used blindly. 
     * `getOrDefault(key, "Fallback")` attempts to find the key. If the key does not exist, it safely returns the 
     * "Fallback" string you provided instead of null, making application logic significantly safer.
     */
    public void mapGetOrDefault() {
        System.out.println("getOrDefault: Safely returns a fallback value instead of crashing with a NullPointerException.");
    }

    /**
     * Q27: [Medium] Modern Maps: What is the merge() method?
     * 
     * DETAILED EXPLANATION:
     * Used for consolidating data. If the specified key does not exist, it simply inserts the provided key-value pair. 
     * If the key DOES exist, it executes a BiFunction Lambda expression that receives the "Old Value" and the "New Value". 
     * You write the math (e.g., `old + new`) to combine them, and the Map updates the entry with the consolidated total. 
     * Heavily used for word frequency counting.
     */
    public void mapMerge() {
        System.out.println("merge: Synthesizes existing map data with incoming data using customized Lambda math.");
    }

    /**
     * Q28: [Easy] Modern Maps: What is putIfAbsent()?
     * 
     * DETAILED EXPLANATION:
     * Standard `put()` aggressively overwrites data. If you execute `put("Key", "New")`, the old data is destroyed. 
     * `putIfAbsent("Key", "New")` is a defensive mechanism. It checks the Map first. It will ONLY insert the "New" 
     * data if the Key is entirely missing or currently pointing to `null`. If valid data already exists, it politely 
     * ignores the request.
     */
    public void mapPutIfAbsent() {
        System.out.println("putIfAbsent: A defensive insertion that refuses to overwrite existing valid data.");
    }

    /**
     * Q29: [Easy] Modern Maps: What is replace()?
     * 
     * DETAILED EXPLANATION:
     * While `put()` will insert data regardless of whether the Key exists or not, `replace(key, value)` is highly 
     * specific. It will ONLY update the Map if the Key ALREADY EXISTS in the dictionary. If you try to replace a 
     * non-existent Key, it does absolutely nothing.
     */
    public void mapReplace() {
        System.out.println("replace: Strictly updates pre-existing Keys. Cannot insert brand new Keys.");
    }

    /**
     * Q30: [Easy] Modern Maps: What is the conditional remove() method?
     * 
     * DETAILED EXPLANATION:
     * Standard `remove(key)` blindly deletes the entry. Java 8 introduced an overloaded `remove(key, value)`. 
     * This method acts as a safeguard. It will only delete the Key from the Map if it is currently mapped to the 
     * EXACT value you specified. If the value has been altered by another part of the system, it aborts the deletion.
     */
    public void mapRemove() {
        System.out.println("remove(key, val): A targeted deletion requiring a perfect match of both Key and Value.");
    }
}