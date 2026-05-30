package java8;

import java.util.Optional;

/**
 * Optional is like a Mystery Gift Box!
 * 
 * In the old days, if a box was empty (null) and you tried to play with the toy inside,
 * the program would crash (NullPointerException).
 * 
 * An 'Optional' box safely tells you: "Hey, I might have a toy, or I might be empty. Check first!"
 */
public class OptionalExample {
    public static void main(String[] args) {

        // 1. A box that we KNOW has a toy inside
        Optional<String> fullBox = Optional.of("Action Figure");
        
        // 2. A box that we KNOW is empty
        Optional<String> emptyBox = Optional.empty();

        System.out.println("--- Checking the Full Box ---");
        // isPresent() asks: "Is there a toy inside?"
        if (fullBox.isPresent()) {
            // get() opens the box and takes the toy out
            System.out.println("Yay! I got a: " + fullBox.get()); 
        }

        System.out.println("\n--- Checking the Empty Box ---");
        // ifPresentOrElse tells Java what to do if it's full, AND what to do if it's empty!
        emptyBox.ifPresentOrElse(
            toy -> System.out.println("I got a: " + toy),
            () -> System.out.println("Aww man, the box was empty.")
        );
        
        // orElse() is a backup plan. "Give me the toy, but if it's empty, give me a Rock instead."
        String backupToy = emptyBox.orElse("A boring rock");
        System.out.println("I walked away with: " + backupToy);
    }
}