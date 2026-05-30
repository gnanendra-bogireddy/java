package oop.abstraction;

/**
 * Here is a great example of Abstraction in the real world!
 * 
 * Imagine the word "Shape". A "Shape" is an idea. You can't just draw a "Shape". 
 * You have to draw a specific shape, like a Circle or a Rectangle.
 */

// 1. The Abstract Idea (The Boss)
abstract class Shape {
    
    // The Boss says: "Every shape MUST be able to tell me how big it is (Area)!"
    // But the Boss doesn't know how to calculate it, so it's abstract.
    public abstract double getArea();
}

// 2. The Specific Shape (The Worker)
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    // The Worker actually does the math!
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

// 3. Another Specific Shape
class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // This Worker does different math!
    @Override
    public double getArea() {
        return width * height;
    }
}

public class Main {
    public static void main(String[] args) {
        
        // We make a Circle and a Rectangle
        Circle myCircle = new Circle(5);
        Rectangle myRectangle = new Rectangle(10, 20);

        System.out.println("Let's ask the shapes how big they are!");
        
        // They both have the same method name, but they do different math inside!
        System.out.println("Circle area: " + myCircle.getArea());
        System.out.println("Rectangle area: " + myRectangle.getArea());
        
        /*
         * Expected Output:
         * Let's ask the shapes how big they are!
         * Circle area: 78.53981633974483
         * Rectangle area: 200.0
         */
    }
}