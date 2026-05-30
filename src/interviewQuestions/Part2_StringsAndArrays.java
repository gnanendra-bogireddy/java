package interviewQuestions;

import java.util.Arrays;

/**
 * ============================================================================
 * INTERVIEW QUESTIONS PART 2: Strings And Arrays
 * ============================================================================
 * This file contains 30 highly detailed Java interview questions.
 * Each question provides a deep-dive English explanation covering the 'What', 
 * 'Why', and 'How', along with practical Java code snippets.
 * ============================================================================
 */
public class Part2_StringsAndArrays {

    public static void main(String[] args) {
        System.out.println("Running Part 2: Strings and Arrays...");
    }

    /**
     * Q1: [Medium] Why are Strings completely Immutable in Java? What are the benefits?
     * 
     * DETAILED EXPLANATION:
     * Immutability means that once a String object is created in memory, its character data can NEVER 
     * be modified, altered, or overwritten. If you try to concatenate or change it, Java abandons the 
     * old object and creates a brand new String object in memory.
     * 
     * Benefits:
     * 1. String Pool Utility: Because they can't change, Java can safely cache them in a pool and have 
     *    multiple references point to the same memory address without fear of one reference altering the data.
     * 2. Security: Strings are used for database URLs, usernames, passwords, and file paths. If they were 
     *    mutable, a malicious thread could change the file path after security checks have passed.
     * 3. Thread-Safety: Immutable objects are inherently thread-safe. Thousands of threads can read the 
     *    same String simultaneously without needing complex synchronization locks.
     */
    public void stringImmutability() {
        String original = "Java";
        original.toUpperCase(); // Creates "JAVA" in memory, but discards it immediately because it's unassigned.
        System.out.println("Original string remains completely unchanged: " + original);
    }

    /**
     * Q2: [Medium] What is the String Constant Pool and how does it optimize memory?
     * 
     * DETAILED EXPLANATION:
     * The String Pool is a specially managed area within the Java Heap memory. Because strings are the most 
     * commonly used objects in enterprise programming, creating a new object every time would exhaust memory 
     * rapidly.
     * 
     * When you create a String using a literal (e.g., String s = "Apple"), the JVM checks the String Pool. 
     * If "Apple" already exists in the pool, the JVM does NOT create a new object. Instead, it simply returns 
     * the memory reference to the existing "Apple". This means 100 variables holding the literal "Apple" will 
     * only consume the memory of 1 actual object.
     */
    public void stringPool() {
        String s1 = "Optimization";
        String s2 = "Optimization"; // Bypasses new object creation, points directly to s1's memory.
        System.out.println("Both point to the same String Pool reference: " + (s1 == s2)); // true
    }

    /**
     * Q3: [Medium] Explain the difference between String Literal and new String().
     * 
     * DETAILED EXPLANATION:
     * - Literal: `String a = "Test";` This instructs the JVM to use the String Pool. It checks for existence 
     *   and reuses memory, leading to high efficiency.
     * 
     * - `new` keyword: `String b = new String("Test");` This bypasses the String Pool optimization entirely. 
     *   The 'new' keyword absolutely FORCES the JVM to allocate fresh memory in the standard Heap area and 
     *   create a completely distinct object, even if "Test" already exists in the pool. It is highly inefficient 
     *   and should be avoided unless strictly necessary.
     */
    public void stringVsNewString() {
        String literal = "Code";
        String newObj = new String("Code");
        
        System.out.println("Different memory locations: " + (literal == newObj)); // false
        System.out.println("But identical content: " + literal.equals(newObj)); // true
    }

    /**
     * Q4: [Easy] What is StringBuilder and when should you use it?
     * 
     * DETAILED EXPLANATION:
     * Because standard Strings are immutable, concatenating strings inside a 'for' loop using the '+' operator 
     * creates thousands of abandoned string objects, causing massive memory bloat and forcing the Garbage 
     * Collector to work overtime.
     * 
     * StringBuilder solves this. It is a highly optimized, MUTABLE sequence of characters. It modifies its 
     * internal character array directly without creating new objects. If you are building a string dynamically, 
     * parsing files, or looping, ALWAYS use StringBuilder. It is not thread-safe, making it extremely fast.
     */
    public void stringBuilder() {
        StringBuilder builder = new StringBuilder("Start");
        builder.append(" - Middle - ").append("End"); // Modifies the object directly
        System.out.println(builder.toString());
    }

