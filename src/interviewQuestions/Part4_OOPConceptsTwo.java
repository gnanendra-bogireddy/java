package interviewQuestions;

/**
 * ============================================================================
 * INTERVIEW QUESTIONS PART 4: OOP Concepts Two & Design Patterns
 * ============================================================================
 * This file contains 30 highly detailed Java interview questions.
 * Each question provides a deep-dive English explanation covering the 'What', 
 * 'Why', and 'How', along with practical Java code snippets.
 * ============================================================================
 */
public class Part4_OOPConceptsTwo {

    public static void main(String[] args) {
        System.out.println("Running Part 4: OOP Concepts Two & Patterns...");
    }

    /**
     * Q1: [Medium] Define Coupling in software engineering. Why is Tight Coupling bad?
     * 
     * DETAILED EXPLANATION:
     * Coupling describes the degree of dependency or direct knowledge one class has about another class. 
     * - Tight Coupling: Class A directly creates and uses the exact implementation of Class B. If Class B 
     *   changes its constructor or logic, Class A immediately breaks. This causes a ripple effect of bugs.
     * - Loose Coupling: Class A interacts with Class B through an Interface. Class A doesn't care how 
     *   Class B works internally, as long as it respects the interface contract. Loose coupling is highly 
     *   desired because it makes code modular, testable, and robust against changes.
     */
    public void coupling() {
        System.out.println("Loose coupling is achieved via Interfaces and Dependency Injection.");
    }

    /**
     * Q2: [Medium] Define Cohesion. Why is High Cohesion good?
     * 
     * DETAILED EXPLANATION:
     * Cohesion measures how strongly related the responsibilities of a single class are. 
     * - Low Cohesion: A 'Utility' class that handles Database connections, sending Emails, and parsing XML. 
     *   This is a "God Class" and is terrible because any change to one system might break the others.
     * - High Cohesion: A class is designed to do exactly ONE job very well. For example, an 'EmailSender' 
     *   class that only worries about SMTP protocols. High cohesion makes classes incredibly easy to read, 
     *   debug, and reuse.
     */
    public void cohesion() {
        System.out.println("High cohesion directly correlates with the Single Responsibility Principle.");
    }

    /**
     * Q3: [Medium] What is Association in OOP?
     * 
     * DETAILED EXPLANATION:
     * Association is a broad structural relationship indicating that two distinct objects are communicating 
     * or linked. It establishes a "Uses-A" relationship. 
     * For example, a 'Doctor' and a 'Patient'. A Doctor interacts with many Patients, and a Patient interacts 
     * with many Doctors. Neither object "owns" the other, and they both have completely independent lifecycles. 
     * If the Doctor retires, the Patient still exists.
     */
    public void association() {
        System.out.println("Association is a baseline relationship linking two independent objects.");
    }

    /**
     * Q4: [Advanced] What is Aggregation? How does it differ from Association?
     * 
     * DETAILED EXPLANATION:
     * Aggregation is a specialized, stricter form of Association. It defines a one-way "HAS-A" relationship 
     * representing a "Whole-to-Part" dynamic. 
     * Crucially, in Aggregation, the relationship is WEAK. The child object can exist completely independently 
     * of the parent object. 
     * Example: A 'University' and 'Professors'. The University HAS Professors. However, if the University 
     * burns down and ceases to exist, the Professors do not die; they survive independently and can join a 
     * different University.
     */
    public void aggregation() {
        System.out.println("Weak HAS-A relationship. Child survives parent destruction.");
    }

    /**
     * Q5: [Advanced] What is Composition? How does it differ from Aggregation?
     * 
     * DETAILED EXPLANATION:
     * Composition is the strictest form of Association. It defines a "HAS-A" relationship that is incredibly 
     * STRONG. In Composition, the child object is entirely dependent on the parent object. 
     * Example: A 'House' and its 'Rooms'. A House HAS Rooms. If the House is demolished with a wrecking ball, 
     * the Rooms are instantly destroyed alongside it. A Room cannot exist without the House. The parent class 
     * controls the exact lifecycle (creation and destruction) of the child objects.
     */
    public void composition() {
        System.out.println("Strong HAS-A relationship. Parent destruction guarantees child destruction.");
    }

