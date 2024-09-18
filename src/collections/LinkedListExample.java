package collections;

import java.util.LinkedList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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

        // Removing elements by using pop() method.
        list.pop();


    }
}
