package interviewQuestions;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;

/**
 * ============================================================================
 * INTERVIEW QUESTIONS PART 9: Java 8 Features
 * ============================================================================
 * This file contains 30 highly detailed Java interview questions.
 * Each question provides a deep-dive English explanation covering the 'What', 
 * 'Why', and 'How', along with practical Java code snippets.
 * ============================================================================
 */
public class Part9_Java8Features {

    public static void main(String[] args) {
        System.out.println("Running Part 9: Java 8 Features...");
    }

    /**
     * Q1: [Easy] Define Lambda Expressions and their core purpose.
     * 
     * DETAILED EXPLANATION:
     * Prior to Java 8, if you wanted to pass a simple piece of logic to a method, you had to write a massive, 
     * ugly "Anonymous Inner Class" with 6 lines of boilerplate code. 
     * Lambda Expressions completely revolutionized Java by introducing Functional Programming semantics. A Lambda 
     * is essentially a concise, anonymous block of code (a function without a name) that can be stored in a 
     * variable, passed into a method as an argument, or returned. 
     * Syntax: `(parameters) -> { body }`.
     */
    public void lambdaExpressions() {
        System.out.println("Lambda: Syntactic sugar that treats executable logic as variable data.");
    }

    /**
     * Q2: [Medium] What are Method References?
     * 
     * DETAILED EXPLANATION:
     * Method References are essentially a shorthand notation for a Lambda expression that does nothing but call 
     * an existing method. If your lambda looks like `x -> System.out.println(x)`, you are just passing `x` straight 
     * into `println`. 
     * Java allows you to shrink this using the double colon `::` operator: `System.out::println`. This improves 
     * readability by pointing directly to the method by its name rather than writing out the parameter routing.
     */
    public void methodReferences() {
        System.out.println("Method Reference (::): Direct pointer syntax replacing simple pass-through Lambdas.");
    }

    /**
     * Q3: [Advanced] Detail Constructor References.
     * 
     * DETAILED EXPLANATION:
     * A specialized form of a Method Reference used strictly for creating new object instances. 
     * Instead of pointing to an existing method like `.println`, you point directly to the class's `new` keyword. 
     * For example, instead of writing `() -> new ArrayList<String>()`, you write `ArrayList::new`. This is heavily 
     * utilized in the Stream API when collecting mapped data into newly instantiated data structures.
     */
    public void constructorReferences() {
        System.out.println("Constructor Reference: ClassName::new - Elegant instantiation inside Streams.");
    }

    /**
     * Q4: [Medium] What is the Predicate Interface?
     * 
     * DETAILED EXPLANATION:
     * The `java.util.function.Predicate<T>` is a core Functional Interface. It represents a strict "Yes or No" 
     * condition. It contains one abstract method: `boolean test(T t)`. 
     * It takes exactly ONE object as input, evaluates a condition against it, and returns true or false. 
     * Predicates are the absolute backbone of the Stream `.filter()` method, deciding which elements are allowed 
     * to pass through the stream and which are discarded.
     */
    public void predicate() {
        System.out.println("Predicate: Boolean evaluation function used as a gatekeeper in Stream filtering.");
    }

    /**
     * Q5: [Medium] What is the Consumer Interface?
     * 
     * DETAILED EXPLANATION:
     * The `java.util.function.Consumer<T>` interface represents an operation that takes exactly ONE object as 
     * input, does something with it, and returns absolutely NOTHING (`void`). 
     * It has one abstract method: `void accept(T t)`. 
     * Consumers are designed for generating "Side Effects" (e.g., printing data to the console, saving data to 
     * a database, or modifying the object). It is the backbone of the `.forEach()` method.
     */
    public void consumer() {
        System.out.println("Consumer: Accepts data, processes it internally, and returns void.");
    }

