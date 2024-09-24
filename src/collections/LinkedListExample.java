package collections;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListExample {

    // LinkedList implements Doubly linked list internally.
    // Manipulation operations are fast in LinkedList compared to ArrayList.
    // Memory overhead is high compared to ArrayList because it stores previous element address also.
    // It has few methods pop(), peek(), poll(), descendingIterator(), addFirst(),
    // addLast() which are not present in ArrayList.
    // LinkedList is faster for adding and removing elements.
    public static void main(String[] args) {
        // Creating a LinkedList
        LinkedList<String> list = new LinkedList<String>();

        // Adding elements to the LinkedList using add() method
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");

        //Adding elements at specific index
        list.add(1, "New Two");

        // Printing the LinkedList
        System.out.println(list);

        // Fetch elements in reverse order by descendingIterator() method.
        Iterator<String> desiterator = list.descendingIterator();
        while (desiterator.hasNext()) {
            System.out.println(desiterator.next() + " ");
        }

        // Removes and returns first element by using pop() method.
        System.out.println("It will remove first Element(One) : " + list.pop());
        System.out.println("Printing list after using pop : " + list);

        // Returns first element by using element() method.
        System.out.println("It will return first Element(New Two) : " + list.element());
        System.out.println("Printing list after using element : " + list);

        // Returns first element by using peek() method.
        System.out.println("It will return first Element(New Two) : " + list.peek());
        System.out.println("Printing list after using peek : " + list);

        // Returns and Removes first element by using poll() method.
        System.out.println("It will remove first Element(New Two) : " + list.poll());
        System.out.println("Printing list after using poll : " + list);

        // Returns first element, last element by using peekFirst(), peekLast() method.
        System.out.println("It will return first and last Element : " + list.peekFirst() + " " + list.peekLast());
        System.out.println("Printing list after using peekFist() : " + list);

        // Returns and Removes first element, last element by using pollFirst(), pollLast() method.
        System.out.println("It will return and remove first, last Element : " + list.pollFirst() + " " + list.pollLast());
        System.out.println("Printing list after using pollFist(), pollLast() : " + list);

        // Returns first element, last element by using getFirst(), getLast() method.
        System.out.println("It will return first and last Element : " + list.getFirst() + " " + list.getLast());
        System.out.println("Printing list after using getFirst(), getLast() : " + list);

        // Adds elements at first, last by using offer(element), offerLast(element) method.
        System.out.println("It will return  boolean and add and first, last Element : " + list.offer("Last") + " " + list.offerFirst("First"));
        System.out.println("Printing list after using offer(), offerLast() : " + list);

        // Adds elements at first, last by using removeFirst(), removeLast() method.
        System.out.println("It will removes and returns first, last Element : " + list.removeFirst() + " " + list.removeLast());
        System.out.println("Printing list after using removeFirst(), removeLast() : " + list);

        list.push("New Element");
        System.out.println("Printing list after using push(element) : " + list);

    }
}