    /**
     * Q5: [Easy] What is StringBuffer and how does it differ from StringBuilder?
     * 
     * DETAILED EXPLANATION:
     * StringBuffer is the older sibling of StringBuilder. It does the exact same job: providing a mutable, 
     * modifiable string sequence. 
     * 
     * The critical difference is Thread Safety. Every single method inside StringBuffer is marked with the 
     * 'synchronized' keyword. This means if multiple threads try to append text simultaneously, they must wait 
     * in line. This guarantees data integrity but makes StringBuffer significantly slower. Since string building 
     * usually happens locally within a single thread, StringBuilder is preferred 99% of the time.
     */
    public void stringBuffer() {
        StringBuffer buffer = new StringBuffer("Safe");
        buffer.append(" across multiple threads.");
        System.out.println(buffer.toString());
    }

    /**
     * Q6: [Easy] How does the String concat() method function internally?
     * 
     * DETAILED EXPLANATION:
     * The `concat(String str)` method glues the provided string to the end of the current string. 
     * Internally, because Strings are immutable, it allocates a new char array large enough to hold both strings, 
     * copies the characters over, and returns a completely brand new String object. It is slightly more efficient 
     * than the '+' operator for a single concatenation, but still bad for loops.
     */
    public void stringConcat() {
        String base = "Automation ";
        String result = base.concat("Testing"); // 'base' is untouched.
        System.out.println(result);
    }

    /**
     * Q7: [Easy] Explain the logic of String substring().
     * 
     * DETAILED EXPLANATION:
     * `substring` extracts a targeted chunk of characters from a string. It is overloaded:
     * - `substring(int beginIndex)`: Starts at the given index and grabs everything to the absolute end of the string.
     * - `substring(int beginIndex, int endIndex)`: Starts at the beginIndex (inclusive) and stops BEFORE the 
     *   endIndex (exclusive). The mathematical length of the extracted string is always `endIndex - beginIndex`.
     */
    public void stringSubstring() {
        String data = "HelloWorld";
        System.out.println("Extracted chunk: " + data.substring(5, 10)); // Extracts "World"
    }

    /**
     * Q8: [Medium] Deep dive into the String split() method.
     * 
     * DETAILED EXPLANATION:
     * The `split(String regex)` method fractures a string into multiple pieces and returns an array of Strings. 
     * It uses a Regular Expression (Regex) to determine where the cut points are. This is heavily used in SDET 
     * roles to parse CSV files, analyze log lines, or extract parameters from URLs.
     * Note: Because it uses Regex, special characters like a period (".") must be escaped as "\\." to work properly.
     */
    public void stringSplit() {
        String csvLine = "Name,Age,Location";
        String[] columns = csvLine.split(",");
        System.out.println("Parsed item count: " + columns.length); // 3
    }

    /**
     * Q9: [Easy] What does String replace() do and how does it handle immutability?
     * 
     * DETAILED EXPLANATION:
     * `replace(CharSequence target, CharSequence replacement)` searches the entire string from start to finish 
     * and replaces EVERY exact match of the target with the replacement. It does not use Regex. Because strings 
     * are immutable, it constructs and returns a completely new String containing the swapped values, leaving 
     * the original string untouched.
     */
    public void stringReplace() {
        String original = "Java is hard. Java is strict.";
        String better = original.replace("Java", "Python");
        System.out.println("Modified: " + better);
    }

    /**
     * Q10: [Medium] What is String.format() and why use it?
     * 
     * DETAILED EXPLANATION:
     * String.format() allows developers to inject dynamic variables into a text template cleanly, without using 
     * messy '+' concatenations. It relies on placeholders: %s for Strings, %d for whole integers, %f for floating 
     * point numbers. It creates highly readable code, especially when generating dynamic SQL queries, error messages, 
     * or complex logging strings.
     */
    public void stringFormat() {
        String template = "User %s logged in after %d attempts.";
        String logMessage = String.format(template, "Admin", 3);
        System.out.println(logMessage);
    }

    /**
     * Q11: [Easy] Explain String charAt(). What are its limits?
     * 
     * DETAILED EXPLANATION:
     * Strings are essentially arrays of characters under the hood. `charAt(int index)` fetches the exact 
     * character located at the zero-based index provided. 
     * If you provide an index that is less than 0 or greater than/equal to the length of the string, it will 
     * immediately throw a StringIndexOutOfBoundsException, crashing the program.
     */
    public void stringCharAt() {
        char initial = "SDET".charAt(0);
        System.out.println("First character: " + initial); // 'S'
    }