    /**
     * Q6: [Medium] What is the Supplier Interface?
     * 
     * DETAILED EXPLANATION:
     * The `java.util.function.Supplier<T>` interface is the exact opposite of a Consumer. It takes ZERO inputs, 
     * but returns an Object. 
     * It has one abstract method: `T get()`. 
     * Suppliers are heavily used in "Lazy Evaluation" architectures. For example, generating a Random Number, 
     * fetching the current System Time, or throwing a custom Exception only if an Optional is empty.
     */
    public void supplier() {
        System.out.println("Supplier: Provides data on-demand without requiring any input parameters.");
    }

    /**
     * Q7: [Medium] What is the Function Interface?
     * 
     * DETAILED EXPLANATION:
     * The `java.util.function.Function<T, R>` interface is a massive powerhouse. It takes ONE argument of type `T`, 
     * performs a transformation or calculation, and returns a result of type `R`. 
     * It has one abstract method: `R apply(T t)`. 
     * Functions are the absolute backbone of the Stream `.map()` method, used to transform objects (e.g., taking in 
     * a `String` and returning its `Integer` length).
     */
    public void function() {
        System.out.println("Function: The core transformation engine taking Input Type T and returning Output Type R.");
    }

    /**
     * Q8: [Medium] How does BiFunction differ from Function?
     * 
     * DETAILED EXPLANATION:
     * A standard `Function` only accepts one argument. The `BiFunction<T, U, R>` interface accepts exactly TWO 
     * arguments (`T` and `U`), processes them together, and returns a single result `R`. 
     * It has one abstract method: `R apply(T t, U u)`. 
     * BiFunctions are heavily utilized in Map methods like `.merge()`, where you must calculate a new result 
     * based on an Old Value and a New Value.
     */
    public void biFunction() {
        System.out.println("BiFunction: Analyzes two separate input arguments to compute a single return value.");
    }

    /**
     * Q9: [Advanced] What is a UnaryOperator?
     * 
     * DETAILED EXPLANATION:
     * `UnaryOperator<T>` is simply a specialized sub-interface that extends `Function<T, T>`. 
     * It is used when the input argument and the return result are guaranteed to be of the EXACT SAME data type. 
     * For example, taking in an Integer, squaring it, and returning the resulting Integer. It exists purely to 
     * make generic definitions cleaner and more readable.
     */
    public void unaryOperator() {
        System.out.println("UnaryOperator: A specialized Function where Input Type matches Output Type perfectly.");
    }

    /**
     * Q10: [Advanced] What is a BinaryOperator?
     * 
     * DETAILED EXPLANATION:
     * `BinaryOperator<T>` is a specialized sub-interface that extends `BiFunction<T, T, T>`. 
     * It accepts TWO arguments of the exact same type and returns a result of that exact same type. 
     * This is the absolute core engine behind the Stream `.reduce()` method. If you want to sum a list of 100 
     * Integers, the BinaryOperator takes two Integers, adds them, returns the Integer sum, and repeats the process.
     */
    public void binaryOperator() {
        System.out.println("BinaryOperator: Synthesizes two identical-type inputs into a singular identical-type output.");
    }

    /**
     * Q11: [Medium] Detail the Stream API and its core philosophy.
     * 
     * DETAILED EXPLANATION:
     * The Stream API (`java.util.stream`) is NOT a data structure. It does not store data. It is a pipeline through 
     * which data flows. 
     * Philosophy: You attach a Stream to a source (like an ArrayList). The Stream pulls the data through a series 
     * of declarative, intermediate operations (filtering, sorting, mapping) without EVER modifying the original 
     * ArrayList. Once the data reaches a Terminal Operation (like collect), the Stream is consumed and closed permanently.
     */
    public void streamAPI() {
        System.out.println("Stream API: A functional pipeline for highly efficient, non-mutating data processing.");
    }

