package interviewQuestions;

import java.util.*;
import java.util.concurrent.*;

/**
 * ============================================================================
 * INTERVIEW QUESTIONS PART 5: Collections (Lists & Sets)
 * ============================================================================
 * This file contains 30 highly detailed Java interview questions.
 * Each question provides a deep-dive English explanation covering the 'What', 
 * 'Why', and 'How', along with practical Java code snippets.
 * ============================================================================
 */
public class Part5_CollectionsListsSets {

    public static void main(String[] args) {
        System.out.println("Running Part 5: Collections (Lists & Sets)...");
    }

    /**
     * Q1: [Easy] Detail the architecture of the Java Collections Hierarchy.
     * 
     * DETAILED EXPLANATION:
     * The Collections framework is a massive tree of interfaces and classes. 
     * - `Iterable` is the absolute root interface. It forces the implementation of the `iterator()` method.
     * - `Collection` extends `Iterable`. It defines bulk operations like add(), remove(), and size().
     * - `List`, `Set`, and `Queue` are the three primary sub-interfaces that extend `Collection`, each 
     *   introducing different rules (e.g., Lists allow duplicates, Sets do not).
     * 
     * CRITICAL NOTE: The `Map` interface (HashMap, TreeMap) is technically part of the Collections Framework, 
     * but it does NOT extend the `Collection` interface because Maps deal with Key-Value pairs, not single elements.
     */
    public void collectionHierarchy() {
        System.out.println("Iterable -> Collection -> (List, Set, Queue)");
    }

    /**
     * Q2: [Easy] What defines the List Interface?
     * 
     * DETAILED EXPLANATION:
     * A List is an ordered, sequential collection of elements. 
     * It strictly maintains the "insertion order", meaning the first item you add stays at index 0, the second 
     * at index 1, etc. Because elements have an explicit index, Lists explicitly allow duplicate values and 
     * allow the insertion of `null` elements.
     */
    public void listInterface() {
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Apple"); // Perfect valid, resides at index 1
    }

    /**
     * Q3: [Medium] Deep dive into ArrayList internals and time complexity.
     * 
     * DETAILED EXPLANATION:
     * ArrayList is backed by a dynamic, resizable primitive array (`Object[]`). 
     * - Reading (`get(index)`): Because arrays use contiguous memory, finding an element by index is instantaneous. 
     *   Time complexity is strictly O(1). This makes ArrayList the absolute best choice for reading data.
     * - Modifying (`add(index, obj)` / `remove(index)`): Extremely slow. If you insert an item at index 0 of an 
     *   ArrayList with 10,000 items, Java must physically shift all 10,000 items to the right by one slot. 
     *   Time complexity is O(N).
     * Note: ArrayList is completely non-synchronized (not thread-safe).
     */
    public void arrayList() {
        System.out.println("ArrayList: Blazing fast for Reads. Extremely slow for Middle Insertions/Deletions.");
    }

    /**
     * Q4: [Medium] Deep dive into LinkedList internals and time complexity.
     * 
     * DETAILED EXPLANATION:
     * LinkedList is a Doubly-Linked List implementation. It does NOT use a contiguous array. Instead, every element 
     * is wrapped in a 'Node' object. Each Node contains pointers to the Previous Node and the Next Node.
     * - Reading (`get(index)`): Extremely slow. To find the 500th element, Java must start at Node 1 and traverse 
     *   sequentially through 500 pointers. Time complexity is O(N).
     * - Modifying: Exceptionally fast. If you know the location of a Node, removing it simply involves changing 
     *   two pointer addresses on the adjacent nodes. No massive shifting is required. Time complexity is O(1).
     */
    public void linkedList() {
        System.out.println("LinkedList: Terrible for Reads. Blazing fast for Insertions/Deletions if Node is known.");
    }

    /**
     * Q5: [Easy] What is a Vector and why is it considered legacy?
     * 
     * DETAILED EXPLANATION:
     * Vector is basically the older, original version of ArrayList. It is also backed by a dynamic array. 
     * The difference is that EVERY single method inside the Vector class is marked with the `synchronized` keyword, 
     * making it 100% thread-safe. 
     * However, because every operation forces threads to acquire and release locks, Vector is notoriously slow. 
     * Modern Java developers avoid it entirely. If thread safety is needed, they use `CopyOnWriteArrayList` or 
     * `Collections.synchronizedList()`.
     */
    public void vector() {
        System.out.println("Vector: A slow, legacy, heavily synchronized alternative to ArrayList.");
    }

