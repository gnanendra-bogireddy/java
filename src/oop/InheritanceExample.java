package oop;

/**
 * Inheritance is like passing down traits from parents!
 * 
 * If a generic "Animal" knows how to sleep and eat, a "Dog" doesn't need
 * to re-learn how to sleep and eat. It just "inherits" (copies) those abilities 
 * from the Animal, and then adds its own special trick (barking)!
 */
class Animal {
    public void sleep() {
        System.out.println("Zzzzz... (Sleeping)");
    }
}

// "extends" means Dog is inheriting from Animal
class Dog extends Animal {
    public void bark() {
        System.out.println("Woof! Woof!");
    }
}

public class InheritanceExample {
    public static void main(String[] args) {
        Dog myPuppy = new Dog();
        
        // The dog can bark (its own trick)
        myPuppy.bark();
        
        // The dog can ALSO sleep (inherited from Animal) without us writing the code inside Dog!
        myPuppy.sleep(); 
    }
}