    /**
     * Q12: [Medium] Analyze the Stream filter() operation.
     * 
     * DETAILED EXPLANATION:
     * An Intermediate Operation. It accepts a `Predicate`. As elements flow down the stream, `filter()` acts as a 
     * security checkpoint. It executes the Predicate against each element. If the Predicate returns `true`, the 
     * element is allowed to continue down the pipeline. If `false`, the element is permanently dropped from the stream.
     */
    public void streamFilter() {
        System.out.println("Filter: The conditional gatekeeper utilizing Predicates to exclude unwanted data.");
    }

    /**
     * Q13: [Medium] Analyze the Stream map() operation.
     * 
     * DETAILED EXPLANATION:
     * An Intermediate Operation. It accepts a `Function`. It is a strict 1-to-1 transformation mapping. 
     * If 5 elements enter the `map()`, exactly 5 elements will exit. However, the internal data type or state of 
     * those elements is transformed by the Function (e.g., taking in a stream of `Employee` objects and mapping 
     * them out as a stream of `String` employee names).
     */
    public void streamMap() {
        System.out.println("Map: A 1-to-1 transformation engine that morphs objects into new structural forms.");
    }

    /**
     * Q14: [Advanced] Contrast Stream map() with Stream flatMap().
     * 
     * DETAILED EXPLANATION:
     * `map()` is strictly 1-to-1. If you apply `map()` to a `List<List<String>>`, the stream continues as a stream 
     * of List objects. 
     * `flatMap()` is a 1-to-Many operation. It accepts a Function that returns a Stream itself. It then takes all 
     * those tiny internal streams and "flattens" them, dumping their raw contents into one massive master stream. 
     * So a `List<List<String>>` is flattened down into a single `Stream<String>`, perfectly merging the nested data.
     */
    public void streamFlatMap() {
        System.out.println("FlatMap: Deconstructs nested Collections, merging their raw contents into a singular flat pipeline.");
    }

    /**
     * Q15: [Easy] Detail the Stream distinct() operation.
     * 
     * DETAILED EXPLANATION:
     * An Intermediate Operation that acts as a deduplicator. It monitors the elements flowing through the pipeline. 
     * It relies heavily on the `equals()` and `hashCode()` methods of the objects. If an object flows through that 
     * is logically identical to an object it has already processed, `distinct()` silently drops the duplicate.
     */
    public void streamDistinct() {
        System.out.println("Distinct: Relies on hashCode/equals to silently purge duplicate elements from the stream.");
    }

    /**
     * Q16: [Easy] Detail the Stream sorted() operation.
     * 
     * DETAILED EXPLANATION:
     * An Intermediate Operation that arranges elements. It is a "Stateful" operation. Because it cannot sort a 
     * stream until it sees EVERY element, the stream essentially pauses at `sorted()`, buffers all elements into 
     * memory, sorts them (via Natural Order or a provided Comparator), and then releases them sequentially down 
     * the rest of the pipeline.
     */
    public void streamSorted() {
        System.out.println("Sorted: A stateful buffer that organizes stream flow via Comparators.");
    }

    /**
     * Q17: [Medium] What is the utility of Stream peek()?
     * 
     * DETAILED EXPLANATION:
     * `peek()` is an Intermediate Operation that accepts a `Consumer`. It does absolutely nothing to alter the 
     * stream's elements or flow. It simply allows you to "peek" at an element, perform an action (like logging 
     * or `System.out.println()`), and let the element continue. It is an invaluable debugging tool to see what 
     * data looks like halfway through a complex pipeline.
     */
    public void streamPeek() {
        System.out.println("Peek: A non-destructive debugging window into active stream states.");
    }

    /**
     * Q18: [Medium] How do Stream limit() and skip() facilitate pagination?
     * 
     * DETAILED EXPLANATION:
     * Both are Intermediate Operations heavily used for database-style pagination. 
     * `skip(N)` tells the stream to instantly ignore and drop the first N elements that flow into it. 
     * `limit(N)` acts as a quota. Once it allows N elements to pass through it, it acts as a short-circuit and 
     * terminates the entire stream process, ignoring any millions of elements waiting behind it.
     */
    public void streamLimitSkip() {
        System.out.println("Limit/Skip: Short-circuit logic perfect for restricting processing windows (Pagination).");
    }

