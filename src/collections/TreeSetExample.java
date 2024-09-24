package collections;

import java.sql.SQLOutput;
import java.util.*;

public class TreeSetExample {
    // TreeSet is one of the most important implementations of the SortedSet interface in Java
    // that uses a Tree for storage. The ordering of the elements is maintained by a set using
    // their natural ordering whether an explicit comparator is provided
    // treeSet serves as an excellent choice for storing large amounts of sorted information which are supposed
    // to be accessed quickly because of its faster access and retrieval time.
    // We can not add null values in Tree Set it will result in NullPointer Exception.
    // TreeSet is basically an implementation of a self-balancing binary search tree.

    public static void main(String[] args) {

        // Create a TreeSet of Strings
        // We can provide Comparator in the beginning of set creation.
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("A");
        treeSet.add("Z");
        treeSet.add("X");
        treeSet.add("B");
        treeSet.add("C");
        treeSet.add("L");

        // Displaying the TreeSet (which is empty at this point)
        System.out.println("TreeSet elements: " + treeSet);

        // Size of the TreeSet
        System.out.println("Size of the TreeSet is : " + treeSet.size());

        // Checking for element is present in TreeSet or not
        System.out.println("Tree Set search for element : " + treeSet.contains("Z"));

        // Removing element from TreeSet
        System.out.println("Removing 'A' from TreeSet : " + treeSet.remove("A"));
        System.out.println("Printing TreeSet after removing element : " + treeSet);

        Object[] array = treeSet.toArray();
        System.out.println("Printing element after converting to Array : " + array[0].toString());

        // Removing all elements from TreeSet
        treeSet.clear();

        // Printing size of TreeSet by using size() method.
        System.out.println("Size of TreeSet is : " + treeSet.size());

        TreeSet<Integer> intSet = new TreeSet<>();
        intSet.add(10);
        intSet.add(15);
        intSet.add(9);
        intSet.add(3);
        intSet.add(30);
        intSet.add(4);

        // Printing TreeSet elements by using iterator.
        Iterator<Integer> iterator = intSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Getting First Element of TreeSet
        System.out.println("First element of TreeSet is : " + intSet.first());

        // Getting Last Element of TreeSet
        System.out.println("Last element of TreeSet is : " + intSet.last());

        // Getting and Removing First Element of TreeSet
        System.out.println("Polling First element of TreeSet is : " + intSet.pollFirst());
        System.out.println("Printing TreeSet after polling : " + intSet);

        // Getting and Removing Last Element of TreeSet
        System.out.println("Polling Last element of TreeSet is : " + intSet.pollLast());
        System.out.println("Printing TreeSet after polling : " + intSet);

        //  Returns the least element in this set strictly greater than the given element null if not present.
        System.out.println("Printing Higher element than given element is : " + intSet.higher(10));

        //  Returns the least element in this set strictly less than the given element null if not present.
        System.out.println("Printing Lower element than given element is : " + intSet.lower(9));

        //  Returns the least element in this set strictly greater than or equal to the given element null if not present.
        System.out.println("Printing Ceiling element than given element is : " + intSet.ceiling(10));

        //  Returns the least element in this set strictly less or equal to the given element null if not present.
        System.out.println("Printing Floor element than given element is : " + intSet.floor(9));

        System.out.println("Printing elements in descending order : ");
        Iterator<Integer> integerIterator = intSet.descendingIterator();
        while (integerIterator.hasNext()) {
            System.out.println(integerIterator.next());
        }
        System.out.println(intSet);
        SortedSet<Integer> partialSet = intSet.subSet(0, 15);
        System.out.println("Printing SubSet elements are : " + partialSet);

        // getting elements till index of the set
        System.out.println("Printing elements till element from first index : " + intSet.headSet(10, false));

        // getting elements from index to the last element of the set
        System.out.println("Printing elements from index to last element : " + intSet.tailSet(10));
    }
}
