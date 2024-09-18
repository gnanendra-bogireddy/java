import java.util.*;

public class TreeSetExample {
    public static void main(String[] args) {
        // Create TreeSets
        TreeSet<String> naturalOrderSet = new TreeSet<>();
        TreeSet<String> reverseOrderSet = new TreeSet<>(Collections.reverseOrder());
        TreeSet<String> collectionSet = new TreeSet<>(Arrays.asList("apple", "banana", "cherry"));
        TreeSet<Integer> inttree = new TreeSet<>();

        inttree.add(23);
        inttree.add(33);
        inttree.add(43);
        inttree.add(53);
        inttree.add(63);
        //Return highest number as per given number
        System.out.println(inttree.floor(30));
        //Return least number as per given number
        System.out.println(inttree.ceiling(30));


        // Adding elements
        naturalOrderSet.add("date");
        naturalOrderSet.add("apple");
        naturalOrderSet.add("cherry");
        naturalOrderSet.add("banana");
        System.out.println(naturalOrderSet.ceiling("banana"));
        System.out.println("Natural Order Set: " + naturalOrderSet);

        // Removing an element
        naturalOrderSet.remove("banana");
        System.out.println("After removing 'banana': " + naturalOrderSet);

        // Checking if an element is present
        boolean hasApple = naturalOrderSet.contains("apple");
        System.out.println("Contains 'apple': " + hasApple);

        // Size and clearing
        int size = naturalOrderSet.size();
        System.out.println("Size of Natural Order Set: " + size);
        naturalOrderSet.clear();
        System.out.println("After clearing, set is empty: " + naturalOrderSet.isEmpty());

        // Navigable methods
        TreeSet<Integer> numbers = new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("Numbers Set: " + numbers);
        System.out.println("First element: " + numbers.first());
        System.out.println("Last element: " + numbers.last());
        System.out.println("Element lower than 3: " + numbers.lower(3));
        System.out.println("Element higher than 3: " + numbers.higher(3));
        System.out.println("Element floor of 3: " + numbers.floor(3));
        System.out.println("Element ceiling of 3: " + numbers.ceiling(3));

        // Subset operations
        NavigableSet<Integer> subSet = numbers.subSet(2, true, 4, true);
        System.out.println("SubSet from 2 (inclusive) to 4 (inclusive): " + subSet);
        NavigableSet<Integer> headSet = numbers.headSet(4, true);
        System.out.println("HeadSet up to 4 (inclusive): " + headSet);
        NavigableSet<Integer> tailSet = numbers.tailSet(3, false);
        System.out.println("TailSet from 3 (exclusive): " + tailSet);
    }
}
