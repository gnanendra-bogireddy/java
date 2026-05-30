package oop;

/**
 * A Class is like a blueprint (instruction manual) for building toys!
 * 
 * Imagine a blueprint for making a Toy Dog.
 * The blueprint says every Toy Dog must have a Name, a Breed, Age, and Color.
 * Once you have the blueprint, you can build as many Toy Dogs as you want!
 */
public class ClassExample {

    // These are the things every Toy Dog will have! (Instance Variables)
    String name;
    String breed;
    int age;
    String color;

    // This is the "Builder" (Constructor). 
    // When we want a new Toy Dog, we use this to tell it what it should look like.
    public ClassExample(String name, String breed, int age, String color) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.color = color;
    }

    // These are things we can ASK the Toy Dog (Methods)
    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }

    // This is a special method that tells the Toy Dog how to introduce itself.
    @Override
    public String toString() {
        return ("Woof! My name is " + this.getName() + ".\nMy breed, age and color are " 
                + this.getBreed() + ", " + this.getAge() + ", " + this.getColor());
    }

    public static void main(String[] args) {
        // We use the blueprint (ClassExample) to build an actual Toy Dog named Tuffy!
        ClassExample tuffy = new ClassExample("Tuffy", "Papillon", 5, "White");
        
        // Let's ask Tuffy to introduce himself!
        System.out.println(tuffy.toString());
        
        /*
         * Expected Output:
         * Woof! My name is Tuffy.
         * My breed, age and color are Papillon, 5, White
         */
    }
}