package interviewQuestions;

/**
 * ============================================================================
 * INTERVIEW QUESTIONS PART 1: Core Java Basics
 * ============================================================================
 * This file contains 30 highly detailed Java interview questions.
 * Each question provides a deep-dive English explanation covering the 'What', 
 * 'Why', and 'How', along with practical Java code snippets.
 * ============================================================================
 */
public class Part1_CoreJavaBasics {

    public static void main(String[] args) {
        System.out.println("Running Part 1: Core Java Basics...");
    }

    /**
     * Q1: [Medium] What is the exact difference between Primitives and Wrapper Classes in Java?
     * 
     * DETAILED EXPLANATION:
     * In Java, memory efficiency and performance are critical. Primitives (like int, boolean, char, double) 
     * are the most basic data types. They are not objects; they hold their values directly in the memory 
     * stack, making operations on them incredibly fast and memory-efficient. 
     * 
     * However, Java is an Object-Oriented language, and its powerful Collections Framework (like ArrayList, 
     * HashMap) can ONLY store Objects, not primitive data types. To bridge this gap, Java provides 
     * "Wrapper Classes" (like Integer, Boolean, Character, Double). A Wrapper Class encapsulates a 
     * primitive value within a fully-fledged Object residing in the Heap memory. 
     * 
     * While Wrappers allow primitives to be used in Collections and provide useful utility methods 
     * (like Integer.parseInt()), they consume significantly more memory and add overhead due to object 
     * creation and garbage collection.
     */
    public void primitivesVsWrappers() {
        int primitiveInt = 5; // Stored in Stack, very fast, minimal memory.
        Integer wrapperInt = Integer.valueOf(5); // Stored in Heap, holds a reference, heavier memory footprint.
        
        // Java automatically "unboxes" the wrapper to compare the raw values here:
        System.out.println(primitiveInt == wrapperInt); // Returns true
    }

    /**
     * Q2: [Easy] Explain the concept of Autoboxing in Java.
     * 
     * DETAILED EXPLANATION:
     * Prior to Java 5, if developers wanted to put a primitive 'int' into an ArrayList, they had to 
     * manually wrap it by writing code like: list.add(Integer.valueOf(5)). This was tedious and bloated the code.
     * 
     * Autoboxing is a feature introduced by the Java compiler to automatically and implicitly convert 
     * a primitive data type into its corresponding Wrapper Class object without requiring the developer 
     * to write explicit conversion code. When you assign an 'int' to an 'Integer' variable, the compiler 
     * behind the scenes automatically inserts 'Integer.valueOf()'. This makes writing code much cleaner 
     * and easier to read, especially when dealing with Generics and Collections.
     */
    public void autoboxing() {
        // The compiler automatically converts the primitive '10' into 'Integer.valueOf(10)'
        Integer automaticallyWrapped = 10; 
        System.out.println("Autoboxed: " + automaticallyWrapped);
    }

    /**
     * Q3: [Easy] Explain the concept of Unboxing in Java.
     * 
     * DETAILED EXPLANATION:
     * Unboxing is the exact mathematical reverse of Autoboxing. It is the automatic conversion performed 
     * by the Java compiler to extract the primitive value from a Wrapper Class object. 
     * 
     * For example, if you have an 'Integer' object and you try to perform standard arithmetic on it 
     * (like addition or subtraction), or if you assign it to a raw 'int' variable, Java will automatically 
     * invoke the '.intValue()' method behind the scenes to extract the raw primitive value. 
     * 
     * WARNING: If the Wrapper object is 'null', attempting to unbox it will throw a NullPointerException 
     * at runtime because there is no primitive equivalent of 'null'.
     */
    public void unboxing() {
        Integer wrappedValue = 15; // Autoboxed
        // The compiler automatically calls wrappedValue.intValue() to get the primitive '15'
        int primitiveValue = wrappedValue; 
        System.out.println("Unboxed: " + primitiveValue);
    }

    /**
     * Q4: [Medium] How do Default Values work for variables in Java?
     * 
     * DETAILED EXPLANATION:
     * Java ensures that class-level variables (both static fields and instance fields) are never left in 
     * an unpredictable state. If a developer declares a class-level variable but does not explicitly 
     * assign a value to it, the JVM automatically initializes it with a standard "default" value during 
     * the object creation or class loading phase.
     * 
     * - Numeric primitives (int, long, double, float) default to 0 (or 0.0).
     * - Boolean primitives default to false.
     * - Object references (String, Integer, custom classes, Arrays) default to null.
     * 
     * CRITICAL DISTINCTION: This rule ONLY applies to class-level variables. Local variables (variables 
     * declared inside a method) DO NOT get default values. If you try to use a local variable without 
     * initializing it first, the Java compiler will throw an error and refuse to compile the code.
     */
    int defaultInt; // Class-level variable, automatically initialized to 0.
    
