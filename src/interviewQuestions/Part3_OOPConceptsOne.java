package interviewQuestions;

/**
 * ============================================================================
 * INTERVIEW QUESTIONS PART 3: OOP Concepts One
 * ============================================================================
 * This file contains 30 highly detailed Java interview questions.
 * Each question provides a deep-dive English explanation covering the 'What', 
 * 'Why', and 'How', along with practical Java code snippets.
 * ============================================================================
 */
public class Part3_OOPConceptsOne {

    public static void main(String[] args) {
        System.out.println("Running Part 3: OOP Concepts One...");
    }

    /**
     * Q1: [Easy] Define exactly what a Class and an Object are in Java.
     * 
     * DETAILED EXPLANATION:
     * A Class is a logical template, blueprint, or prototype that defines the state (variables) and 
     * behavior (methods) that an entity of its type will support. Crucially, a Class consumes NO physical 
     * memory in the Heap when it is simply defined in the code.
     * 
     * An Object (also called an Instance) is a physical, living realization of that Class blueprint. 
     * When you use the 'new' keyword, Java allocates physical Heap memory for this object. You can create 
     * thousands of unique objects from a single class blueprint, each holding its own independent data.
     */
    public void classAndObject() {
        Part3_OOPConceptsOne myPhysicalObject = new Part3_OOPConceptsOne();
        System.out.println("Object instantiated from Class blueprint.");
    }

    /**
     * Q2: [Easy] What is Encapsulation and what problem does it solve?
     * 
     * DETAILED EXPLANATION:
     * Encapsulation is one of the four fundamental OOP pillars. It is the mechanism of wrapping the data 
     * (variables) and the code acting on the data (methods) together as a single, unified capsule (the Class).
     * 
     * Problem Solved: It prevents external classes from directly accessing and modifying an object's internal 
     * state in unpredictable or malicious ways. By marking variables as 'private', you build a protective 
     * wall around the data. The only way the outside world can interact with that data is by using authorized 
     * 'public' methods (Getters/Setters), which allows the class to enforce validation rules.
     */
    private int secretData = 42;

    /**
     * Q3: [Easy] Why do we use Getters and Setters?
     * 
     * DETAILED EXPLANATION:
     * If a variable is 'private' for Encapsulation, external classes cannot see it. Getters and Setters 
     * (also known as Accessors and Mutators) are public methods that act as the controlled "doors" to that private data.
     * 
     * - The Getter simply returns the value. You can add logic here to format the data before handing it over.
     * - The Setter accepts a value to update the variable. This is critical because it allows you to inject 
     *   strict validation logic (e.g., preventing a bank account balance from being set to a negative number) 
     *   before the internal variable is actually modified.
     */
    public int getSecretData() { return secretData; }
    
    public void setSecretData(int value) {
        if (value > 0) this.secretData = value; // Validation gatekeeper
    }

    /**
     * Q4: [Easy] Detail the 'public' Access Modifier.
     * 
     * DETAILED EXPLANATION:
     * The 'public' access modifier provides the widest possible scope in Java. 
     * When a class, method, or variable is declared as public, it can be accessed from absolutely anywhere 
     * in the entire application—regardless of whether the calling code is in the same class, the same package, 
     * or a completely different package entirely.
     */
    public String publicAccess = "Visible to the entire universe.";

    /**
     * Q5: [Easy] Detail the 'private' Access Modifier.
     * 
     * DETAILED EXPLANATION:
     * The 'private' access modifier is the most restrictive scope in Java. 
     * When a variable or method is declared as private, it can ONLY be accessed by code residing within the 
     * exact same Class block. Even a subclass that inherits from this class cannot access its private members.
     */
    private String privateAccess = "Visible ONLY within this specific class.";

    /**
     * Q6: [Medium] Detail the 'protected' Access Modifier.
     * 
     * DETAILED EXPLANATION:
     * The 'protected' modifier is highly specific to Inheritance. 
     * A protected variable or method can be accessed by any class located in the exact same package. 
     * MORE IMPORTANTLY, it can also be accessed by Subclasses (child classes) located in completely different 
     * packages. It acts as a private variable that makes a special exception for family members.
     */
    protected String protectedAccess = "Visible to package friends and family (subclasses) everywhere.";

    /**
     * Q7: [Medium] Detail the 'default' (Package-Private) Access Modifier.
     * 
     * DETAILED EXPLANATION:
     * If you do not explicitly type an access modifier (public, private, or protected), Java automatically 
     * applies the 'default' modifier. 
     * The rule for default is strict: The member is ONLY accessible to other classes that reside in the 
     * exact same package directory. Even a subclass cannot access a default member if that subclass is in 
     * a different package.
     */
    String defaultAccess = "Visible ONLY to classes in the exact same package directory.";

