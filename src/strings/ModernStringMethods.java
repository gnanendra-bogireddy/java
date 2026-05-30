package strings;

/**
 * Modern String Methods (Java 11+) are super fun word tools!
 * 
 * Working with words used to be annoying, but Java added some awesome new tools 
 * to check, cut, and repeat words easily.
 */
public class ModernStringMethods {
    public static void main(String[] args) {

        System.out.println("--- Fun Word Tools ---");

        // 1. isBlank() (Java 11)
        // The Invisible Ink Checker!
        // .isEmpty() only checks if length is 0. 
        // .isBlank() is smarter! It checks if the paper just has invisible spaces.
        String emptyPaper = "   ";
        System.out.println("Is the paper empty length? " + emptyPaper.isEmpty()); // false
        System.out.println("Is the paper blank (just spaces)? " + emptyPaper.isBlank()); // true!

        // 2. repeat() (Java 11)
        // The Parrot! Tell it what to say, and how many times to repeat it.
        String parrot = "Echo! ".repeat(3);
        System.out.println("Parrot says: " + parrot);

        // 3. strip() (Java 11)
        // The Scissors! Cuts off all the messy invisible spaces at the start and end.
        // It is better and newer than the old .trim() method.
        String messyWord = "   Hello World!   ";
        System.out.println("Before scissors: '" + messyWord + "'");
        System.out.println("After scissors (.strip): '" + messyWord.strip() + "'");

        // 4. lines() (Java 11)
        // The Line Reader! It splits a big poem into separate sentences so you can count them.
        String poem = "Roses are red\nViolets are blue\nJava is fun\nAnd so are you!";
        long lineCount = poem.lines().count(); // Uses the magic Stream belt!
        System.out.println("My poem has " + lineCount + " lines.");

        /*
         * Expected Output:
         * --- Fun Word Tools ---
         * Is the paper empty length? false
         * Is the paper blank (just spaces)? true
         * Parrot says: Echo! Echo! Echo! 
         * Before scissors: '   Hello World!   '
         * After scissors (.strip): 'Hello World!'
         * My poem has 4 lines.
         */
    }
}