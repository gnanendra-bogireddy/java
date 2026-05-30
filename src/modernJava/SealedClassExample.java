package modernJava;

/**
 * Sealed Classes (Java 17) are like a VIP Club!
 * 
 * Imagine you have a club called "Vehicle". 
 * You only want Cars and Trucks inside. You do NOT want Bicycles.
 * 
 * A 'sealed' class lets the Bouncer (Java) know exactly who is allowed on the list!
 */

// "sealed" says: I am a club!
// "permits" says: ONLY the Car and Truck are allowed to extend me. No one else!
sealed class Vehicle permits Car, Truck {
    public void startEngine() {
        System.out.println("Vroom!");
    }
}

// Allowed friends MUST say if their own doors are sealed, non-sealed, or final.
// "final" means: "I am a Car, and NO ONE can copy me!"
final class Car extends Vehicle { }

// "non-sealed" means: "I am a Truck, and anyone is allowed to copy me!"
non-sealed class Truck extends Vehicle { }

// If we tried to do this, Java would throw us out!
// class Bicycle extends Vehicle { } // ERROR! Bicycle is not on the permits list!

public class SealedClassExample {
    public static void main(String[] args) {

        System.out.println("--- VIP Club ---");

        Car myCar = new Car();
        Truck myTruck = new Truck();

        System.out.print("Car says: ");
        myCar.startEngine();

        System.out.print("Truck says: ");
        myTruck.startEngine();

        /*
         * Expected Output:
         * --- VIP Club ---
         * Car says: Vroom!
         * Truck says: Vroom!
         */
    }
}