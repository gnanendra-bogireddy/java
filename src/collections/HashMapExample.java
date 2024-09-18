package collections;

import java.util.*;

public class HashMapExample {
    public static void main(String[] args) {
        // Create a Map using HashMap
        Map<String, Integer> map = new HashMap<>();

        // Inserting elements in Hash Map
        // using put() method
        map.put("vishal", 10);
        map.put("sachin", 30);
        map.put("vaibhav", 20);

        // Traversing through Map using for-each loop
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            // Printing key-value pairs
            System.out.println(e.getKey() + " " + e.getValue());
        }

        // Displaying the Map
        System.out.println("Map elements: " + map);

        // Removing element from Hash map by using remove() method.
        map.remove("sachin");
        // Removes element if both key and value matches with given input.
        map.remove("vaibhav", 20);

        System.out.println("Map elements: " + map);

        // This method is used when Key is unique.
        map.putIfAbsent("Kohli", 100);
        System.out.println("Map elements: " + map);

        // Clearing the map using clear()
        map.clear();
        map.put("Kohli", 100);

        // Displaying the final HashMap
        System.out.println("Finally the maps look like this: " + map);

        // Checking for the key_element 'Kohli'
        System.out.println("Is the key 'Kohli' present? " + map.containsKey("Kohli"));

        // Checking for the Value '100'
        System.out.println("Is the value '100' present? " + map.containsValue(100));

        // Using entrySet() to get the set view
        System.out.println("The set is: " + map.entrySet());

        // Getting the value of "Kohli"
        System.out.println("The Value is: " + map.get("Kohli"));

        // Initializing a Map of type HashMap
        Map<String, String> newMap = new HashMap<>();

        System.out.println(newMap);

        System.out.println(newMap.isEmpty());

        newMap.put("King", "Queen");
        newMap.put("Kingdom", "Palace");
        newMap.put("Crown", "-Chair");

        Set<String> set = new HashSet<>();
        set = newMap.keySet();
        System.out.println(set);

        Map<String, String> maps = new HashMap<>();
        maps.put("1", "One");
        maps.put("3", "Three");
        maps.put("5", "Five");
        maps.put("7", "Seven");
        maps.put("9", "Nine");

        newMap.putAll(maps);

        System.out.println("New Hashmap is : " + newMap);

        // getOrDefault() will provide default value if key is not present.
        System.out.println(newMap.getOrDefault("100", "Default Value"));

        // If we want to get values of Hashmap we can use values() method.
        Collection<String> collection = newMap.values();

        System.out.println("Collection elements are : " + collection);

        // Size of the map
        System.out.println("Size of the map is : " + newMap.size());

        // Remove the key from map - It removes both key and value matches.
        newMap.remove("9", "Nine");

        for(Map.Entry<String,String> mapsw : maps.entrySet()) {
            mapsw.getKey();
            mapsw.getValue();
        }

    }

}