    public void defaultValues() {
        int localInt; // Local variable, NO default value assigned.
        System.out.println("Class variable defaults to: " + defaultInt);
        // System.out.println("Local variable: " + localInt); // This line would cause a Compilation Error!
    }

    /**
     * Q5: [Medium] What is a Static Variable and when should it be used?
     * 
     * DETAILED EXPLANATION:
     * When you declare a variable with the 'static' keyword, you are telling the JVM that this variable 
     * belongs strictly to the Class itself, rather than to any individual Object (instance) created from that class.
     * 
     * Because it belongs to the class, there is only ONE single copy of this variable residing in the 
     * memory (specifically in the Metaspace/Method Area), regardless of whether you create one object, 
     * a million objects, or zero objects. 
     * 
     * Use Case: It is used for memory management to store data that is common and shared across all instances. 
     * For example, keeping track of the total number of 'Employee' objects created, or defining constants 
     * like 'static final double PI = 3.14'. If one object modifies the static variable, the new value 
     * is immediately seen by all other objects.
     */
    static int globalCounter = 0; // Shared across all instances
    
    public void staticVariables() {
        globalCounter++; // Modifying the single shared copy
    }

    /**
     * Q6: [Medium] What is a Static Method? What are its limitations?
     * 
     * DETAILED EXPLANATION:
     * Similar to static variables, a static method belongs to the Class rather than an Object. 
     * The primary benefit is that you can invoke a static method without needing to instantiate an object 
     * of the class (e.g., calling Math.max(5, 10) instead of doing 'new Math().max(5, 10)').
     * 
     * Limitations:
     * 1. A static method CANNOT access non-static (instance) variables or methods directly, because it 
     *    doesn't have a specific object context to draw data from.
     * 2. The 'this' and 'super' keywords cannot be used inside a static method, as there is no current 
     *    instance ('this') to refer to.
     * 3. Static methods cannot be overridden in the traditional sense; they can only be hidden (Method Hiding).
     */
    public static void staticMethods() {
        System.out.println("I am called via Part1_CoreJavaBasics.staticMethods() without making an object.");
    }

    /**
     * Q7: [Advanced] What is a Static Block and when is it executed?
     * 
     * DETAILED EXPLANATION:
     * A static block is a segment of code enclosed in curly braces {} and preceded by the 'static' keyword. 
     * Its primary purpose is to initialize complex static variables or execute startup logic that must 
     * happen before the class is ever used.
     * 
     * Execution Timing: The static block is executed exactly ONCE, at the exact moment the ClassLoader 
     * loads the class into the JVM memory. This happens before any objects are created and before any 
     * static methods (including the main method) are called. If a class has multiple static blocks, 
     * they execute sequentially from top to bottom as they appear in the source code.
     */
    static {
        System.out.println("Static Block: I execute first, exactly once, during Class Loading.");
    }

    /**
     * Q8: [Advanced] What is an Instance Initialization Block?
     * 
     * DETAILED EXPLANATION:
     * An instance initialization block is simply a block of code enclosed in curly braces {} placed directly 
     * inside the class body, without any name, return type, or 'static' keyword.
     * 
     * Execution Timing: Unlike static blocks, an instance block executes EVERY TIME a new object is created. 
     * It runs immediately after the parent constructor (super) finishes, but BEFORE the current class's 
     * constructor executes its logic.
     * 
     * Use Case: It is used to share common initialization code across multiple different overloaded constructors. 
     * Instead of duplicating code in every constructor, you place it in the instance block.
     */
    {
        System.out.println("Instance Block: I execute every time 'new' is called, right before the constructor.");
    }