    /**
     * Q6: [Medium] What is the Stack Class?
     * 
     * DETAILED EXPLANATION:
     * The Stack class directly extends Vector and implements a strict LIFO (Last-In-First-Out) data structure. 
     * (Think of a stack of plates: the last plate placed on top is the first one you pull off). 
     * It introduces methods like `push()` (add to top), `pop()` (remove and return top), and `peek()` (look at 
     * top without removing). Because it extends Vector, it is synchronized and slow. The modern Java recommendation 
     * is to use `ArrayDeque` when a stack is needed.
     */
    public void stackClass() {
        System.out.println("Stack: A LIFO structure. ArrayDeque is the modern, faster alternative.");
    }

    /**
     * Q7: [Easy] What defines the Set Interface?
     * 
     * DETAILED EXPLANATION:
     * A Set is a collection that models the mathematical set abstraction. 
     * Its absolute defining rule is that it CANNOT contain duplicate elements. If you attempt to add an element 
     * that already exists, the `add()` method silently rejects it and returns `false`. Most implementations 
     * (like HashSet) do not guarantee any specific order.
     */
    public void setInterface() {
        Set<Integer> uniqueNumbers = new HashSet<>();
        boolean success1 = uniqueNumbers.add(5); // Returns true
        boolean success2 = uniqueNumbers.add(5); // Returns false, duplicate rejected
    }

    /**
     * Q8: [Medium] What is a HashSet and what are its performance metrics?
     * 
     * DETAILED EXPLANATION:
     * HashSet is the most popular Set implementation. Under the hood, it actually creates a `HashMap`. 
     * When you add an item to a HashSet, it stores your item as the 'Key' in the HashMap, and uses a dummy, 
     * static Object as the 'Value'. 
     * Because it relies on hashing algorithms, it provides exceptionally fast O(1) constant time performance 
     * for basic operations (add, remove, contains). It provides absolutely zero guarantees regarding the 
     * order of the elements.
     */
    public void hashSet() {
        System.out.println("HashSet: Unordered, incredibly fast O(1) lookups via hashing.");
    }

    /**
     * Q9: [Medium] How does LinkedHashSet differ from HashSet?
     * 
     * DETAILED EXPLANATION:
     * LinkedHashSet extends HashSet, but it adds a Doubly-Linked List that runs through all of its entries. 
     * This linked list records the exact chronological sequence in which elements were added. 
     * Therefore, when you iterate over a LinkedHashSet, the items are returned in the exact "Insertion Order". 
     * It protects against duplicates like a HashSet, but keeps order like a List. It is slightly slower and 
     * consumes slightly more memory than a standard HashSet.
     */
    public void linkedHashSet() {
        System.out.println("LinkedHashSet: A Set that remembers the exact Insertion Order.");
    }

    /**
     * Q10: [Medium] How does TreeSet operate internally?
     * 
     * DETAILED EXPLANATION:
     * TreeSet implements the NavigableSet interface and is backed by a TreeMap, which itself is built on a 
     * complex data structure called a Red-Black Tree (a self-balancing binary search tree). 
     * As you insert elements into a TreeSet, it automatically continuously sorts them into ascending order 
     * (either by their natural numerical/alphabetical order, or by a custom Comparator). 
     * Because the tree must constantly re-balance itself, adding and fetching items operates at an O(log N) 
     * time complexity, making it noticeably slower than HashSet.
     */
    public void treeSet() {
        System.out.println("TreeSet: Automatically sorts elements. Operates at O(log N) speed.");
    }

    /**
     * Q11: [Easy] What is an Iterator and why is it useful?
     * 
     * DETAILED EXPLANATION:
     * The Iterator interface provides a standardized way to loop through any Collection (Lists, Sets). 
     * It is vastly superior to a standard `for` loop because of one massive feature: Safe Deletion. 
     * If you try to remove an item from a list using a standard `for` loop or `for-each` loop while iterating 
     * over it, Java will throw a ConcurrentModificationException. The Iterator's built-in `remove()` method 
     * is the ONLY safe way to delete items from a collection during a live iteration.
     */
    public void iterator() {
        System.out.println("Iterator: Safely traverse and remove elements from Collections.");
    }