    /**
     * Q6: [Medium] Explain the Singleton Design Pattern. When is it used?
     * 
     * DETAILED EXPLANATION:
     * Singleton is a Creational Design Pattern used when an application needs exactly ONE, and only one, 
     * instance of a class floating in memory to coordinate actions. 
     * Implementation requires:
     * 1. A `private` constructor to completely prevent anyone from using the 'new' keyword.
     * 2. A `private static` variable holding the lone instance.
     * 3. A `public static` method (usually named `getInstance()`) that creates the object on the first call, 
     *    and simply returns the existing object on all subsequent calls.
     * Use Cases: Database Connection Managers, Loggers, Configuration Loaders.
     */
    public void singletonPattern() {
        System.out.println("Restricts instantiation to exactly one object across the JVM.");
    }

    /**
     * Q7: [Advanced] What makes a Singleton "Thread-Safe"? How is Double-Checked Locking used?
     * 
     * DETAILED EXPLANATION:
     * In a multithreaded environment, if two threads hit the `getInstance()` method at the exact same millisecond 
     * while the instance is null, they will BOTH create an object, completely breaking the Singleton rule.
     * To fix this, we use Double-Checked Locking. We check if the instance is null. If it is, we enter a 
     * `synchronized` block to lock the class. Inside the lock, we check if it is null AGAIN (in case another 
     * thread built it while we were waiting for the lock). We also mark the instance variable as `volatile` 
     * to prevent CPU cache visibility bugs.
     */
    static class ThreadSafeSingleton {
        private static volatile ThreadSafeSingleton instance;
        private ThreadSafeSingleton() {}
        public static ThreadSafeSingleton getInstance() {
            if (instance == null) { // First check (unsynchronized, fast)
                synchronized (ThreadSafeSingleton.class) { // Lock the class
                    if (instance == null) instance = new ThreadSafeSingleton(); // Second check (safe)
                }
            }
            return instance;
        }
    }

    /**
     * Q8: [Medium] Explain the Factory Design Pattern.
     * 
     * DETAILED EXPLANATION:
     * The Factory pattern is a Creational pattern used to create objects without exposing the complex 
     * instantiation logic to the client. Instead of writing `new ChromeDriver()` or `new FirefoxDriver()` 
     * throughout your automation framework, you call a central Factory class method like `getDriver("chrome")`. 
     * The Factory decides which object to build and returns it as a generic interface (WebDriver). 
     * This makes it incredibly easy to add new browser types later without hunting down every 'new' keyword in your code.
     */
    public void factoryPattern() {
        System.out.println("Delegates complex object creation logic to a centralized Factory class.");
    }

    /**
     * Q9: [Advanced] Explain the Builder Design Pattern and its use in Automation.
     * 
     * DETAILED EXPLANATION:
     * The Builder pattern is a Creational pattern designed to solve the "Telescoping Constructor Anti-Pattern" 
     * (having a constructor with 15 parameters, 10 of which might be null). 
     * The Builder provides a step-by-step fluent interface to construct complex objects. 
     * In SDET roles, it is massively popular for creating Test Data (DTOs). You can write clean code like: 
     * `User user = new UserBuilder().setName("Bob").setAge(30).build();`
     */
    public void builderPattern() {
        System.out.println("Constructs highly complex objects step-by-step using method chaining.");
    }

    /**
     * Q10: [Medium] What is the Observer Design Pattern?
     * 
     * DETAILED EXPLANATION:
     * The Observer is a Behavioral pattern defining a one-to-many dependency. One central object (the Subject) 
     * holds data. Multiple other objects (the Observers) "subscribe" to the Subject. When the Subject's data 
     * changes, it automatically broadcasts an update to every subscribed Observer. 
     * This is the underlying mechanics of Event Listeners, UI rendering updates, and TestNG listeners.
     */
    public void observerPattern() {
        System.out.println("Publish/Subscribe model. One subject notifies many listening observers.");
    }