    /**
     * Q19: [Advanced] Detail the mechanics of the Stream reduce() Terminal Operation.
     * 
     * DETAILED EXPLANATION:
     * `reduce()` takes a stream of thousands of elements and systematically folds them down into ONE singular value. 
     * It requires a `BinaryOperator`. It takes an initial "identity" value (like 0). It applies the Operator to 
     * 0 and the 1st element. It takes that result, applies the Operator to it and the 2nd element, and so on. 
     * Summing numbers, finding the maximum value, or concatenating strings manually are all reduction operations.
     */
    public void streamReduce() {
        System.out.println("Reduce: Synthesizes massive datasets into a single atomic output value.");
    }

    /**
     * Q20: [Medium] Detail the mechanics of the Stream collect() Terminal Operation.
     * 
     * DETAILED EXPLANATION:
     * While `reduce()` folds data mathematically, `collect()` is a mutable reduction. It takes the elements flowing 
     * out of the pipeline and pushes them into a brand new data container. By using the `Collectors` utility class, 
     * you can easily tell the stream to dump the surviving elements into a fresh `List`, `Set`, or `Map`, terminating 
     * the stream and returning your newly assembled Collection.
     */
    public void streamCollect() {
        System.out.println("Collect: The final destination, packaging processed stream data into new physical Collections.");
    }

    /**
     * Q21: [Easy] Detail Collectors.toList().
     * 
     * DETAILED EXPLANATION:
     * The most frequently used Terminal Operation in Java 8. It accumulates the final elements of a stream into 
     * a generic `List` (typically an ArrayList under the hood). Crucially, the returned List is NOT guaranteed 
     * to be mutable, thread-safe, or of any specific implementation.
     */
    public void collectorsToList() {
        System.out.println("Collectors.toList(): Standard packaging into a List interface.");
    }

    /**
     * Q22: [Advanced] Detail Collectors.groupingBy() and its power in data analysis.
     * 
     * DETAILED EXPLANATION:
     * Essentially the SQL `GROUP BY` clause brought to Java Collections. 
     * You provide it a classification `Function` (e.g., `Employee::getDepartment`). The collector automatically 
     * generates a `Map`. The Keys are the distinct Departments, and the Values are `List<Employee>` containing 
     * all employees that belong to that specific department. It replaces dozens of lines of manual looping code.
     */
    public void collectorsGroupingBy() {
        System.out.println("groupingBy(): Sophisticated categorization engine returning structured Maps.");
    }

    /**
     * Q23: [Medium] Detail Collectors.joining().
     * 
     * DETAILED EXPLANATION:
     * A hyper-optimized collector specifically for Streams of Strings (CharSequences). 
     * Instead of using a clumsy `StringBuilder` inside a loop, `joining(", ")` takes every string in the stream 
     * and flawlessly glues them together into one massive String, automatically inserting the delimiter between 
     * elements (without putting a messy trailing comma at the end).
     */
    public void collectorsJoining() {
        System.out.println("joining(): Cleanly concatenates String streams using defined delimiters.");
    }

    /**
     * Q24: [Medium] Why was the Optional Class introduced?
     * 
     * DETAILED EXPLANATION:
     * The billion-dollar mistake in software engineering is the `NullPointerException`. Prior to Java 8, methods 
     * returning `null` forced developers to write endless `if (obj != null)` checks. 
     * `Optional<T>` is a sturdy box. The box might contain the Object, or it might be totally empty. By forcing 
     * a method to return an `Optional`, you explicitly warn the caller: "Be careful, this data might be missing." 
     * It forces the developer to handle the missing data scenario using its functional methods.
     */
    public void optionalClass() {
        System.out.println("Optional: A paradigm shift to eradicate unhandled NullPointerExceptions.");
    }

