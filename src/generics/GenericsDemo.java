package generics;

/**
 * Generics are like a magic lunchbox that can hold different types of food!
 * 
 * Instead of making a separate lunchbox for Sandwiches, one for Apples, and one for Cookies, 
 * we make ONE "Generic" Lunchbox that can hold <Anything>!
 * 
 * Key terms:
 * 1. <T> - This is a Type Parameter. 'T' is just a placeholder (like 'x' in math).
 * 2. Type Safety - Java checks to make sure you only put the right "food" in the box.
 * 3. Reusability - You write the code once, and it works for many types!
 */
public class GenericsDemo {

    public static void main(String[] args) {

        System.out.println("--- 1. Simple Generic Box ---");
        // We tell the box to hold a String
        Box<String> stringBox = new Box<>("My Secret Note");
        System.out.println("String Box contains: " + stringBox.getContent());

        // We tell the same Box class to hold an Integer
        Box<Integer> integerBox = new Box<>(100);
        System.out.println("Integer Box contains: " + integerBox.getContent());


        System.out.println("\n--- 2. Bounded Generic Box (Restricted) ---");
        // This box ONLY accepts things that belong to the 'Parent' family.
        // It's like saying "This box only holds Fruit, not Toys."
        BoundedBox<ChildOne> fruitBox = new BoundedBox<>(new ChildOne());
        fruitBox.printInfo();

        BoundedBox<ChildTwo> anotherFruitBox = new BoundedBox<>(new ChildTwo());
        anotherFruitBox.printInfo();

        // If we tried: BoundedBox<Outsider> box = new BoundedBox<>(new Outsider());
        // Java would give an ERROR because Outsider does not extend Parent!

        /*
         * Expected Output:
         * --- 1. Simple Generic Box ---
         * String Box contains: My Secret Note
         * Integer Box contains: 100
         * 
         * --- 2. Bounded Generic Box (Restricted) ---
         * Inside the box: ChildOne
         * Inside the box: ChildTwo
         */
    }
}

// 1. A Simple Generic Class
// T is the placeholder for the type we will decide later
class Box<T> {
    private T content;

    public Box(T content) {
        this.content = content;
    }

    public T getContent() {
        return content;
    }
}

// 2. A Bounded Generic Class
// T must be a Parent or a subclass of Parent
class BoundedBox<T extends Parent> {
    private T item;

    public BoundedBox(T item) {
        this.item = item;
    }

    public void printInfo() {
        System.out.println("Inside the box: " + item.getClass().getSimpleName());
        item.useTool();
    }
}

// Supporting classes for the Bounded Example
class Parent {
    public void useTool() {
        // Parent has a basic tool
    }
}

class ChildOne extends Parent { }
class ChildTwo extends Parent { }
class Outsider { }