    /**
     * Q12: [Easy] How does String indexOf() locate data?
     * 
     * DETAILED EXPLANATION:
     * `indexOf(String str)` scans the string from left to right and returns the exact integer index where the 
     * specified substring first begins. If the substring does not exist anywhere within the main string, it 
     * safely returns -1 instead of throwing an error. This makes it perfect for validation checks.
     */
    public void stringIndexOf() {
        String sentence = "Automation Testing";
        int position = sentence.indexOf("Test");
        System.out.println("Found 'Test' starting at index: " + position); // 11
    }

    /**
     * Q13: [Easy] What is Array Declaration conceptually?
     * 
     * DETAILED EXPLANATION:
     * An Array in Java is a core object used to store a fixed-size sequential collection of elements of the 
     * exact same data type. Declaration simply informs the compiler about the name of the array and what type 
     * of data it is allowed to hold (e.g., `int[]` means only integers). At the declaration stage, no memory 
     * has been allocated for the elements yet.
     */
    public void arrayDeclaration() {
        String[] serverNames; // The array is declared, but it is currently null.
    }

    /**
     * Q14: [Easy] Explain Array Initialization approaches.
     * 
     * DETAILED EXPLANATION:
     * Initialization is the process of physically allocating memory on the Heap for the array. 
     * Approach 1: `new int[5]`. This creates 5 slots in memory, filling them all with the default value (0).
     * Approach 2: `{1, 2, 3}`. This creates an array exactly sized to fit the provided elements and injects 
     * the values immediately. Once initialized, the size of the array is permanently locked.
     */
    public void arrayInitialization() {
        int[] exactSizeArray = {10, 20, 30}; // Instantly allocated 3 slots.
        System.out.println("Allocated array initialized.");
    }

    /**
     * Q15: [Easy] What is Array Length and how is it accessed?
     * 
     * DETAILED EXPLANATION:
     * Every array object created in Java contains a special, hidden, `public final` instance variable named `length`. 
     * This variable holds the maximum capacity of the array that was defined during initialization. 
     * Important: `length` is a variable, not a method, so it is called without parenthesis (unlike String.length()). 
     * Also, it tells you the total capacity, NOT how many slots are actually holding valid data.
     */
    public void arrayLength() {
        double[] metrics = new double[50];
        System.out.println("Maximum capacity of this array is: " + metrics.length); // 50
    }

    /**
     * Q16: [Medium] Describe Multidimensional Arrays.
     * 
     * DETAILED EXPLANATION:
     * Java does not have true multi-dimensional grid arrays like C++. Instead, Java uses "Arrays of Arrays". 
     * When you declare a 2D array like `int[][] matrix = new int[3][3]`, you are creating a primary array of size 3, 
     * where each slot in the primary array contains a pointer to another completely separate array of size 3. 
     * This allows developers to simulate grids, tables, and matrices (rows and columns) in memory.
     */
    public void multidimensionalArrays() {
        int[][] grid = new int[2][2]; // 2 rows, 2 columns.
        grid[0][0] = 99; // Top-left cell.
    }

    /**
     * Q17: [Advanced] What is a Jagged Array?
     * 
     * DETAILED EXPLANATION:
     * Because Java 2D arrays are just "Arrays of Arrays", there is no rule stating that the secondary arrays 
     * must all be the same length. A Jagged Array is a multi-dimensional array where each row can have a 
     * completely different length. This is highly memory-efficient if you need to store hierarchical data 
     * that resembles a triangle or staircase rather than a perfect square matrix.
     */
    public void jaggedArrays() {
        int[][] jagged = new int[3][]; // 3 rows, but columns undefined!
        jagged[0] = new int[1]; // Row 1 has 1 column
        jagged[1] = new int[5]; // Row 2 has 5 columns
        jagged[2] = new int[2]; // Row 3 has 2 columns
    }