    /**
     * Q9: [Easy] Define a Constructor and its core rules.
     * 
     * DETAILED EXPLANATION:
     * A constructor is a special, unique block of code designed specifically to initialize the state 
     * (variables) of a newly created object. When you use the 'new' keyword, memory is allocated, and 
     * then the constructor is invoked to set up the object.
     * 
     * Core Rules:
     * 1. The name of the constructor MUST exactly match the name of the Class.
     * 2. A constructor MUST NOT have a return type (not even 'void'). If you put 'void', Java treats it 
     *    as a regular method, not a constructor.
     * 3. If you do not write any constructor, the Java compiler automatically inserts an invisible, 
     *    empty "Default Constructor" for you. If you write your own constructor, the compiler does not 
     *    provide the default one.
     */
    public Part1_CoreJavaBasics() {
        System.out.println("Constructor: I initialize the object's state.");
    }

    /**
     * Q10: [Medium] Explain Constructor Chaining in Java.
     * 
     * DETAILED EXPLANATION:
     * Constructor chaining is the design technique of calling one constructor from another constructor 
     * within the same class, or from a subclass to a superclass. 
     * 
     * Within the same class, this is achieved using the 'this()' keyword. It is highly beneficial for 
     * code maintainability because it prevents duplicate initialization logic. You can have a "master" 
     * constructor that takes all parameters and does the heavy lifting, while other overloaded constructors 
     * simply pass default values to the master constructor using 'this()'.
     * 
     * Rule: The 'this()' call MUST be the very first executable statement inside the constructor.
     */
    public Part1_CoreJavaBasics(int predefinedValue) {
        this(); // Calls the no-argument constructor above as the very first step.
        System.out.println("Constructor Chaining completed. Value: " + predefinedValue);
    }

    /**
     * Q11: [Easy] What is the 'this' keyword used for?
     * 
     * DETAILED EXPLANATION:
     * The 'this' keyword is a special reference variable in Java that points directly to the "current object" 
     * whose method or constructor is currently being executed. 
     * 
     * Primary Use Cases:
     * 1. Shadowing resolution: If a method parameter has the exact same name as an instance variable, 
     *    the parameter "shadows" (hides) the instance variable. Using 'this.variableName' explicitly tells 
     *    Java you want to assign the value to the object's instance variable, not the method parameter.
     * 2. Constructor chaining using 'this()'.
     * 3. Passing the current object as a parameter to other methods or returning the current object from a method.
     */
    int currentSpeed;
    public void setSpeed(int currentSpeed) {
        // 'this.currentSpeed' refers to the class variable. 'currentSpeed' refers to the parameter.
        this.currentSpeed = currentSpeed; 
    }

    /**
     * Q12: [Medium] What is the 'super' keyword used for?
     * 
     * DETAILED EXPLANATION:
     * The 'super' keyword is a reference variable used specifically to refer to the immediate Parent class 
     * (Superclass) of the current object. 
     * 
     * Primary Use Cases:
     * 1. Method Overriding: If a child class overrides a method from the parent class, but the child still 
     *    needs to execute the parent's version of that method, it uses 'super.methodName()'.
     * 2. Accessing hidden variables: If a child class has a variable with the same name as a parent class variable, 
     *    'super.variableName' accesses the parent's variable.
     * 3. Constructor chaining: 'super()' is used to explicitly call a specific constructor of the parent class.
     */
    public void superKeyword() {
        // Calls the toString() method from the parent 'Object' class.
        System.out.println("Superclass representation: " + super.toString());
    }

    /**
     * Q13: [Easy] What happens when a variable is declared as 'final'?
     * 
     * DETAILED EXPLANATION:
     * The 'final' keyword acts as a restriction mechanism. When applied to a variable, it transforms that 
     * variable into a constant. Once a final variable has been assigned a value (initialized), that value 
     * can NEVER be modified, reassigned, or altered for the entire lifecycle of the program.
     * 
     * If the final variable is an object reference (like an ArrayList), you cannot make it point to a new 
     * ArrayList. However, you CAN still modify the internal state of the object (e.g., adding items to the 
     * list), because the reference itself remains constant, even if the object's internal data changes.
     */
    public void finalVariables() {
        final int MAX_RETRIES = 3;
        // MAX_RETRIES = 5; // The compiler will instantly reject this reassignment.
        System.out.println("Final variables are constants: " + MAX_RETRIES);
    }

