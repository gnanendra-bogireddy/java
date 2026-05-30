package generics;

/**
 * Generics are like a magic lunchbox!
 * 
 * Imagine you have a lunchbox. One day you want to put a Sandwich in it, 
 * the next day an Apple, and the next day a Juice Box.
 * 
 * Instead of making 3 different lunchboxes (one specifically for Sandwiches, one for Apples...), 
 * we make ONE "Generic" Lunchbox that can hold <Anything>!
 * 
 * The '<T>' stands for "Type". It means: "You tell me what Type of thing to hold, and I will hold it!"
 */

// Sometimes we want to be a little bit strict.
// "<T extends Parent>" means: "This lunchbox can only hold things that belong to the Parent family."
// You can't put a toy in the lunchbox, only food (Parent)!
public class GenericsDemo<T extends Parent> {

    T thingInside;

    public GenericsDemo(T thingInside) {
        this.thingInside = thingInside;
    }

    public void printWhatIsInside() {
        System.out.println("Inside the generic box: " + thingInside.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        
        System.out.println("--- Magic Boxes ---");
        
        // We tell the box to ONLY hold a ChildOne
        GenericsDemo<ChildOne> box1 = new GenericsDemo<>(new ChildOne());
        box1.printWhatIsInside(); 
        
        // We tell the box to ONLY hold a ChildTwo
        GenericsDemo<ChildTwo> box2 = new GenericsDemo<>(new ChildTwo());
        box2.printWhatIsInside();

        // If we tried this, Java would yell at us! 
        // ChildThree is NOT part of the Parent family.
        // GenericsDemo<ChildThree> box3 = new GenericsDemo<>(new ChildThree()); // ERROR!

        // Because we forced <T extends Parent>, we know FOR SURE that whatever is 
        // inside the box has the Parent's tools!
        box1.thingInside.parentTool(); 
        
        /*
         * Expected Output:
         * --- Magic Boxes ---
         * Inside the generic box: ChildOne
         * Inside the generic box: ChildTwo
         * The parent tool is working!
         */
    }

}

class Parent {
    public void parentTool() {
        System.out.println("The parent tool is working!");
    }
}

class ChildOne extends Parent {
    // I am part of the Parent family!
}

class ChildTwo extends Parent {
    // I am also part of the Parent family!
}

class ChildThree {
    // I am NOT part of the Parent family. I am an outsider!
}