    /**
     * Q11: [Advanced] Explain the Decorator Design Pattern.
     * 
     * DETAILED EXPLANATION:
     * The Decorator is a Structural pattern used to dynamically attach new behaviors or responsibilities to an 
     * existing object at runtime, without altering its structure or using massive inheritance chains. 
     * Java's I/O Streams are the perfect example: You take a basic `FileReader`, and you "decorate" (wrap) it 
     * inside a `BufferedReader` to suddenly give it buffering capabilities, without changing the original FileReader class.
     */
    public void decoratorPattern() {
        System.out.println("Wraps objects inside other objects to stack modular features dynamically.");
    }

    /**
     * Q12: [Advanced] Explain the Strategy Design Pattern.
     * 
     * DETAILED EXPLANATION:
     * The Strategy is a Behavioral pattern used when you have multiple different algorithms for performing a 
     * specific task, and you want to swap them out dynamically at runtime. 
     * Instead of writing a massive `switch` statement with 10 cases, you extract each algorithm into its own 
     * class that implements a common Interface. The main program simply calls `.execute()` on the interface, 
     * totally oblivious to which strategy object was handed to it.
     */
    public void strategyPattern() {
        System.out.println("Encapsulates algorithms in independent classes to swap them at runtime.");
    }

    /**
     * Q13: [Medium] What is the Single Responsibility Principle (SOLID: S)?
     * 
     * DETAILED EXPLANATION:
     * "A class should have one, and only one, reason to change." 
     * If a class is handling User Authentication, generating PDF Reports, and managing Database connections, 
     * it violates this principle. If the database schema changes, the class breaks. If the PDF library updates, 
     * the class breaks. By splitting these into three distinct classes, you contain bugs to specific areas.
     */
    public void singleResponsibility() {
        System.out.println("SRP: One class = One highly focused job.");
    }

    /**
     * Q14: [Medium] What is the Open/Closed Principle (SOLID: O)?
     * 
     * DETAILED EXPLANATION:
     * "Software entities should be OPEN for extension, but CLOSED for modification."
     * Once a class is written and tested, you should almost never go back in and modify its core logic to add 
     * new features, because you risk breaking existing systems. Instead, you should design the class so that 
     * new features can be added by extending it (via Inheritance) or implementing its interfaces.
     */
    public void openClosed() {
        System.out.println("OCP: Add new features by writing new classes, not by modifying old ones.");
    }

    /**
     * Q15: [Advanced] What is the Liskov Substitution Principle (SOLID: L)?
     * 
     * DETAILED EXPLANATION:
     * "Objects in a program should be replaceable with instances of their subtypes without altering the 
     * correctness of the program."
     * If Class B extends Class A, Class B must behave like Class A. If Class A has a `fly()` method, and Class B 
     * is a `Penguin` that throws an Exception when `fly()` is called, it severely violates Liskov. A program 
     * expecting a flying bird will crash when handed a Penguin.
     */
    public void liskovSubstitution() {
        System.out.println("LSP: Child classes must honor the logical contracts established by Parent classes.");
    }

    /**
     * Q16: [Medium] What is the Interface Segregation Principle (SOLID: I)?
     * 
     * DETAILED EXPLANATION:
     * "Clients should not be forced to depend upon interfaces that they do not use."
     * If you have a massive interface called `Worker` with methods `code()`, `test()`, and `serveFood()`, and 
     * a `Programmer` class implements it, the Programmer is forced to write a dummy `serveFood()` method. 
     * Instead, split it into smaller, hyper-specific interfaces like `Developer` and `Waiter`.
     */
    public void interfaceSegregation() {
        System.out.println("ISP: Many small, specific client interfaces are better than one general-purpose interface.");
    }

    /**
     * Q17: [Advanced] What is the Dependency Inversion Principle (SOLID: D)?
     * 
     * DETAILED EXPLANATION:
     * "High-level modules should not depend on low-level modules. Both should depend on abstractions."
     * Your main `PaymentProcessor` class should not directly create a `PayPalAPI` object using the `new` keyword. 
     * If PayPal goes down, you have to rewrite your processor. Instead, `PaymentProcessor` should depend on a 
     * generic `PaymentGateway` interface. You can inject `StripeAPI` or `PayPalAPI` into it seamlessly.
     */
    public void dependencyInversion() {
        System.out.println("DIP: Decouple architecture by relying on Interfaces, not concrete classes.");
    }