    /**
     * Q14: [Medium] What happens when a method is declared as 'final'?
     * 
     * DETAILED EXPLANATION:
     * When the 'final' keyword is applied to a method, it completely prevents Method Overriding. 
     * Any child class that extends the parent class will inherit the final method, but it is strictly 
     * forbidden from altering or overriding its implementation.
     * 
     * This is heavily used in framework design to lock down critical business logic or security-sensitive 
     * algorithms so that malicious or poorly-written subclasses cannot alter the intended behavior.
     */
    public final void finalMethods() {
        System.out.println("My logic is locked. Subclasses cannot change me.");
    }

    /**
     * Q15: [Medium] What happens when a Class is declared as 'final'?
     * 
     * DETAILED EXPLANATION:
     * When a class is marked as 'final', it cannot be extended (inherited) by any other class. It represents 
     * the absolute end of the inheritance hierarchy. 
     * 
     * Why do this? Security and immutability. The most famous example is the 'java.lang.String' class. 
     * Because String is final, nobody can create a subclass of String to maliciously override how strings 
     * behave, ensuring that Strings are absolutely secure and predictable everywhere in the JVM.
     */
    final class ImmutableCoreComponent {
        // No other class will ever be allowed to write 'extends ImmutableCoreComponent'
    }

    /**
     * Q16: [Medium] Is Java strictly Pass by Value or Pass by Reference? Explain deeply.
     * 
     * DETAILED EXPLANATION:
     * This is a massive interview trap! Java is strictly, 100% "Pass by Value". It NEVER passes by reference.
     * 
     * - When passing Primitives: A direct copy of the raw value (e.g., the number 5) is handed to the method. 
     *   Modifying the parameter inside the method has zero effect on the original variable.
     * 
     * - When passing Objects: This is where people get confused. Java does NOT pass the actual object. 
     *   Instead, it passes a COPY of the Memory Reference (the pointer to the heap). Because the method 
     *   has a copy of the pointer, it can reach into the heap and modify the original object's state 
     *   (e.g., setting a user's name). HOWEVER, if the method tries to use the '=' operator to assign a 
     *   brand new object to the pointer, the original reference outside the method remains completely unaffected.
     */
    public void passByValue(int numberValue, StringBuilder objectRef) {
        numberValue = 999; // Original int outside the method does NOT change.
        objectRef.append(" altered!"); // Original object DOES change because we mutated the shared heap object.
        objectRef = new StringBuilder("New"); // Original reference outside does NOT point to this new object.
    }

    /**
     * Q17: [Medium] What exactly are Object References in memory?
     * 
     * DETAILED EXPLANATION:
     * In Java, variables like 'String s' or 'Employee e' never actually contain the complex object data 
     * directly. Objects are large and dynamically sized, so they live in a spacious memory area called the Heap.
     * 
     * The variable 's' or 'e' is merely an "Object Reference". It lives on the Stack and contains a small, 
     * fixed-size memory address (a pointer) that tells the JVM exactly where to find the real object data 
     * in the Heap. If multiple references point to the same address, they are interacting with the exact same object.
     */
    public void objectReferences() {
        Object memoryObj1 = new Object(); // Allocates heap memory, obj1 holds the address.
        Object memoryObj2 = memoryObj1; // obj2 now holds the EXACT SAME memory address as obj1.
    }

    /**
     * Q18: [Easy] Explain the exact difference between == and .equals()
     * 
     * DETAILED EXPLANATION:
     * The '==' operator is a purely mechanical comparison. It compares what is physically stored inside the 
     * variables. For primitives, it compares the raw numbers. For objects, it compares the memory addresses. 
     * Therefore, '==' only returns true for objects if both variables point to the EXACT same location in the Heap.
     * 
     * The '.equals()' method is a logical comparison. It is a method defined in the Object class that is meant 
     * to be overridden by developers. It inspects the actual internal data/state of two distinct objects to see 
     * if they mean the same thing logically (e.g., do these two different String objects contain the exact 
     * same sequence of characters?).
     */
    public void equalsVsDoubleEquals() {
        String strA = new String("Automation");
        String strB = new String("Automation");
        
        System.out.println(strA == strB); // FALSE: They are two distinct objects in the heap.
        System.out.println(strA.equals(strB)); // TRUE: Their character arrays are identical.
    }

