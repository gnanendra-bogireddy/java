package oop.interfaces;

/**
 * Nested Interfaces are like a Russian Nesting Doll!
 * 
 * You can put an Interface INSIDE another Interface, or inside a Class!
 * It's a great way to keep things super organized.
 */
public class NestedInterfaces {
    
    // This is an interface hiding INSIDE a class!
    // It's like a secret rulebook kept in the teacher's desk.
    public interface NestedInterface {
        void show();
    }
}

interface OuterInterface {
    
    // This is an interface hiding INSIDE another interface!
    // It's like a small rulebook tucked inside a big rulebook.
    public interface InnerInterface {
        void showtime();
    }
}

// Now we want to follow BOTH of those hidden rules!
class TestClassOne implements NestedInterfaces.NestedInterface, OuterInterface.InnerInterface {
    
    // Following the rule from the Class's hidden interface
    @Override
    public void show() {
        System.out.println("Showing the secret from the Class!");
    }

    // Following the rule from the Interface's hidden interface
    @Override
    public void showtime() {
        System.out.println("It's showtime from the nested Interface!");
    }

    public static void main(String[] args) {
        System.out.println("--- Playing with Nested Dolls ---");
        
        TestClassOne player = new TestClassOne();
        player.show();
        player.showtime();
        
        /*
         * Expected Output:
         * --- Playing with Nested Dolls ---
         * Showing the secret from the Class!
         * It's showtime from the nested Interface!
         */
    }
}