    /**
     * Q18: [Easy] Explain the DRY Principle.
     * 
     * DETAILED EXPLANATION:
     * DRY stands for "Don't Repeat Yourself". It is a fundamental rule of software development stating that 
     * duplicate logic should not exist in multiple places. If you have the exact same 10 lines of code in 
     * 4 different classes, extract them into a single Utility method. If a bug is found in that logic, you 
     * only have to fix it in one place, not four.
     */
    public void dryPrinciple() {
        System.out.println("DRY: Centralize duplicate logic into reusable methods.");
    }

    /**
     * Q19: [Easy] Explain the KISS Principle.
     * 
     * DETAILED EXPLANATION:
     * KISS stands for "Keep It Simple, Stupid". It asserts that systems work best when they have simple designs 
     * rather than complex ones. Developers should avoid writing overly clever, complex, "one-liner" code that 
     * no one else can read. Code is read ten times more than it is written; prioritize readability and simplicity.
     */
    public void kissPrinciple() {
        System.out.println("KISS: Readable, simple code is superior to complex, 'clever' code.");
    }

    /**
     * Q20: [Medium] Explain the YAGNI Principle.
     * 
     * DETAILED EXPLANATION:
     * YAGNI stands for "You Aren't Gonna Need It". It is a principle of extreme programming warning developers 
     * not to build infrastructure, classes, or parameters for features they *think* they might need in the future. 
     * 90% of the time, those future features never happen, and the codebase is left bloated with useless, dead code.
     */
    public void yagniPrinciple() {
        System.out.println("YAGNI: Only write code that is required for today's requirements.");
    }

    /**
     * Q21: [Advanced] What is Dependency Injection (DI)?
     * 
     * DETAILED EXPLANATION:
     * DI is an implementation of the Dependency Inversion Principle. Instead of an object constructing its own 
     * dependencies (using `new`), the dependencies are "injected" or pushed into the object from the outside.
     * This is usually done via Constructor Injection. It makes mocking dependencies during Unit Testing incredibly 
     * easy because you can inject dummy objects instead of real database connections.
     */
    public void dependencyInjection() {
        System.out.println("DI: External entities provide the required dependencies to a class.");
    }

    /**
     * Q22: [Advanced] What is Inversion of Control (IoC)?
     * 
     * DETAILED EXPLANATION:
     * IoC is a broad architectural concept where the control flow of a program is reversed. 
     * In traditional programming, your custom code calls library functions to do tasks. In IoC (like the Spring 
     * Framework or TestNG), you write custom code, and the FRAMEWORK calls YOUR code at the appropriate time 
     * (often called the "Hollywood Principle: Don't call us, we'll call you").
     */
    public void inversionOfControl() {
        System.out.println("IoC: The framework drives the execution flow, calling your custom methods.");
    }

    /**
     * Q23: [Easy] What exactly is a POJO?
     * 
     * DETAILED EXPLANATION:
     * POJO stands for "Plain Old Java Object". It is a standard, lightweight Java class that is not tied to, 
     * nor inherits from, any heavy enterprise frameworks. It has no strict naming conventions. It usually consists 
     * of private instance variables, a constructor, and standard getters and setters. It exists purely to hold data.
     */
    public void pojo() {
        System.out.println("POJO: A pure Java class with zero framework dependencies.");
    }

    /**
     * Q24: [Medium] What are the strict rules to make a Java Bean?
     * 
     * DETAILED EXPLANATION:
     * A Java Bean is a specific, strict subset of a POJO. To be a true Java Bean, it MUST follow these 3 rules:
     * 1. All properties must be `private` and accessed via standard naming convention getters and setters.
     * 2. It MUST have a public no-argument (default) constructor.
     * 3. It MUST implement the `java.io.Serializable` interface so it can be converted to a byte stream.
     * Frameworks rely heavily on these strict rules to automatically map JSON or database rows to Objects.
     */
    public void javaBeans() {
        System.out.println("Java Bean: A strict POJO designed for framework serialization.");
    }

