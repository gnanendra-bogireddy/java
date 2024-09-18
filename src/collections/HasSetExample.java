package collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class HasSetExample {
    public static void main(String[] args) {

        // Instantiate an object of HashSet
        // Has Set does not allow duplicate values and does not respect insertion order.
        // Uses Hashing to store elements internally.
        HashSet<ArrayList> set = new HashSet<>();

        // create ArrayList list1
        ArrayList<Integer> list1 = new ArrayList<>();

        // create ArrayList list2
        ArrayList<Integer> list2 = new ArrayList<>();

        // Add elements using add method
        list1.add(1);
        list1.add(2);
        list2.add(1);
        list2.add(2);
        set.add(list1);
        set.add(list2);

        // print the set size to understand the
        // internal storage of ArrayList in Set
        // Two arrays are equal so Set stores only first element.
        System.out.println(set.size());

        // We can convert Collection into Has Set
        Collection<String> collection = new ArrayList<>();
        collection.add("Mango");
        collection.add("Apple");
        collection.add("Grape");
        collection.add("Banana");
        System.out.println("Printing collection : " + collection);
        HashSet<String> collectionSet = new HashSet<>(collection);

        System.out.println("Converting collection into Has Set : " + collectionSet);

        // Displaying the HashSet using contains() method.
        System.out.println("List contains Apple or not:" + collectionSet.contains("Apple"));

        // Removing items from HashSet
        // using remove() method
        collectionSet.remove("Banana");
        System.out.println("List after removing Banana:" + collectionSet);

        // Display message
        System.out.println("Iterating over list:");

        // Iterating over hashSet items
        Iterator<String> iterator = collectionSet.iterator();

        // Holds true till there is single element remaining
        while (iterator.hasNext()) {

            // Iterating over elements
            // using next() method
            System.out.println(iterator.next());
        }

        // Converts Set elements to Array.
        Object[] arr = collectionSet.toArray();

        // Clears the Hash Set
        set.clear();

        // Returns the set is empty or not
        System.out.println("Checking whether Set is empty or not : " + collectionSet.isEmpty());

    }
}
