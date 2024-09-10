package oop.interfaces;

import java.util.function.Consumer;

@FunctionalInterface
interface FunctionalInterfaceExample {
    void method();
}

class RunClass implements FunctionalInterfaceExample {

    @Override
    public void method() {
        System.out.println("Running inside class using functional interface");
    }

    public static void main(String[] args) {
        RunClass runClass = new RunClass();
        runClass.method();
    }

    // Consumer interface
    // Takes one argument and returns nothing.
    // Bi-Consumer takes two arguments and returns same like Consumer interface
    Consumer<Integer> consumer = (value) -> System.out.println(value);

    // Predicate interface
    // Takes one argument and returns boolean value.
    public interface Predicate<T> {
        boolean test(T t);
    }

    // Predicate interface implementation
    public class CheckForNull implements Predicate {
        @Override
        public boolean test(Object o) {
            return o != null;
        }
    }

    //Predicate interface as Lambda expression
    Predicate predicate = (value) -> value != null;

    // Functional interface
    // Returns value after processing.
    @FunctionalInterface
    public interface BiFunction<T, U, R> {

        R apply(T t, U u);
        // Logic here ......

    }

}
