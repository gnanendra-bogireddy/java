package oop.interfaces;

/**
 * Interfaces are like a Contract or a Promise!
 * 
 * Imagine you promise your Mom you will "Clean your Room".
 * You also promise your Dad you will "Clean your Room".
 * 
 * What happens if Mom and Dad both give you slightly different instructions 
 * on HOW to clean your room? You have to decide which way to do it!
 * 
 * (This is called the "Diamond Problem" in Java when two interfaces have the same default method).
 */
public interface FirstInterface {
    
    // Mom's instructions
    public default void method() {
        System.out.println("Mom says: Put the toys in the box!");
    }
}

interface SecondInterface {
    
    // Dad's instructions
    public default void method() {
        System.out.println("Dad says: Put the toys under the bed!");
    }
}

// I am a kid, and I promised BOTH Mom and Dad (implements FirstInterface, SecondInterface)
class ClassName implements FirstInterface, SecondInterface {
    
    public static void main(String[] args) {
        ClassName me = new ClassName();
        System.out.println("Time to clean my room...");
        me.method();
        
        /*
         * Expected Output:
         * Time to clean my room...
         * Mom says: Put the toys in the box!
         * Dad says: Put the toys under the bed!
         */
    }
    
    // I MUST override the method, because Java doesn't know whose instructions to follow!
    @Override
    public void method() {
        // I decided to just do both to keep them both happy!
        FirstInterface.super.method(); // Doing Mom's way
        SecondInterface.super.method(); // Doing Dad's way
        
        // (Or, I could have just ignored them both and written my own way!)
        // System.out.println("I'll just throw them out the window!");
    }
}