    /**
     * Q8: [Easy] What is Inheritance and why is it useful?
     * 
     * DETAILED EXPLANATION:
     * Inheritance is the OOP mechanism where a new class (the Subclass/Child) is derived from an existing 
     * class (the Superclass/Parent). 
     * 
     * Why? It promotes massive Code Reusability. If you have an 'Animal' class with generic eating and 
     * sleeping logic, a 'Dog' class can inherit from 'Animal'. The 'Dog' instantly gains all non-private 
     * methods and variables of 'Animal' without you having to write them again. It establishes an "IS-A" 
     * relationship (e.g., A Dog IS-A Animal).
     */
    class Animal { void eat() { System.out.println("Eating..."); } }

    /**
     * Q9: [Easy] How does the 'extends' Keyword function?
     * 
     * DETAILED EXPLANATION:
     * The 'extends' keyword is the syntax used in a class declaration to trigger Inheritance. 
     * It tells the Java compiler to link the child class to the parent class. In Java, a class can use the 
     * 'extends' keyword to inherit from ONE and ONLY ONE parent class (Java does not support multiple class inheritance).
     */
    class Dog extends Animal { 
        void bark() { System.out.println("Barking!"); }
    }

    /**
     * Q10: [Medium] What is Method Overriding?
     * 
     * DETAILED EXPLANATION:
     * Method Overriding occurs when a Child class decides it wants to completely replace or alter the behavior 
     * of a method it inherited from its Parent class. 
     * 
     * Strict Rules:
     * 1. The method in the child class MUST have the exact same name.
     * 2. The parameter list MUST be exactly identical.
     * 3. The return type must be the same (or a Covariant type).
     * 4. The access modifier in the child class cannot be MORE restrictive than the parent's modifier.
     */
    class Cat extends Animal {
        @Override
        void eat() { System.out.println("Cat aggressively eats fish!"); } // Overridden behavior
    }

    /**
     * Q11: [Easy] Why should developers use the @Override Annotation?
     * 
     * DETAILED EXPLANATION:
     * The @Override annotation is not strictly mandatory, but it is highly recommended. 
     * It acts as a safety net. It commands the Java compiler to check the parent class to ensure you are 
     * actually overriding a method. If you make a spelling mistake (like typing `eatt()`), without the 
     * annotation, Java thinks you are just making a brand new method. With the annotation, the compiler 
     * violently rejects the spelling mistake and fails the build, saving you from a hidden bug.
     */
    public void overrideAnnotation() {
        System.out.println("Prevents human error during method overriding.");
    }

    /**
     * Q12: [Medium] What is Method Overloading?
     * 
     * DETAILED EXPLANATION:
     * Method Overloading occurs when a single class has multiple methods with the exact same name, but 
     * different parameter lists. 
     * 
     * To overload successfully, the methods must differ in either:
     * 1. The number of parameters.
     * 2. The data types of the parameters.
     * 3. The order of the parameters.
     * Note: Simply changing the return type is NOT enough to overload a method.
     */
    public void calculate(int x) {}
    public void calculate(int x, int y) {} // Overloaded by parameter count

    /**
     * Q13: [Medium] Explain Compile-time Polymorphism.
     * 
     * DETAILED EXPLANATION:
     * Compile-time Polymorphism (also known as Static Binding or Early Binding) is achieved entirely through 
     * Method Overloading. 
     * 
     * It is called "Compile-time" because the Java Compiler looks at the arguments passed to the method during 
     * the compilation phase and instantly locks in EXACTLY which version of the overloaded method will be called. 
     * The decision is made before the program even runs.
     */
    public void compileTimePolymorphism() {
        calculate(5); // The compiler statically binds this to calculate(int x).
    }

    /**
     * Q14: [Medium] Explain Run-time Polymorphism.
     * 
     * DETAILED EXPLANATION:
     * Run-time Polymorphism (also known as Dynamic Binding or Late Binding) is achieved through Method Overriding.
     * 
     * If a Parent reference variable is pointing to a Child object, and a method is called, the compiler doesn't 
     * know which version of the method to use. The Java Virtual Machine (JVM) waits until the exact moment of 
     * execution at Runtime. It inspects the actual physical Object in the Heap memory, and executes that specific 
     * Object's overridden version of the method.
     */
    public void runTimePolymorphism() {
        Animal mysteryAnimal = new Cat(); 
        mysteryAnimal.eat(); // JVM determines at RUNTIME to call Cat's version of eat().
    }

