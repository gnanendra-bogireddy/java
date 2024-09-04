package collections;

import java.util.*;

public class CollectionsClassExample {
    public static void main(String[] args) {

        // Creating a list
        // Declaring object of string type
        List<String> items = new ArrayList<>();

        // Adding elements (items) to the list
        items.add("Shoes");
        items.add("Toys");

        // Add one or more elements using static Collections class
        Collections.addAll(items, "Fruits", "Bat", "Ball");

        // Printing the list contents
        for (int i = 0; i < items.size(); i++) {
            System.out.print(items.get(i) + " ");
        }

        // Sorting according to default ordering
        // using sort() method
        Collections.sort(items);

        // Printing the elements
        for (int i = 0; i < items.size(); i++) {
            System.out.print(items.get(i) + " ");
        }

        System.out.println();

        // Sorting according to reverse ordering
        Collections.sort(items, Collections.reverseOrder());

        // Printing the reverse order
        for (int i = 0; i < items.size(); i++) {
            System.out.print(items.get(i) + " ");
        }

        // Creating a List
        // Declaring object of string type
        List<String> listItems = new ArrayList<>();

        // Adding elements to object
        // using add() method
        listItems.add("Shoes");
        listItems.add("Toys");
        listItems.add("Horse");
        listItems.add("Ball");
        listItems.add("Grapes");

        // Sort the List
        Collections.sort(listItems);

        // BinarySearch on the List
        System.out.println("The index of Horse is " + Collections.binarySearch(listItems, "Horse"));

        // BinarySearch on the List - If not present it will give you -ve result
        System.out.println("The index of Dog is " + Collections.binarySearch(listItems, "Dog"));

        // Create destination list
        List<String> destination_List = new ArrayList<>();

        // Add elements
        destination_List.add("Shoes");
        destination_List.add("Toys");
        destination_List.add("Horse");
        destination_List.add("Tiger");
        destination_List.add("Lion");

        // Print the elements
        System.out.println("The Original Destination list is ");

        for (int i = 0; i < destination_List.size(); i++) {
            System.out.print(destination_List.get(i) + " ");
        }
        System.out.println();

        // Create source list
        List<String> source_List = new ArrayList<>();

        // Add elements
        source_List.add("Bat");
        source_List.add("Frog");
        source_List.add("Lion");

        // Copy the elements from source to destination
        Collections.copy(destination_List, source_List);

        // Printing the modified list
        System.out.println("The Destination List After copying is ");

        for (int i = 0; i < destination_List.size(); i++) {
            System.out.print(destination_List.get(i) + " ");
        }

        try {

            // creating object of ArrayList<Character>
            List<Character> list = new ArrayList<Character>();

            // populate the list
            list.add('X');
            list.add('Y');

            // printing the list
            System.out.println("Initial list: " + list);

            // getting unmodifiable list
            // using unmodifiableList() method
            List<Character> immutablelist = Collections.unmodifiableList(list);

            // Adding element to new Collection
            System.out.println("\nTrying to modify" + " the unmodifiablelist");
            immutablelist.add('Z');
        } catch (UnsupportedOperationException e) {
            System.out.println("Exception thrown : " + e);
        }

        try {
            // creating object of List<String>
            List<String> vector = new ArrayList<String>();

            // populate the vector
            vector.add("A");
            vector.add("B");
            vector.add("C");
            vector.add("D");
            vector.add("E");

            // printing the vector before swap
            System.out.println("Before swap: " + vector);

            // swap the elements
            System.out.println("\nSwapping 0th and 4th element.");
            Collections.swap(vector, 0, 4);

            // printing the vector after swap
            System.out.println("\nAfter swap: " + vector);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("\nException thrown : " + e);
        }

        // Let us create a list with 4 items
        ArrayList<String> listTwo = new ArrayList<String>();
        listTwo.add("code");
        listTwo.add("code");
        listTwo.add("quiz");
        listTwo.add("code");

        // count the frequency of the word "code"
        System.out.println("The frequency of the word code is: " + Collections.frequency(listTwo, "code"));

        // count the frequency of the word "cod" - Object is not present in collections.
        System.out.println("The frequency of the word cod is: " + Collections.frequency(listTwo, "cod"));

        try {

            // creating object of LinkedList
            List<Integer> linkedList = new LinkedList<Integer>();

            // Adding element to Vector v
            linkedList.add(-1);
            linkedList.add(4);
            linkedList.add(-5);
            linkedList.add(1);

            // printing the max value
            // using max() method
            System.out.println("Max value is: " + Collections.max(linkedList));

            // using min() method
            System.out.println("Min value is: " + Collections.min(linkedList));
        } catch (ClassCastException e) {
            System.out.println("Exception thrown : " + e);
        } catch (NoSuchElementException e) {
            System.out.println("Exception thrown : " + e);
        }

        // Let us create a list of strings
        List<String> mylist = new ArrayList<String>();

        // Adding elements to the List
        // Custom input elements
        mylist.add("practice");
        mylist.add("code");
        mylist.add("quiz");
        mylist.add("geeksforgeeks");

        // Print all elements originally
        System.out.println("Original List : " + mylist);

        // Using reverse() method to
        // reverse the element order of mylist
        Collections.reverse(mylist);

        // Print all elements of list in reverse order
        // using reverse() method
        System.out.println("Modified List : " + mylist);

        // create a synchronized list - Thread safe
        List<String> synlist = Collections.synchronizedList(mylist);

        System.out.println(" Synchronized List : " + synlist);

        // Creating an empty ArrayList of string type
        ArrayList<String> shuffleList = new ArrayList<String>();

        // Adding custom input elements to list object
        shuffleList.add("code");
        shuffleList.add("quiz");
        shuffleList.add("geeksforgeeks");
        shuffleList.add("quiz");
        shuffleList.add("practice");
        shuffleList.add("qa");

        // Printing list before shuffling
        System.out.println("Original List : \n" + shuffleList);

        // Shuffling the list
        Collections.shuffle(shuffleList);

        // Printing list after shuffling
        System.out.println("\nShuffled List : \n" + shuffleList);

        // Shuffling the list by user defined shuffle value
        Collections.shuffle(shuffleList, new Random(3));

        // Printing list after shuffling
        System.out.println("\nShuffled List : \n" + shuffleList);

    }

}
