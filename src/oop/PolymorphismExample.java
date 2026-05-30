package oop;

/**
 * Polymorphism means "Many Forms".
 * It allows one action to be done in different ways!
 * 
 * 1. Method Overloading: Same spell name, but using different ingredients.
 * 2. Method Overriding: A child changing the rules of the parent.
 */
public class PolymorphismExample {

    // --- OVERLOADING (Same name, different ingredients) ---
    public void draw() {
        System.out.println("Drawing a dot.");
    }

    public void draw(int size) {
        System.out.println("Drawing a circle of size " + size);
    }

    public static void main(String[] args) {
        System.out.println("--- Method Overloading ---");
        PolymorphismExample artist = new PolymorphismExample();
        artist.draw();       // Calls the empty one
        artist.draw(10);     // Calls the one with a number!

        System.out.println("\n--- Method Overriding ---");
        Monster genericMonster = new Monster();
        genericMonster.makeNoise(); // Parent sound

        Monster dragon = new Dragon();
        dragon.makeNoise(); // Child changed the sound!
    }
}

// --- OVERRIDING (Changing the parent's rule) ---
class Monster {
    public void makeNoise() {
        System.out.println("Grrr! (Generic monster sound)");
    }
}

class Dragon extends Monster {
    @Override
    public void makeNoise() {
        System.out.println("ROARRRR! *breathes fire*");
    }
}