package modernJava;

/**
 * Pattern Matching (Java 16) is like a Smart Detective!
 * 
 * In the old days, if you found a mystery Animal, you had to ask:
 * "Are you a Dog?" -> Yes.
 * Then you had to forcefully put a Dog costume on it (Casting) before it could bark.
 * 
 * Now, the smart detective asks: "Are you a Dog? If yes, I will instantly call you 'myDog'!"
 */
class MysteryAnimal { }

class SmartDog extends MysteryAnimal {
    public void bark() {
        System.out.println("Woof! I am a smart dog!");
    }
}

class SmartCat extends MysteryAnimal {
    public void meow() {
        System.out.println("Meow! I am a smart cat!");
    }
}

public class PatternMatchingExample {
    public static void main(String[] args) {

        System.out.println("--- The Smart Detective ---");

        MysteryAnimal pet = new SmartDog();

        // 1. The OLD annoying way
        if (pet instanceof SmartDog) {
            SmartDog oldDog = (SmartDog) pet; // We had to write SmartDog TWICE!
            System.out.print("Old way: ");
            oldDog.bark();
        }

        // 2. The NEW Pattern Matching way!
        // It asks "Are you a SmartDog?", and if yes, it creates the variable 'newDog' instantly!
        if (pet instanceof SmartDog newDog) {
            System.out.print("New way: ");
            newDog.bark(); // We skip the casting step!
        }
        
        // This won't run because our pet is a Dog, not a Cat!
        if (pet instanceof SmartCat newCat) {
            newCat.meow();
        }

        /*
         * Expected Output:
         * --- The Smart Detective ---
         * Old way: Woof! I am a smart dog!
         * New way: Woof! I am a smart dog!
         */
    }
}