    /**
     * Q12: [Medium] How does ListIterator enhance the base Iterator?
     * 
     * DETAILED EXPLANATION:
     * The standard Iterator only goes in one direction (forward). 
     * The ListIterator (which is ONLY available for Lists, not Sets) is a much more powerful bi-directional tool. 
     * It introduces methods like `hasPrevious()` and `previous()` to traverse backwards. It also allows you to 
     * inject (`add()`) or replace (`set()`) elements dynamically into the list while you are looping through it.
     */
    public void listIterator() {
        System.out.println("ListIterator: Allows forward/backward traversal and inline modification of Lists.");
    }

    /**
     * Q13: [Advanced] Deeply explain the Fail-Fast mechanism.
     * 
     * DETAILED EXPLANATION:
     * Most standard collections in `java.util` (ArrayList, HashMap) utilize Fail-Fast iterators. 
     * When an iterator is spawned, it takes a snapshot of the collection's "modification count" (modCount). 
     * As you loop, the iterator constantly checks if the real collection's modCount still matches the snapshot. 
     * If Thread A is iterating, and Thread B suddenly adds an item to the ArrayList, the modCount changes. 
     * The iterator in Thread A instantly notices the mismatch and violently throws a `ConcurrentModificationException`. 
     * It "fails fast" rather than risking unpredictable behavior over corrupted data.
     */
    public void failFastIterator() {
        System.out.println("Fail-Fast: Instantly crashes if the collection structure is externally modified.");
    }

    /**
     * Q14: [Advanced] Deeply explain the Fail-Safe mechanism.
     * 
     * DETAILED EXPLANATION:
     * Collections found in `java.util.concurrent` (like CopyOnWriteArrayList or ConcurrentHashMap) utilize Fail-Safe 
     * iterators. When a Fail-Safe iterator is spawned, it operates on a separate CLONE (or specific concurrent view) 
     * of the original collection. 
     * Because it is looping over a clone, if another thread modifies the original collection, the iterator is 
     * completely unaffected and will NOT throw a ConcurrentModificationException. The downside is that the iterator 
     * might not see the most up-to-date data.
     */
    public void failSafeIterator() {
        System.out.println("Fail-Safe: Iterates over a clone/view. Never throws ConcurrentModificationException.");
    }

    /**
     * Q15: [Easy] How does Collections.sort() function?
     * 
     * DETAILED EXPLANATION:
     * Collections.sort(List) is a utility method that alters the List by arranging its elements into ascending 
     * order. For this to work without errors, the elements inside the List MUST implement the `Comparable` 
     * interface (like Strings and Integers natively do) so Java knows the rules on how to compare them.
     */
    public void collectionsSort() {
        System.out.println("Collections.sort: Modifies the list into ascending natural order.");
    }

    /**
     * Q16: [Easy] What is Collections.reverse()?
     * 
     * DETAILED EXPLANATION:
     * A straightforward utility method that literally flips the structural order of the elements within a List. 
     * The item at the last index is swapped with the item at index 0, and so on. It operates in-place and 
     * runs in O(N) linear time.
     */
    public void collectionsReverse() {
        System.out.println("Collections.reverse: Mutates the list by completely reversing its current order.");
    }

    /**
     * Q17: [Easy] What is Collections.shuffle()?
     * 
     * DETAILED EXPLANATION:
     * Randomly scrambles the arrangement of elements within a List. It uses a pseudo-random number generator. 
     * This is highly useful in Test Automation when you want to randomize the order in which specific test 
     * data payloads are processed.
     */
    public void collectionsShuffle() {
        System.out.println("Collections.shuffle: Randomly permutes the list.");
    }

    /**
     * Q18: [Medium] What is the purpose of Collections.unmodifiableList()?
     * 
     * DETAILED EXPLANATION:
     * This method accepts an existing List and returns a completely "Read-Only" wrapper view of that list. 
     * If any piece of code attempts to call `.add()`, `.set()`, or `.remove()` on this wrapper, it will throw 
     * an `UnsupportedOperationException`. This is a critical security and architecture tool used to hand out 
     * internal lists to other classes without giving them the power to corrupt the data.
     */
    public void collectionsUnmodifiableList() {
        System.out.println("UnmodifiableList: Creates a strict, immutable, read-only wrapper around a List.");
    }

