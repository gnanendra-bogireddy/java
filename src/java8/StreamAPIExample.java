package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The Stream API is like a magic conveyor belt!
 * 
 * Instead of using a 'for' loop to check every single toy in a box manually,
 * you put the box on the conveyor belt. 
 * The belt can filter (throw away broken toys), map (paint the toys), 
 * and collect (put the finished toys in a new box) all in one go!
 */
public class StreamAPIExample {
    public static void main(String[] args) {
        
        List<String> toyBox = new ArrayList<>();
        toyBox.add("Red Car");
        toyBox.add("Blue Car");
        toyBox.add("Broken Robot");
        toyBox.add("Red Yo-Yo");

        System.out.println("Original Box: " + toyBox);

        // Put them on the magic conveyor belt (stream)
        List<String> shinyRedToys = toyBox.stream()
            // FILTER: The bouncer! Only let toys with "Red" pass through. 
            // (Broken Robot and Blue Car are thrown out).
            .filter(toy -> toy.contains("Red"))
            
            // MAP: The painter! Add the word "Shiny" to whatever passed the filter.
            .map(toy -> "Shiny " + toy)
            
            // COLLECT: Put the surviving, painted toys into a brand new box!
            .collect(Collectors.toList());

        System.out.println("New Box: " + shinyRedToys);
        // Output: New Box: [Shiny Red Car, Shiny Red Yo-Yo]
    }
}