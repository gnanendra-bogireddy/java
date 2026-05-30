package oop;

/**
 * A Constructor is a special builder!
 * 
 * Imagine you go to Build-A-Bear.
 * You can get a plain bear with no name (Default Constructor).
 * Or, you can give them a name tag right when they are built (Parameterized Constructor).
 * 
 * The constructor ALWAYS has the exact same name as the Class!
 */
public class ConstructorExample {

    String bearName;
    int bearId;

    // 1. Default Constructor (No arguments)
    // If you don't say anything, you just get a generic bear.
    ConstructorExample() {
        System.out.println("Building a plain bear with no name...");
    }

    // 2. Constructor with one argument
    // You give them a name while building it.
    ConstructorExample(String name) {
        this.bearName = name;
        System.out.println("Building a bear named: " + name);
    }

    // 3. Constructor with TWO arguments (Name AND an ID tag)
    ConstructorExample(String name, int id) {
        this.bearName = name;
        this.bearId = id;
        System.out.println("Building a bear named: " + name + " with ID: " + id);
    }

    void display() {
        System.out.println("Bear Info -> Name: " + bearName + ", ID: " + bearId);
    }

    public static void main(String[] args) {
        
        // Let's build three different bears!
        System.out.println("--- Welcome to Build-A-Bear! ---");
        
        ConstructorExample bear1 = new ConstructorExample();
        ConstructorExample bear2 = new ConstructorExample("Teddy");
        ConstructorExample bear3 = new ConstructorExample("Paddington", 101);

        System.out.println("\n--- Let's look at their name tags ---");
        bear2.display();
        bear3.display();
        
        /*
         * Expected Output:
         * --- Welcome to Build-A-Bear! ---
         * Building a plain bear with no name...
         * Building a bear named: Teddy
         * Building a bear named: Paddington with ID: 101
         * 
         * --- Let's look at their name tags ---
         * Bear Info -> Name: Teddy, ID: 0
         * Bear Info -> Name: Paddington, ID: 101
         */
    }
}