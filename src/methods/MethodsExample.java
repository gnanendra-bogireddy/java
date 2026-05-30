package methods;

/**
 * Methods are like magic spells!
 * 
 * Instead of doing a chore yourself, you cast a spell (call a method) to do the work for you.
 * If you need to do the chore 10 times, you just cast the spell 10 times instead of writing
 * the instructions over and over again!
 */
public class MethodsExample {

    // 1. How to create a spell (Method):
    // returnType methodName(parameters) {
    //     // What the spell does!
    // }

    // 'void' means this spell doesn't give us anything back. It just does an action.
    public void sayHelloSpell() {
        System.out.println("Hello, young wizard!");
    }

    // This spell takes an 'ingredient' (a parameter) to work!
    public void castFireball(int powerLevel) {
        System.out.println("Casting a fireball with power level: " + powerLevel + "!!! BOOM!");
    }

    public static void main(String[] args) {

        // 2. First, we need to create our wizard (an object of our class)
        // so we can use the spells.
        MethodsExample wizard = new MethodsExample();

        System.out.println("--- Magic Time ---");
        
        // 3. Calling the method (Casting the spell!)
        wizard.sayHelloSpell();
        
        // Casting the spell with an ingredient (power level 5)
        wizard.castFireball(5);
        
        // Casting it again with more power!
        wizard.castFireball(100);
        
        /*
         * Expected Output:
         * --- Magic Time ---
         * Hello, young wizard!
         * Casting a fireball with power level: 5!!! BOOM!
         * Casting a fireball with power level: 100!!! BOOM!
         */
    }
}