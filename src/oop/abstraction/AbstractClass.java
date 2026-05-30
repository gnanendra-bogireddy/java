package oop.abstraction;

/**
 * Abstraction is like giving someone a sketch of a drawing, but not coloring it in!
 * 
 * An Abstract Class is an unfinished blueprint. You CANNOT build a toy directly from it.
 * It says: "Any toy built from me MUST have these things, but you have to figure out how to do it!"
 */
public abstract class AbstractClass {

    // You CAN have normal variables
    String color;

    // A normal constructor (It runs when a Child class is built)
    public AbstractClass() {
        System.out.println("Abstract Sketch is ready!");
    }

    // THIS IS THE MAGIC! An abstract method.
    // Notice there are NO curly braces { }. Just a semicolon.
    // It's just a rule: "Whoever finishes this sketch MUST write this method!"
    abstract void finishTheDrawing();

    // You can also have fully finished normal methods in an abstract class.
    public void signName() {
        System.out.println("Signed by the artist.");
    }
}

// Now we make a Child class that FINISHES the drawing!
class FinishedDrawing extends AbstractClass {
    
    // We MUST write the code for finishTheDrawing(), otherwise Java gets mad!
    @Override
    void finishTheDrawing() {
        System.out.println("I am coloring in the sketch with crayons! The drawing is done!");
    }
    
    public static void main(String[] args) {
        // We CANNOT do this: 
        // AbstractClass sketch = new AbstractClass(); // Error! It's not finished!
        
        // We CAN do this:
        FinishedDrawing masterpiece = new FinishedDrawing();
        masterpiece.finishTheDrawing();
        masterpiece.signName();
        
        /*
         * Expected Output:
         * Abstract Sketch is ready!
         * I am coloring in the sketch with crayons! The drawing is done!
         * Signed by the artist.
         */
    }
}