    /**
     * Q18: [Medium] How does Arrays.sort() achieve high performance?
     * 
     * DETAILED EXPLANATION:
     * The java.util.Arrays utility class provides a highly optimized `sort()` method. It doesn't use simple, 
     * slow algorithms like Bubble Sort or Selection Sort. 
     * Under the hood, if sorting primitive arrays (like int[]), it uses a Dual-Pivot Quicksort, which is wildly 
     * fast for numerical data. If it is sorting Object arrays (like String[]), it uses TimSort (a hybrid of Merge Sort 
     * and Insertion Sort) because TimSort guarantees the sort will be "stable" (maintaining the relative order 
     * of equal elements).
     */
    public void arraysSort() {
        int[] unordered = {9, 2, 7, 4};
        Arrays.sort(unordered); // Mutates array to: 2, 4, 7, 9
    }

    /**
     * Q19: [Medium] What is the prerequisite for Arrays.binarySearch() and how does it work?
     * 
     * DETAILED EXPLANATION:
     * Binary Search is an exceptionally fast O(log N) algorithm to find a specific element. It works by checking 
     * the middle element, deciding if the target is lower or higher, and completely discarding half of the array, 
     * repeating the process until found. 
     * CRITICAL PREREQUISITE: The array MUST be completely sorted in ascending order before calling binarySearch(). 
     * If the array is unsorted, the results are completely unpredictable and incorrect.
     */
    public void arraysBinarySearch() {
        int[] sortedData = {10, 20, 30, 40, 50};
        int foundIndex = Arrays.binarySearch(sortedData, 40);
        System.out.println("Element 40 found at index: " + foundIndex); // 3
    }

    /**
     * Q20: [Medium] Why use Arrays.copyOf() instead of cloning?
     * 
     * DETAILED EXPLANATION:
     * `Arrays.copyOf(originalArray, newLength)` is a modern utility used to safely duplicate an array. 
     * It is vastly superior to manual looping or basic cloning because it allows resizing. If `newLength` is 
     * larger than the original, it pads the extra space with default values (0 or null). If it is smaller, 
     * it gracefully truncates the array. It delegates the heavy lifting to the native, ultra-fast 
     * System.arraycopy() method under the hood.
     */
    public void arraysCopyOf() {
        int[] original = {1, 2, 3};
        int[] expanded = Arrays.copyOf(original, 5); // Results in [1, 2, 3, 0, 0]
    }

    /**
     * Q21: [Medium] How does Arrays.equals() differ from the '==' operator for arrays?
     * 
     * DETAILED EXPLANATION:
     * If you have `array1` and `array2`, using `array1 == array2` ONLY checks if they are the exact same object 
     * pointing to the same memory heap location. It completely ignores what is inside the arrays.
     * 
     * `Arrays.equals(a, b)` performs a Deep Logical Comparison. It first checks if lengths match. Then, it iterates 
     * through every single index and compares the values. It only returns true if both arrays contain the exact 
     * same elements in the exact same sequential order.
     */
    public void arraysEquals() {
        int[] boxA = {5, 10};
        int[] boxB = {5, 10};
        System.out.println("Memory match: " + (boxA == boxB)); // False
        System.out.println("Data match: " + Arrays.equals(boxA, boxB)); // True
    }

    /**
     * Q22: [Easy] What is Arrays.fill() useful for?
     * 
     * DETAILED EXPLANATION:
     * `Arrays.fill(array, value)` rapidly populates every single slot of a designated array with the specified 
     * value. This is highly useful in automation frameworks when you need to completely reset a data buffer, 
     * wipe sensitive data from memory, or initialize a matrix to a specific starting state (like filling a grid with -1).
     */
    public void arraysFill() {
        int[] statusFlags = new int[4];
        Arrays.fill(statusFlags, -1); // Fills all 4 slots with -1.
    }

    /**
     * Q23: [Medium] Explain the limitations of Arrays.asList().
     * 
     * DETAILED EXPLANATION:
     * `Arrays.asList(array)` acts as a bridge between standard Arrays and the Collections framework. It returns 
     * a List view of the array. 
     * 
     * CRITICAL LIMITATION: It does NOT create a brand new ArrayList. It creates a fixed-size wrapper around the 
     * original array. Because arrays cannot grow or shrink, if you try to call `.add()` or `.remove()` on this 
     * generated List, it will violently crash with an UnsupportedOperationException. You can modify existing elements, 
     * but you cannot alter the size.
     */
    public void arraysAsList() {
        // List<String> list = Arrays.asList("Red", "Blue");
        // list.add("Green"); // CRASH! UnsupportedOperationException
        System.out.println("Produces a fixed-size List view.");
    }