    /**
     * Q19: [Medium] How does Collections.synchronizedList() secure collections?
     * 
     * DETAILED EXPLANATION:
     * Standard ArrayLists are highly dangerous in multithreaded environments. This method takes a normal list 
     * and returns a Thread-Safe wrapper. It does this by wrapping every single method call (add, get, remove) 
     * in a `synchronized(mutex)` block. 
     * WARNING: While `.add()` is safe, if you use a `for-each` loop or `Iterator` on a synchronizedList, you 
     * MUST manually wrap the entire iteration block in a `synchronized` block, or it will still fail-fast.
     */
    public void collectionsSynchronizedList() {
        System.out.println("SynchronizedList: Wraps a list in thread-safe locks, but iterations must be manually locked.");
    }

    /**
     * Q20: [Medium] Explain the Capacity Expansion logic of ArrayList.
     * 
     * DETAILED EXPLANATION:
     * By default, a new ArrayList creates an internal array of size 10. Once you add the 11th item, the array 
     * is completely full. Because Java arrays cannot stretch, the ArrayList allocates a brand new array that 
     * is exactly 50% larger than the old one (so, capacity jumps from 10 to 15). It then uses System.arraycopy() 
     * to port all the old data into the new, larger array, and abandons the old one.
     * Tip: If you know you are adding 10,000 items, initialize it via `new ArrayList<>(10000)` to prevent the 
     * heavy CPU cost of constantly resizing and copying arrays.
     */
    public void arrayListCapacity() {
        System.out.println("ArrayList expansion triggers a massive array-copying operation. Default growth is 1.5x.");
    }

    /**
     * Q21: [Medium] Diagram the structure of a LinkedList Node.
     * 
     * DETAILED EXPLANATION:
     * Java's LinkedList is Doubly-Linked. Every element added is instantiated as a static nested `Node` object. 
     * A Node contains three specific memory variables:
     * 1. `item`: The actual Object data (e.g., the String "Hello").
     * 2. `next`: A memory pointer referencing the subsequent Node in the chain.
     * 3. `prev`: A memory pointer referencing the preceding Node in the chain.
     * Because of these pointers, traversing backward and forward is possible, but the pointers consume significant 
     * extra memory compared to a flat ArrayList.
     */
    public void linkedListNode() {
        System.out.println("Node encapsulates: [Pointer to Prev] <- [Data] -> [Pointer to Next]");
    }

    /**
     * Q22: [Advanced] Prove how HashSet is backed by HashMap.
     * 
     * DETAILED EXPLANATION:
     * If you look at the JDK source code for HashSet, its constructor literally executes `map = new HashMap<>()`. 
     * When you call `hashSet.add("Apple")`, it executes `map.put("Apple", PRESENT)`. 
     * "PRESENT" is just a static, dummy Object taking up virtually no space. The HashSet utilizes the highly 
     * optimized keyset collision algorithms of the HashMap to guarantee its own uniqueness.
     */
    public void hashSetInternals() {
        System.out.println("HashSet is simply a HashMap where all values point to the same dummy object.");
    }

    /**
     * Q23: [Advanced] Why is TreeSet slower, and what are its requirements?
     * 
     * DETAILED EXPLANATION:
     * TreeSet relies on a TreeMap, organized as a Red-Black Tree. To organize nodes hierarchically into 
     * "left branches" (smaller values) and "right branches" (larger values), the TreeSet MUST know how to 
     * compare elements. 
     * Therefore, any object you attempt to add to a TreeSet MUST either implement the `Comparable` interface, 
     * or you must pass a custom `Comparator` into the TreeSet constructor. If you add custom Objects without 
     * defining comparison rules, the TreeSet will crash with a ClassCastException.
     */
    public void treeSetSorting() {
        System.out.println("TreeSet forces ascending order. Elements MUST implement Comparable or provide a Comparator.");
    }

