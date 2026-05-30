package oop.interfaces;

/**
 * Interfaces are Contracts!
 * 
 * An Interface is like a rulebook for a Video Game Controller.
 * It says: "Any controller you build MUST have a 'Press A' button!"
 */
public interface InterfaceExample {

    // Any variable in an Interface is ALWAYS final and static (it can NEVER change).
    // It's a permanent rule!
    int maxPlayers = 4;

    // A normal rule. Whoever builds the controller MUST write the code for this!
    void pressA();

    // 'default' means we can actually write some code in the Interface!
    // It's like a backup rule. If the builder doesn't write code for this, they use ours.
    default void pressB() {
        System.out.println("Default B Button Pressed!");
    }

    // 'static' methods belong ONLY to the Interface itself. 
    // They are like instructions on the back of the manual.
    static void readManual() {
        System.out.println("Always wear the wrist strap!");
    }
}

// Now we build a real controller (TestClass) that promises to follow the rules (implements)!
class TestClass implements InterfaceExample {
    
    // We MUST write the code for pressA()
    @Override
    public void pressA() {
        System.out.println("A Button Pressed! Character jumps!");
    }

    public static void main(String[] args) {
        
        System.out.println("--- Playing the game ---");
        
        TestClass myController = new TestClass();
        
        // Using our custom code
        myController.pressA();
        
        // Using the backup 'default' code from the Interface!
        myController.pressB();
        
        // Reading the permanent rule
        System.out.println("Max players allowed: " + InterfaceExample.maxPlayers);
        
        // Calling the static method directly from the Interface
        InterfaceExample.readManual();
        
        /*
         * Expected Output:
         * --- Playing the game ---
         * A Button Pressed! Character jumps!
         * Default B Button Pressed!
         * Max players allowed: 4
         * Always wear the wrist strap!
         */
    }
}