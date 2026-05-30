package collections;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Modern Collections (Java 9+) make packing your lunchbox super fast!
 * 
 * In the old days, making a List took many lines of code (box.add(1), box.add(2)).
 * Now, you can use `.of()` to pack the box instantly in ONE line!
 * 
 * WARNING: These modern boxes are "Immutable" (frozen). 
 * Once you pack them using `.of()`, you CANNOT add or remove anything!
 */
public class ModernCollections {
    public static void main(String[] args) {

        System.out.println("--- Fast Packing! ---");

        // 1. A super fast List
        List<String> fastList = List.of("Apple", "Banana", "Cherry");
        System.out.println("Fast List: " + fastList);

        // 2. A super fast Set (Remember, Sets don't allow duplicates!)
        Set<Integer> fastSet = Set.of(1, 2, 3, 4, 5);
        System.out.println("Fast Set: " + fastSet);

        // 3. A super fast Map (Key, Value, Key, Value...)
        Map<Integer, String> fastMap = Map.of(
            1, "First Place", 
            2, "Second Place"
        );
        System.out.println("Fast Map: " + fastMap);

        System.out.println("\n--- The Frozen Rule! ---");
        
        try {
            // Trying to add a "Donut" to our frozen List...
            fastList.add("Donut"); 
        } catch (UnsupportedOperationException e) {
            System.out.println("Uh oh! You caught an error! You can't add to a .of() list!");
        }

        /*
         * Expected Output:
         * --- Fast Packing! ---
         * Fast List: [Apple, Banana, Cherry]
         * Fast Set: [1, 2, 3, 4, 5] (Order might scramble)
         * Fast Map: {1=First Place, 2=Second Place}
         * 
         * --- The Frozen Rule! ---
         * Uh oh! You caught an error! You can't add to a .of() list!
         */
    }
}