    /**
     * Q15: [Medium] What is Upcasting?
     * 
     * DETAILED EXPLANATION:
     * Upcasting is the process of casting a Child class object into a Parent class reference. 
     * Java performs this automatically and implicitly because a Child object "IS-A" Parent object, so it is 
     * 100% safe. 
     * Limitation: When upcasted, the reference variable can ONLY call methods that are defined in the Parent 
     * class. It becomes blind to any unique methods that only exist in the Child class.
     */
    public void upcasting() {
        Animal upcastedDog = new Dog(); // Safe, automatic upcasting.
    }

    /**
     * Q16: [Medium] What is Downcasting?
     * 
     * DETAILED EXPLANATION:
     * Downcasting is the process of forcing a Parent reference variable (which is secretly holding a Child object) 
     * back into a Child reference variable. 
     * Java does NOT do this automatically because it is dangerous. If the Parent reference is actually holding a 
     * Cat, and you try to downcast it to a Dog, the program will crash with a ClassCastException. You must 
     * explicitly write the cast `(Dog)` to tell the compiler you accept the risk.
     */
    public void downcasting() {
        Animal upcastedDog = new Dog();
        Dog recoveredDog = (Dog) upcastedDog; // Explicit downcasting.
    }

    /**
     * Q17: [Easy] How do you prevent casting crashes using instanceof?
     * 
     * DETAILED EXPLANATION:
     * The `instanceof` operator is a boolean check. It inspects an object at runtime and returns true if the 
     * object is an instance of the specified class (or a subclass of it). It is considered a best practice to 
     * ALWAYS use `instanceof` before attempting a dangerous Downcast.
     */
    public void instanceofOperator() {
        Animal a = new Dog();
        if (a instanceof Dog) {
            Dog safeDog = (Dog) a; // 100% safe downcast
        }
    }

    /**
     * Q18: [Medium] What are Abstract Classes?
     * 
     * DETAILED EXPLANATION:
     * An Abstract Class is a class prefixed with the `abstract` keyword. It is essentially an unfinished blueprint. 
     * Because it is unfinished, the JVM absolutely forbids you from using the `new` keyword to instantiate an 
     * object of an abstract class directly. 
     * Its entire purpose is to serve as a foundational template that other concrete child classes will extend and finish.
     */
    abstract class AbstractShape { abstract void draw(); }

    /**
     * Q19: [Easy] What are Abstract Methods?
     * 
     * DETAILED EXPLANATION:
     * An Abstract Method is a method that has a signature but NO body (no curly braces, just a semicolon). 
     * It represents a strict rule or contract: "Any concrete subclass that inherits me MUST write the actual 
     * code for this method." If a class contains even one abstract method, the entire class MUST be marked as abstract.
     */
    public void abstractMethods() {
        System.out.println("Forces subclasses to provide the missing implementation.");
    }

    /**
     * Q20: [Medium] Can Abstract Classes contain concrete (finished) methods?
     * 
     * DETAILED EXPLANATION:
     * Absolutely! This is the primary difference between Abstract Classes and early Java Interfaces. 
     * An Abstract Class can contain fully written, concrete methods alongside its abstract methods. This is highly 
     * useful when you have generic logic that all child classes should share, but specific logic that each child 
     * must customize.
     */
    abstract class VehicleBase {
        void startEngine() { System.out.println("Generic engine started."); } // Shared concrete logic
        abstract void drive(); // Custom abstract logic
    }

    /**
     * Q21: [Medium] What are Interfaces in Java?
     * 
     * DETAILED EXPLANATION:
     * An Interface is a mechanism to achieve 100% abstraction (prior to Java 8). It is essentially a strict 
     * legal contract. An interface only defines WHAT an object should do (method signatures), not HOW it should 
     * do it. Any class that signs the contract (implements the interface) is legally bound to provide the actual 
     * code for every single method defined in that interface.
     */
    interface Playable { void play(); }

    /**
     * Q22: [Easy] What does the 'implements' Keyword do?
     * 
     * DETAILED EXPLANATION:
     * While classes use `extends` to inherit from other classes, a class uses the `implements` keyword to 
     * declare that it is signing the contract of an Interface. The compiler will throw an error if the class 
     * fails to write the required methods.
     */
    class VideoGame implements Playable {
        public void play() { System.out.println("Booting up game..."); }
    }