    /**
     * Q19: [Advanced] Explain the hashCode() and equals() Contract. Why is it mandatory?
     * 
     * DETAILED EXPLANATION:
     * In Java, if you override the equals() method to define custom logical equality for a class, you MUST 
     * absolutely override the hashCode() method as well. This is known as the Hash Contract.
     * 
     * The Contract states: If two objects are equal according to equals(), they MUST return the exact same 
     * integer value from hashCode(). 
     * 
     * Why? Hash-based collections like HashMap and HashSet use the hashCode to determine which "bucket" an 
     * object belongs in. If two logically equal objects produce different hashCodes, the HashMap will place 
     * them in different buckets and will completely fail to find or recognize them as duplicates, breaking 
     * the collection entirely.
     */
    public void hashCodeContract() {
        String s1 = "Contract";
        String s2 = new String("Contract");
        // Because they are .equals(), their hashcodes are guaranteed to match identically.
        System.out.println("Hash match: " + (s1.hashCode() == s2.hashCode())); 
    }

    /**
     * Q20: [Medium] What is Object clone() and the Cloneable Interface?
     * 
     * DETAILED EXPLANATION:
     * The clone() method is defined in the Object class and is used to create an exact field-by-field copy 
     * of an object (a Shallow Copy). 
     * 
     * However, the JVM refuses to clone an object unless the class explicitly implements the 'Cloneable' 
     * interface. Cloneable is a Marker Interface (it has no methods). It acts as a permission slip, telling 
     * the JVM, "It is safe and legal to clone instances of this class." If a class calls clone() without 
     * implementing Cloneable, a CloneNotSupportedException is thrown.
     */
    public void objectClone() {
        System.out.println("Implement Cloneable, override clone() and call super.clone() to duplicate objects.");
    }

    /**
     * Q21: [Medium] Break down how System.out.println() actually works internally.
     * 
     * DETAILED EXPLANATION:
     * It is not just a single command; it is a chain of object relationships.
     * - 'System' is a final utility class located in the java.lang package.
     * - 'out' is a public static final variable inside the System class. Its data type is PrintStream. 
     *   Because it's static, we can access it using System.out.
     * - 'println()' is a method defined inside the PrintStream class. It takes the argument, prints it 
     *   to the standard console output stream, and appends a newline character at the end.
     */
    public void systemOutPrintlnInternals() {
        System.out.println("System (Class) -> out (Static Variable) -> println (Method in PrintStream)");
    }

    /**
     * Q22: [Medium] Analyze the exact signature of public static void main(String[] args).
     * 
     * DETAILED EXPLANATION:
     * - public: The JVM needs full visibility to call the method from completely outside the application.
     * - static: The JVM needs to invoke this method before any objects of the class are instantiated.
     * - void: The program does not return any data back to the JVM upon successful completion.
     * - main: The specific, hardcoded keyword the JVM searches for as the absolute starting point.
     * - String[] args: An array of strings used to receive arguments from the terminal command line.
     */
    public void mainMethodSignature() {
        System.out.println("It is the strictly enforced entry point of a Java application.");
    }

    /**
     * Q23: [Easy] What are Command Line Arguments and how are they used?
     * 
     * DETAILED EXPLANATION:
     * Command Line Arguments are string values passed directly to the Java application at the exact moment 
     * of execution via the terminal or command prompt (e.g., `java MyApp config.xml testEnv`).
     * 
     * The JVM takes these words, packages them into a String array, and passes them as the 'args' 
     * parameter into the main method. They are heavily used to pass dynamic configurations, file paths, 
     * or environment toggles without hardcoding them into the source code.
     */
    public void commandLineArgs(String[] args) {
        if(args != null && args.length > 0) {
            System.out.println("Application booted with argument: " + args[0]);
        }
    }

    /**
     * Q24: [Medium] What are Varargs (Variable Arguments) and what are the rules?
     * 
     * DETAILED EXPLANATION:
     * Introduced in Java 5, Varargs allow a method to accept zero, one, or multiple arguments of the same 
     * data type without requiring the developer to explicitly create an array. It is defined using three 
     * dots (...) after the data type.
     * 
     * Behind the scenes, the Java compiler automatically bundles the arguments into an array.
     * Strict Rules:
     * 1. A method can only have ONE varargs parameter.
     * 2. The varargs parameter MUST be the absolute last parameter in the method's parameter list.
     */
    public void varargs(String prefix, int... numbers) {
        int sum = 0;
        for (int num : numbers) { sum += num; } // The JVM treats 'numbers' identically to int[]
        System.out.println(prefix + " Total is: " + sum);
    }