    /**
     * Q24: [Advanced] Why is System.arraycopy() so fast?
     * 
     * DETAILED EXPLANATION:
     * `System.arraycopy(src, srcPos, dest, destPos, length)` is the underlying engine for almost all array 
     * manipulations in Java (including ArrayList expansion). 
     * 
     * It is insanely fast because it is a `native` method. It bypasses the Java Virtual Machine's standard execution 
     * rules and communicates directly with the underlying operating system (like C/C++ memory blocks) to perform 
     * bulk, continuous memory transfers. It easily outperforms manual 'for' loops by a massive margin.
     */
    public void systemArraycopy() {
        System.out.println("Native method utilizing raw OS memory block transfers.");
    }

    /**
     * Q25: [Easy] When is Iterating Arrays via a standard 'for' loop necessary?
     * 
     * DETAILED EXPLANATION:
     * A classic 'for' loop (e.g., `for(int i=0; i<length; i++)`) provides absolute control. 
     * You must use it over the enhanced for-loop when:
     * 1. You need to know the specific index position of an element while processing it.
     * 2. You need to physically replace or modify the element residing at that index in the array.
     * 3. You want to iterate backward or skip elements (e.g., `i += 2`).
     */
    public void iteratingArrays() {
        System.out.println("Use when Index knowledge or modification is required.");
    }

    /**
     * Q26: [Easy] What are the benefits of the Enhanced for-loop (for-each)?
     * 
     * DETAILED EXPLANATION:
     * Introduced in Java 5, the enhanced for-loop (`for(String item : array)`) removes the boilerplate clutter 
     * of managing index counters and length checks, completely eliminating the risk of 'off-by-one' indexing errors. 
     * It is designed strictly for sequential, read-only iteration from the first element to the last.
     */
    public void enhancedForLoop() {
        System.out.println("Clean, readable, sequential, read-only traversal.");
    }

    /**
     * Q27: [Easy] What explicitly triggers an ArrayIndexOutOfBoundsException?
     * 
     * DETAILED EXPLANATION:
     * Java implements strict boundary checks on arrays for security and memory safety. If your code attempts 
     * to access a slot using a negative index (e.g., `array[-1]`) or an index that is equal to or greater than 
     * the maximum capacity (e.g., accessing `array[5]` on an array of length 5, since indexes max out at length-1), 
     * the JVM instantly throws this exception to prevent the program from reading corrupted or restricted memory.
     */
    public void arrayOutOfBounds() {
        System.out.println("Triggered by attempting to breach the strict memory boundaries of the array.");
    }

    /**
     * Q28: [Easy] How do Null arrays cause exceptions?
     * 
     * DETAILED EXPLANATION:
     * If an array reference variable is declared but never initialized (or assigned to `null`), no memory 
     * has been allocated on the Heap. The pointer leads to nowhere. If a developer attempts to call `.length` 
     * or access `array[0]` on a null reference, the JVM throws a NullPointerException because there is no 
     * object state to interact with.
     */
    public void nullArrays() {
        System.out.println("Interacting with uninitialized array references throws NPE.");
    }

    /**
     * Q29: [Medium] Why convert a String to a Char Array using toCharArray()?
     * 
     * DETAILED EXPLANATION:
     * The `String.toCharArray()` method allocates a new char array and copies all the characters of the string 
     * into it. Because Strings are completely immutable, you cannot alter individual characters within them. 
     * If an algorithmic problem requires you to swap characters (like reversing a string or sorting anagrams), 
     * converting it to a mutable character array first is the standard, high-performance approach.
     */
    public void stringToCharArray() {
        char[] letters = "Mutable".toCharArray();
        letters[0] = 'm'; // Now we can modify the data!
    }

    /**
     * Q30: [Medium] How do you effectively turn a Char Array back into a String?
     * 
     * DETAILED EXPLANATION:
     * Using the `.toString()` method on an array will NOT yield the text. It will print the JVM memory hash 
     * (like `[C@7b23ec81`). 
     * To properly reconstruct the text, you must pass the char array into the String constructor `new String(charArray)` 
     * or use the static utility `String.valueOf(charArray)`. This instructs Java to sequence the characters back 
     * into a unified, immutable String object.
     */
    public void charArrayToString() {
        char[] letters = {'J', 'a', 'v', 'a'};
        String text = new String(letters);
        System.out.println("Reconstructed String: " + text);
    }
}