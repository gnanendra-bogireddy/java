package oop.abstraction;

/**
 * Here is another example of a Shape!
 * 
 * Think of the Abstract Class as a Factory. 
 * The Factory knows it has to paint the toy (color) and build the toy (constructor),
 * but it doesn't know what SHAPE the toy is until the workers (Child classes) make it.
 */
public abstract class ShapeDemo {
    
    String color;

    // The factory says: "I don't know the math for area, YOU do it!"
    abstract double area();
    
    // The factory says: "I don't know what to call this toy, YOU name it!"
    public abstract String toString();


    // The Factory worker starts here first!
    public ShapeDemo(String color) {
        System.out.println("Factory: Mixing the " + color + " paint!");
        this.color = color;
    }

    public ShapeDemo() {
    }

    public String getColor() {
        return color;
    }
}

class CircleDemo extends ShapeDemo {
    double radius;

    public CircleDemo(String color, double radius) {
        // 'super(color)' calls the Factory (ShapeDemo) constructor first!
        super(color); 
        System.out.println("Worker: Building a round Circle!");
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public String toString() {
        return "Toy: Circle, Color: " + super.getColor() + ", Area: " + area();
    }
}

class RectangleDemo extends ShapeDemo {
    double length;
    double width;

    public RectangleDemo(String color, double length, double width) {
        super(color); 
        System.out.println("Worker: Building a boxy Rectangle!");
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return length * width;
    }

    @Override
    public String toString() {
        return "Toy: Rectangle, Color: " + super.getColor() + ", Area: " + area();
    }
}

class Test {
    public static void main(String[] args) {
        System.out.println("--- Ordering a Circle ---");
        ShapeDemo s1 = new CircleDemo("Green", 2.2);

        System.out.println("\n--- Ordering a Rectangle ---");
        ShapeDemo s2 = new RectangleDemo("Yellow", 3, 4);

        System.out.println("\n--- Looking at our Toys ---");
        System.out.println(s1.toString());
        System.out.println(s2.toString());
        
        /*
         * Expected Output:
         * --- Ordering a Circle ---
         * Factory: Mixing the Green paint!
         * Worker: Building a round Circle!
         * 
         * --- Ordering a Rectangle ---
         * Factory: Mixing the Yellow paint!
         * Worker: Building a boxy Rectangle!
         * 
         * --- Looking at our Toys ---
         * Toy: Circle, Color: Green, Area: 15.205308443374602
         * Toy: Rectangle, Color: Yellow, Area: 12.0
         */
    }
}