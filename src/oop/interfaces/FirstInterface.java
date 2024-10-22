package oop.interfaces;

public interface FirstInterface {
    public default void method() {
        System.out.println("printing inside FirstInterface default method");
    }
}

interface SecondInterface {
    public default void method(){
        System.out.println("printing inside SecondInterface default method");
    }
}

class ClassName implements  FirstInterface,SecondInterface{
    public static void main(String[] args) {
        ClassName className = new ClassName();
        className.method();
    }
    // We need to either specifically mention InterfaceName.super.methodName,
    @Override
    public void method() {
        FirstInterface.super.method();
        SecondInterface.super.method();
    }

    // Either we can specifically mention our own implementation.
//    public void method(){
//        System.out.println("Printing inside Class method");
//    }

}