    /**
     * Q25: [Medium] What is a DTO (Data Transfer Object)?
     * 
     * DETAILED EXPLANATION:
     * A DTO is a design pattern used to reduce the number of expensive network calls. 
     * If an API client needs a User's name, address, and recent orders, instead of making 3 separate database/network 
     * calls, the backend packages all that diverse data into a single, flat 'UserDashboardDTO' object and sends 
     * it over the network in one massive chunk. DTOs typically do not contain any business logic.
     */
    public void dto() {
        System.out.println("DTO: Aggregates scattered data into one payload for efficient network transfer.");
    }

    /**
     * Q26: [Medium] What is a DAO (Data Access Object)?
     * 
     * DETAILED EXPLANATION:
     * The DAO is a structural pattern used to isolate and separate the core Business Logic layer from the 
     * Database Persistence layer. 
     * Instead of having SQL queries mixed in with your business rules, you create a `UserDAO` class. All SQL 
     * inserts, updates, and deletes live exclusively in the DAO. The business layer simply calls `userDao.save(user)`. 
     * If you switch from MySQL to MongoDB, you only rewrite the DAO, leaving the business logic untouched.
     */
    public void dao() {
        System.out.println("DAO: An abstraction layer that handles all direct database communications.");
    }

    /**
     * Q27: [Medium] What defines a Value Object?
     * 
     * DETAILED EXPLANATION:
     * A Value Object is a small object that represents a descriptive aspect of the domain with no conceptual identity. 
     * Two Value Objects are considered perfectly equal if all their properties match, regardless of memory address. 
     * Example: `Color(red: 255, green: 0, blue: 0)`. If you have two Color objects with those values, they are logically 
     * the exact same color. Value objects should always be immutable.
     */
    public void valueObjects() {
        System.out.println("Value Object: Equality is based entirely on internal state, not identity.");
    }

    /**
     * Q28: [Medium] What are the rules to create an Immutable Object in Java?
     * 
     * DETAILED EXPLANATION:
     * An Immutable Object is an object whose state cannot be altered after instantiation. To build one:
     * 1. Declare the class as `final` so it cannot be extended.
     * 2. Make all fields `private` and `final`.
     * 3. Do NOT provide any Setter methods.
     * 4. Deep Copy complex fields: If the object holds an ArrayList, return a clone or unmodifiable view in the getter, 
     *    never the direct memory reference, otherwise external code can alter the internal list.
     */
    public void immutableObjects() {
        System.out.println("Immutable Objects guarantee thread-safety by permanently locking their state.");
    }

    /**
     * Q29: [Medium] When should you use Builder vs Factory patterns?
     * 
     * DETAILED EXPLANATION:
     * - The Factory Pattern focuses on Polymorphism. It decides "WHAT" to build. You ask for a Vehicle, and 
     *   the factory decides whether to return a Car object or a Truck object based on conditions.
     * - The Builder Pattern focuses on Complexity. It handles "HOW" to build. You know you want a Car object, 
     *   but the Car has 20 different optional configurations (sunroof, turbo, leather seats). The Builder handles 
     *   the intricate assembly process.
     */
    public void builderVsFactory() {
        System.out.println("Factory determines the Object Type. Builder manages Object Assembly complexity.");
    }

    /**
     * Q30: [Advanced] Explain the Object Pool Pattern.
     * 
     * DETAILED EXPLANATION:
     * Object Pooling is a performance optimization pattern. Creating certain objects (like Database Connections or 
     * complex WebDrivers) is extremely slow and CPU intensive. 
     * Instead of destroying the object when finished, you return it to a "Pool" (a collection). When another thread 
     * needs a database connection, it borrows a pre-existing one from the Pool rather than instantiating a new one. 
     * This drastically reduces latency and Garbage Collection overhead.
     */
    public void objectPool() {
        System.out.println("Object Pool: Reuses expensive objects to avoid massive instantiation latency.");
    }
}