    /**
     * Q25: [Medium] Detail Optional.ifPresent().
     * 
     * DETAILED EXPLANATION:
     * The functional replacement for `if (obj != null) { doSomething(); }`. 
     * `ifPresent()` accepts a `Consumer` lambda. If the Optional box is empty, it silently ignores the request 
     * and does absolutely nothing. If the box contains data, it instantly hands that data to the Consumer to process.
     */
    public void optionalIfPresent() {
        System.out.println("ifPresent(): Executes Consumer logic exclusively if the wrapper contains valid data.");
    }

    /**
     * Q26: [Easy] Detail Optional.orElse().
     * 
     * DETAILED EXPLANATION:
     * A safe data-extraction method. You attempt to pull the data out of the Optional box. If data exists, it 
     * hands it to you. If the box is empty, it hands you the "Default Fallback" value you provided in the parenthesis, 
     * guaranteeing you never end up with a `null` variable.
     */
    public void optionalOrElse() {
        System.out.println("orElse(): Extracts data safely, supplying a hardcoded fallback upon failure.");
    }

    /**
     * Q27: [Medium] Contrast Optional.orElse() with orElseGet().
     * 
     * DETAILED EXPLANATION:
     * `orElse(calculateDefault())` has a flaw: it executes the `calculateDefault()` method IMMEDIATELY, even if 
     * the Optional is full and doesn't need the fallback. This wastes CPU if the calculation is a heavy database query. 
     * `orElseGet(Supplier)` utilizes Lazy Evaluation. The Supplier lambda is ONLY executed if the Optional is proven 
     * to be empty. It is far more performant for heavy operations.
     */
    public void optionalOrElseGet() {
        System.out.println("orElseGet(): Utilizes Lazy Evaluation for high-performance dynamic fallbacks.");
    }

    /**
     * Q28: [Medium] Detail Optional.orElseThrow().
     * 
     * DETAILED EXPLANATION:
     * Used in strict validation scenarios. You try to extract data from the Optional. If it exists, you proceed. 
     * If the Optional is empty, it executes a `Supplier` that instantly instantiates and throws a Custom Exception 
     * (e.g., `UserNotFoundException`). It terminates the flow rather than trying to provide a fake default value.
     */
    public void optionalOrElseThrow() {
        System.out.println("orElseThrow(): Violently aborts the flow with custom Exceptions if data is missing.");
    }

    /**
     * Q29: [Medium] Why did Java 8 allow Default Methods in Interfaces?
     * 
     * DETAILED EXPLANATION:
     * Historically, interfaces were strict: 100% abstract methods. 
     * In Java 8, Oracle wanted to add `stream()` and `forEach()` to the massive `Collection` interface. However, 
     * doing so would instantly break millions of corporate Java applications worldwide, because every custom list 
     * class would suddenly be missing implementations for those new methods. 
     * `default` methods allow interface designers to add brand new methods complete with full code bodies. Legacy 
     * classes inherit the code perfectly without breaking, while modern classes can override it if they choose.
     */
    public void defaultMethodsInInterfaces() {
        System.out.println("Default Methods: Allowed backward-compatible evolution of core Java APIs.");
    }

    /**
     * Q30: [Medium] Why did Java 8 allow Static Methods in Interfaces?
     * 
     * DETAILED EXPLANATION:
     * Interfaces often require general utility helper methods (like validation or sorting logic). 
     * Previously, developers had to create a completely separate "Utility" class (like `Collections` for the `Collection` interface). 
     * Allowing `static` methods inside interfaces means the Utility methods can reside directly inside the interface 
     * they belong to, vastly improving code cohesion and organization. They cannot be overridden by implementing classes.
     */
    public void staticMethodsInInterfaces() {
        System.out.println("Static Methods: Embeds cohesive Utility functions directly into the Interface blueprint.");
    }
}