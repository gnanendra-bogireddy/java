package collections;

import java.util.*;

public class ArrayListExample {

    // ArrayList is a class which internally stores elements in Array,
    // Arraylist stores elements is continuous memory locations.
    // This has three constructors and Initial capacity is 10.
    // Element manipulation takes time in ArrayList and retrieving data takes less time.
    // ArrayList implements List interface.
    // It allows duplicate elements.
    public static void main(String[] args) {


        // We can pass any Collection type in ArrayList constructor.
        ArrayList<String> arrayList = new ArrayList<>(Collections.emptyList());
        arrayList.add("One");

        ArrayList<String> list = new ArrayList<>();

        // Adding elements to ArrayList by using add() method.
        // This adds element at last by default.
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.add("Banana");

        // Adding element at specified position by using add(index, element) method.
        list.add(2, "Grapes");
        System.out.println("List elements are : " + list);

        // Finding elements by indexOf method. It will return int.
        // It returns first position of element. if not found returns -1.
        int index = list.indexOf("Apple");
        System.out.println("Index of First Apple: " + index); // Prints 0

        // Returns last index of specified element.
        // It returns last position of element. if not found returns -1.
        int lastIndex = list.lastIndexOf("Banana");
        System.out.println("Last Index of Banana: " + lastIndex); // Prints 4

        // Accessing elements by using get() method.
        System.out.println("Element at index 1: " + list.get(1)); // Output: Banana

        // Removing elements in List. Returns boolean if present returns true.
        list.remove("Banana");

        // Removing elements in List by Index. Returns boolean if present returns true.
        list.remove(2);
        list.add("Cherry");

        // If we want to remove all elements in specified list use removeAll() method.
        List<String> removeList = new ArrayList<>();
        removeList.add("Apple");
        removeList.add("Cherry");
        list.removeAll(removeList);
        System.out.println("Printing list after using removeAll() : " + list);

        // Iterating over list elements by using for loop.
        for (String fruit : list) {
            System.out.print(fruit + " ");
        }

        // We can prepare SubList from main list by using subList(start, end) method.
        List<String> subList = list.subList(0, 1);
        System.out.println("Sublist: " + subList); // Output: [Apple]

        // Modifying elements in a particular index by using set(index, element).
        list.set(1, "Blueberry");
        System.out.println("Fist index element: " + list.get(1));
        System.out.println("Printing List after calling set() method : " + list);

        // Checking size of list by size() method. Returns int value.
        System.out.println("Size of list: " + list.size()); // Output: int

        // Removing all elements from list.
        list.clear();
        System.out.println("List after clearing: " + list); // Output: []
        System.out.println("List size clearing: " + list.size()); // Output: 0

        // Checking emptiness by using isEmpty() method.
        System.out.println("List is empty: " + list.isEmpty()); // Output: true

        // printing elements by using ListIterator
        ArrayList<String> newList = new ArrayList<>();
        newList.add("B");
        newList.add("C");
        newList.add("A");

        ListIterator<String> listIterator = newList.listIterator();
        while (listIterator.hasNext()) {
            System.out.println("Next element: " + listIterator.next());
        }

        while (listIterator.hasPrevious()) {
            System.out.println("Previous element: " + listIterator.previous());
        }

        // printing elements by using Iterator
        // It can not travel back unlike ListIterator.
        Iterator<String> iterator = newList.iterator();
        while (iterator.hasNext()) {
            System.out.println("Next element: " + iterator.next());
        }

        // Replaces all Upper case Strings to Lower case.
        newList.replaceAll(String::toLowerCase);
        System.out.println("Strings after replacement to lower case: " + newList.get(0));

        // Converting ArrayList to Array by using toArray() method.
        Object[] array = newList.toArray();
        System.out.println("First element in array : " + array[0]);

        // converting ArrayList to array by adding another array.
        Object[] arrOne = {"D", "F", "E"};
        Object[] arr = newList.toArray(arrOne);
        System.out.println("Third element in array : " + arr[2]);

        // To find specific element is present in ArrayList.
        // returns boolean value.
        System.out.println(newList.contains("D"));

        // To find specific collection is present in ArrayList.
        // returns boolean value.
        List<String> findList = new ArrayList<>();
        findList.add("D");
        findList.add("E");
        System.out.println(newList.containsAll(findList));

        // Sorting list by using sort() method.
        newList.sort(Comparator.naturalOrder());
        System.out.println("Printing new List Elements in Ascending order : " + newList);

        newList.sort(Comparator.reverseOrder());
        System.out.println("Printing new List Elements in Reverse order : " + newList);

        // addAll() method adds given list to existing list.
        List<String> addList = new ArrayList<>();
        addList.add("X");
        addList.add("Y");
        addList.add("Z");
        newList.addAll(addList);
        newList.remove("Z");

        System.out.println("Printing list elements : " + newList);

        // Retains only elements present inside given list.
        newList.retainAll(addList);
        System.out.println("Printing list elements after retaining only few elements : " + newList);

    }
}