    /**
     * Q23: [Medium] How does Java handle Multiple Inheritance?
     * 
     * DETAILED EXPLANATION:
     * Java violently rejects "Multiple Class Inheritance" to prevent the "Diamond Problem" (if two parent classes 
     * have a method with the exact same name, the child wouldn't know which one to inherit). 
     * However, Java completely supports "Multiple Interface Inheritance". A single class can implement 50 
     * different interfaces, because interfaces (mostly) don't contain method bodies, so there is no confusion 
     * about which logic to inherit.
     */
    interface Recordable { void record(); }
    class StreamDeck implements Playable, Recordable {
        public void play() {}
        public void record() {}
    }

    /**
     * Q24: [Medium] What are the rules for Interface Variables?
     * 
     * DETAILED EXPLANATION:
     * Variables declared inside an interface are extremely strict. The compiler secretly and automatically 
     * adds the keywords `public static final` to every single variable in an interface. 
     * This means interface variables are always universal constants. You cannot change their value, and they 
     * belong to the interface itself, not to instances.
     */
    interface MathConstants { 
        double PI = 3.14159; // Automatically public static final
    }

    /**
     * Q25: [Advanced] What is a Marker Interface and what is its purpose?
     * 
     * DETAILED EXPLANATION:
     * A Marker Interface is an incredibly unique interface because it contains absolutely zero methods and 
     * zero variables. It is completely empty. 
     * Its purpose is to act as a "tag" or a "VIP Badge" for a class. When a class implements a Marker Interface, 
     * it signals the JVM or a framework to treat objects of that class in a special way.
     * Examples: `Serializable` (tells JVM this object can be converted to bytes), `Cloneable` (tells JVM this 
     * object is safe to duplicate).
     */
    interface TrackableObject {}

    /**
     * Q26: [Medium] What is a Functional Interface?
     * 
     * DETAILED EXPLANATION:
     * Introduced in Java 8, a Functional Interface is an interface that contains EXACTLY ONE abstract method. 
     * It can contain multiple default or static methods, but the abstract method count must be strictly one. 
     * These interfaces are the entire foundation for Lambda Expressions, allowing developers to treat functions 
     * as if they were objects. The `@FunctionalInterface` annotation is used to enforce this rule at compile time.
     */
    @FunctionalInterface
    interface MathOperation { int calculate(int a, int b); }

    /**
     * Q27: [Medium] What are Nested Classes?
     * 
     * DETAILED EXPLANATION:
     * A Nested Class is simply a class declared entirely within the curly braces of another class or interface. 
     * It is used to logically group classes that are only used in one specific place, hiding them from the rest 
     * of the application to increase encapsulation and clean up package structures.
     */
    class OuterClass {
        class NestedClass {}
    }

    /**
     * Q28: [Medium] What are Inner Classes?
     * 
     * DETAILED EXPLANATION:
     * Inner Classes are the non-static variety of Nested Classes. 
     * Because they are non-static, an Inner Class is deeply tied to a specific instance of its Outer Class. 
     * The massive advantage of an Inner Class is that it has full, unrestricted access to ALL variables and 
     * methods of the Outer Class, including the strictly `private` ones.
     */
    class OuterWithSecret {
        private String secret = "Vault";
        class InnerAccess {
            void stealSecret() { System.out.println(secret); } // Has direct access to private data.
        }
    }

    /**
     * Q29: [Medium] What are Static Nested Classes?
     * 
     * DETAILED EXPLANATION:
     * If you add the `static` keyword to a nested class, it completely severs its physical tie to the Outer 
     * Class's instance. 
     * Because it is static, it CANNOT access non-static instance variables of the Outer Class. However, it can 
     * be instantiated without needing to create an object of the Outer Class first. It acts almost exactly like 
     * a normal top-level class, just hidden inside a namespace.
     */
    class OuterWrapper {
        static class StaticNested {}
    }

    /**
     * Q30: [Advanced] What are Anonymous Inner Classes and when are they used?
     * 
     * DETAILED EXPLANATION:
     * An Anonymous Inner Class is a bizarre class that has NO name. It is declared and instantly instantiated 
     * in a single, massive expression. 
     * It is primarily used when you need to override methods of a class or implement an interface extremely 
     * quickly for one-time use, such as adding a click-listener to a UI button. It avoids the clutter of creating 
     * a whole new dedicated `.java` file for something you only need once.
     */
    public void anonymousInnerClass() {
        Playable p = new Playable() {
            public void play() { System.out.println("Instantiated interface on the fly!"); }
        };
        p.play();
    }
}