package oop.interfaces;

public interface InterfaceExample {

    // declare constant fields
    // declare methods that abstract
    // by default.
    // public, static and final
    final static int a = 10;

    // Interfaces can have static methods.
    public static void methodOne() {
        System.out.println("Interfaces can have static methods");
    }

    private void privateMethod() {
        System.out.println(" Interfaces can have private methods");
    }

    // Interfaces can have default methods defined by default keyword.
    // If you have multiple interfaces defines same default methods,
    // We need to explicitly override the default method with own implementation.
    default void methodTwo() {
        System.out.println("Interfaces can have default methods");
    }

    // public and abstract
    void display();
}

// A class that implements the interface.
class TestClass implements InterfaceExample {
    // Implementing the capabilities of
    // interface.
    public void display() {
        System.out.println("Geek");
    }

    // Driver Code
    public static void main(String[] args) {
        TestClass t = new TestClass();
        t.display();
        System.out.println(a);
    }
}