    /**
     * Q25: [Medium] What is Type Casting conceptually?
     * 
     * DETAILED EXPLANATION:
     * Type casting is the process of taking a value or object of one specific data type and converting it 
     * into a completely different data type. This is necessary because Java is a strongly-typed language, 
     * meaning operations generally expect matching data types. Casting is categorized into primitive casting 
     * (e.g., double to int) and reference casting (e.g., Object to String).
     */
    public void typeCasting() {
        System.out.println("Transforming data to satisfy compiler type-checking rules.");
    }

    /**
     * Q26: [Easy] What is Implicit Casting (Widening)?
     * 
     * DETAILED EXPLANATION:
     * Implicit casting happens automatically by the Java compiler without the programmer needing to write 
     * any special syntax. This ONLY occurs when you are converting a smaller, less precise data type into 
     * a larger, more precise data type (e.g., moving a 32-bit 'int' into a 64-bit 'long').
     * 
     * Because the destination container is larger, there is absolutely zero risk of losing data or precision, 
     * so the compiler performs the upgrade automatically.
     */
    public void implicitCasting() {
        int smallBox = 500;
        long massiveBox = smallBox; // Implicit widening. Safely copied.
        System.out.println("Safely widened to: " + massiveBox);
    }

    /**
     * Q27: [Medium] What is Explicit Casting (Narrowing) and what are the risks?
     * 
     * DETAILED EXPLANATION:
     * Explicit casting is required when you attempt to force a larger, more precise data type into a smaller 
     * container (e.g., cramming a 64-bit 'double' into a 32-bit 'int'). 
     * 
     * Because the smaller container cannot hold all the data, there is a severe risk of Data Loss or 
     * Precision Loss (truncation). The compiler refuses to do this automatically. You must explicitly tell 
     * the compiler "I understand the risks" by using parenthesis syntax like `(int)`. In the case of a double 
     * to int, all decimal values are permanently chopped off and discarded.
     */
    public void explicitCasting() {
        double highlyPreciseValue = 100.9999;
        // The developer forces the cast. The decimals (.9999) are instantly destroyed.
        int choppedValue = (int) highlyPreciseValue; 
        System.out.println("Narrowed value with data loss: " + choppedValue); // Prints 100
    }

    /**
     * Q28: [Easy] What is the utility of the java.lang.Math class?
     * 
     * DETAILED EXPLANATION:
     * The Math class is a final utility class provided natively by Java. It contains a collection of static 
     * methods and constants (like Math.PI) designed to handle advanced mathematical operations that go beyond 
     * basic arithmetic operators (+, -, *, /). 
     * 
     * Because all its methods are static, you never instantiate a Math object; you simply call methods like 
     * Math.abs(), Math.pow(), Math.sqrt(), or Math.max() directly.
     */
    public void mathClass() {
        double power = Math.pow(2, 3); // 2 to the power of 3 = 8.0
        System.out.println("Math class provides highly optimized algorithms: " + power);
    }

    /**
     * Q29: [Easy] Explain the ways to generate Random Numbers in Java.
     * 
     * DETAILED EXPLANATION:
     * 1. Math.random(): This is a quick static method that returns a pseudo-random, highly precise double 
     *    value strictly between 0.0 (inclusive) and 1.0 (exclusive). Developers usually multiply this by a 
     *    max range and cast it to an int.
     * 2. java.util.Random class: For more complex scenarios, you create an instance of this class. It provides 
     *    methods like nextInt(maxBound), nextBoolean(), and nextDouble(), giving you much finer control over 
     *    random data generation.
     */
    public void randomNumbers() {
        int randomPercentage = (int) (Math.random() * 100); // Generates 0 to 99
        System.out.println("Generated pseudo-random number: " + randomPercentage);
    }

    /**
     * Q30: [Medium] How does Scanner Input work in Java?
     * 
     * DETAILED EXPLANATION:
     * The Scanner class (found in java.util) is the primary tool used to parse raw text and primitive types 
     * from external streams. It breaks the input into tokens using a delimiter pattern, which by default is 
     * whitespace.
     * 
     * By wrapping `System.in` (the standard keyboard input stream) with a Scanner, developers can easily pause 
     * the program's execution and wait for the user to type data. It provides safe parsing methods like 
     * nextInt(), nextDouble(), and nextLine() to convert the raw typed text into usable Java data types.
     */
    public void scannerInput() {
        System.out.println("Scanner handles tokenizing and type-conversion from input streams.");
        // Scanner sc = new Scanner(System.in);
        // int userAge = sc.nextInt();
    }
}