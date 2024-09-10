package oop.abstraction;

// abstract is a keyword that used to declare abstract classes.
// We can not instantiate abstract classes, but we can have constructors
// We can have instance variables and non-abstract methods.
// It can implements another interface also.
// Any class that contains one or more abstract methods must also be declared abstract.
// Abstract classes can have non-abstract, static, final, abstract methods.
// If we have any abstract method class must be declared as abstract class.
// Child class no need to call abstract class constructor. This will be called automatically.
public abstract class AbstractClass {

    // abstract methods are partially implemented methods.
    // abstract type method-name(parameter-list);

    int variableOne;
    String variableTwo;
    boolean flagValue;

    public static void staticMethod() {
        System.out.println("Printing inside static method");
    }

    public final void finalMethod() {
        System.out.println("Printing inside final method");
    }

    public AbstractClass() {
        System.out.println("Abstract class constructor");
    }

    // abstract methods can not have full body implementation.
    abstract void methodOne();

    // abstract classes can have fully implemented default methods.
    public void defaultMethod() {
        System.out.println("Printing inside default method");
    }

    public static void main(String[] args) {
        System.out.println("Printing inside main method");
    }

    class ChildClass extends AbstractClass {
        @Override
        void methodOne() {
            System.out.println("Printing inside Child class implementation");
        }
    }
}