    /**
     * Q24: [Medium] What is the Comparable Interface used for?
     * 
     * DETAILED EXPLANATION:
     * The `java.lang.Comparable` interface is used to define the "Natural Default Ordering" of a custom class. 
     * If you create an `Employee` class, Java has no idea how to sort an ArrayList of Employees (By ID? By Salary?). 
     * By having Employee implement Comparable, you are forced to override the `compareTo(Employee other)` method. 
     * Inside this method, you define the core logic (e.g., return `this.id - other.id;`). 
     * Limitation: A class can only have ONE natural ordering.
     */
    public void comparableInterface() {
        System.out.println("Comparable defines the singular, default sorting logic directly inside the domain class.");
    }

    /**
     * Q25: [Medium] What is the Comparator Interface used for?
     * 
     * DETAILED EXPLANATION:
     * The `java.util.Comparator` interface is an external tool used to define completely customized sorting rules. 
     * Unlike Comparable, you do NOT modify your core Employee class. Instead, you create a completely separate 
     * class or Lambda expression (e.g., `Comparator<Employee> bySalary = (e1, e2) -> e1.salary - e2.salary;`).
     * You can create dozens of different Comparators (sort by Name, sort by Age, sort by HireDate) and pass them 
     * dynamically into `Collections.sort(list, myComparator)`.
     */
    public void comparatorInterface() {
        System.out.println("Comparator provides external, highly flexible, multiple custom sorting strategies.");
    }

    /**
     * Q26: [Medium] How do you implement Custom Sorting efficiently?
     * 
     * DETAILED EXPLANATION:
     * Modern Java utilizes Lambda expressions to make custom sorting incredibly clean. 
     * If you have a `List<User> users`, you can sort them descending by age in a single line:
     * `users.sort((u1, u2) -> Integer.compare(u2.getAge(), u1.getAge()));`
     * You pass the Lambda (which represents a Comparator) directly into the `List.sort()` method.
     */
    public void customSorting() {
        System.out.println("Use List.sort() combined with Lambda expressions for rapid custom sorts.");
    }

    /**
     * Q27: [Easy] How do you perform a Set Intersection (finding common elements)?
     * 
     * DETAILED EXPLANATION:
     * In Mathematics, an intersection finds elements that exist in BOTH Set A and Set B. 
     * In Java, you invoke the `setA.retainAll(setB)` method. This method iterates through Set A, and physically 
     * DELETES any element that is not also present inside Set B. Set A is heavily modified and left holding 
     * only the common elements.
     */
    public void setIntersection() {
        System.out.println("Intersection: retainAll() strips the collection down to only the mutual elements.");
    }

    /**
     * Q28: [Easy] How do you perform a Set Union (combining elements)?
     * 
     * DETAILED EXPLANATION:
     * A mathematical union merges all elements of Set A and Set B into a massive master list, while inherently 
     * ignoring duplicates. 
     * In Java, you use the `setA.addAll(setB)` method. Because it is a Set, any items in Set B that already 
     * exist in Set A will be smoothly ignored, leaving Set A as a perfect, duplicate-free union of both groups.
     */
    public void setUnion() {
        System.out.println("Union: addAll() combines two collections, and the Set naturally rejects dupes.");
    }

    /**
     * Q29: [Easy] What is the most efficient way to convert a List to a Set (removing duplicates)?
     * 
     * DETAILED EXPLANATION:
     * The easiest and most efficient way to scrub a dirty List of all its duplicate entries is to pass the List 
     * directly into the constructor of a HashSet: `Set<String> cleanSet = new HashSet<>(dirtyList);`. 
     * As the constructor ingests the list, the HashSet's underlying hashing algorithms instantly detect and 
     * discard any duplicate entries.
     */
    public void listToSet() {
        System.out.println("Passing a Collection into a HashSet constructor instantly scrubs all duplicates.");
    }

    /**
     * Q30: [Easy] Why and how would you convert a Set back into a List?
     * 
     * DETAILED EXPLANATION:
     * Sets are fantastic for uniqueness, but they are terrible for retrieval because they lack index-based 
     * accessing (you cannot say `set.get(5)`). 
     * Once a List has been scrubbed clean by a Set, developers routinely cast it back to a List by passing the 
     * Set into an ArrayList constructor: `List<String> cleanList = new ArrayList<>(cleanSet);`. 
     * Now, you have a duplicate-free array where you can utilize `cleanList.get(index)`.
     */
    public void setToList() {
        System.out.println("Passing a Set into an ArrayList constructor restores powerful Index-based access capabilities.");
    }
}