package oop.abstraction;

public abstract class ShapeDemo {
    String color;

    // These are abstract methods (no bodies, implemented by subclasses)
    abstract double area();
    public abstract String toString();


    // Abstract classes CAN have constructors
    public ShapeDemo(String color) {
        System.out.println("Shape constructor called");
        this.color = color;
    }

    // This is to satisfy the two args constructor used inside rectangle class.
    public ShapeDemo() {
    }

    // This is a concrete method
    public String getColor() {
        return color;
    }
}

class CircleDemo extends ShapeDemo {
    double radius;

    public CircleDemo(String color, double radius) {
        super(color); // Calls the Shape constructor first!
        System.out.println("Circle constructor called");
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public String toString() {
        return "Circle color is " + super.getColor() + " and area is : " + area();
    }
}

class RectangleDemo extends ShapeDemo {
    double length;
    double width;

    public RectangleDemo(String color, double length, double width) {
        super(color); // Calls the Shape constructor first!
        System.out.println("Rectangle constructor called");
        this.length = length;
        this.width = width;
    }

    public RectangleDemo( double length, double width) {
        this.length = 45;
        this.width = 56;
    }

    @Override
    double area() {
        return length * width;
    }

    @Override
    public String toString() {
        return "Rectangle color is " + super.getColor() + " and area is : " + area();
    }
}

// FIXED: Removed 'public' so it can sit cleanly inside Shape.java
class Test {
    public static void main(String[] args) {
        System.out.println("--- Instantiating Circle ---");
        ShapeDemo s1 = new CircleDemo("Green", 2.2);

        System.out.println("\n--- Instantiating Rectangle ---");
        ShapeDemo s2 = new RectangleDemo( "Yellow", 3,4);

        System.out.println("\n--- Printing Objects ---");
        System.out.println(s1.toString());
        System.out.println(s2.toString());
    }
}