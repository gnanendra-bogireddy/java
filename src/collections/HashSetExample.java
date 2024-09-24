package collections;

import java.util.*;

public class HashSetExample {

    // HashSet does not guarantee insertion order. Elements will be arranged based on Hash values.
    // Does allow NULL values and not allows duplicate values.
    // It implements Set interface.Uses Hashing to store elements internally
    // It uses HashMap internally to add and remove elements internally.

    public static void main(String[] args) {

        // Creating object of Set of type String
        HashSet<String> hs = new HashSet<>();

        // Adding elements into the HashSet
        // using add() method
        // Custom input elements
        hs.add("India");
        hs.add("Australia");
        hs.add("South Africa");
        hs.add("United States");
        hs.add("England");
        hs.add("France");
        hs.add("China");

        // Adding the duplicate element
        System.out.println("Allows duplicate elements or not ? " + hs.add("India"));

        // Displaying the HashSet
        System.out.println(hs);

        // Removing items from HashSet
        // using remove() method
        hs.remove("Australia");
        System.out.println("Set after removing " + "Australia : " + hs);

        Set<String> set = new HashSet<>();
        set.add("India");
        set.add("Australia");

        // removeAll() removes all the elements passed to HashSet method.
        hs.removeAll(set);
        System.out.println("After calling removeAll() : " + hs);

        // Iterating over hash set items
        System.out.println("Iterating over set:");

        // Iterating through iterators
        Iterator<String> iterator = hs.iterator();

        // It holds true till there is a single element
        // remaining in the object
        while (iterator.hasNext()) System.out.println(iterator.next());

        // Check whether Set is empty or not by using isEmpty()
        System.out.println("Checking whether Set is empty or not : " + hs.isEmpty());

        //Size of the Set is by using size() method.
        System.out.println("Size of the Set is : " + set.size());

        // Removing all elements from set by using clear()
        set.clear();
        System.out.println("Size of the Set after removing all the elements : " + set.size());

        // Checking whether Set has given value or not
        System.out.println("Checking whether set has given value : " + hs.contains("France"));

        Set<String> containsAll = new HashSet<>();
        containsAll.add("United States");
        containsAll.add("India");
        containsAll.add("China");
        containsAll.add("Brazil");
        containsAll.add("US");

        System.out.println("Checking whether the elements are present in Set or not ? " + hs.containsAll(containsAll));


        // Converting HashSet to Array
        Object[] array = hs.toArray();
        System.out.println("Converting HashSet to Array : " + array[0]);

        // Converting HashSet to Array while adding another array.
        String[] arr = {"US", "UK", "IND"};
        String[] arr1 = hs.toArray(arr);
        System.out.println("Converting Hash Set to Array while adding another Array : " + arr1[3]);

        // Retaining elements present another collection in Main Hash Set
        Set<String> retainAll = new HashSet<>();
        retainAll.add("Brazil");
        retainAll.add("US");
        retainAll.add("IND");

        containsAll.retainAll(retainAll);
        System.out.println("Printing Hash Set after calling retainAll() method : " + containsAll);

    }
}
