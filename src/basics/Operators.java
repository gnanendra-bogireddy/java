package basics;

/**
 * Operators are like math symbols (+, -, *) but sometimes they do cool magic tricks!
 * We use them to change numbers or check if things are true.
 */
public class Operators {

    public static void main(String[] args) {
        
        // 1. Math Operators (Just like in school!)
        int apples = 10;
        int friends = 3;

        System.out.println("--- Math Time ---");
        System.out.println("Add: " + (apples + friends));       // Output: Add: 13
        System.out.println("Subtract: " + (apples - friends));  // Output: Subtract: 7
        System.out.println("Multiply: " + (apples * friends));  // Output: Multiply: 30
        
        // Division chops off the decimal! 10 divided by 3 is 3 (with 1 left over).
        System.out.println("Divide: " + (apples / friends));    // Output: Divide: 3
        
        // Modulus (%) is the "Leftover" machine! 
        // If I share 10 apples with 3 friends, everyone gets 3, and 1 is leftover.
        System.out.println("Leftovers (Modulus): " + (apples % friends)); // Output: Leftovers: 1


        // 2. Magic Quick Operators (++ and --)
        System.out.println("\n--- Magic Tricks ---");
        int score = 5;
        System.out.println("Original Score: " + score); // Output: 5
        
        score++; // This means "Add exactly 1". It's the same as score = score + 1;
        System.out.println("Score after ++ : " + score); // Output: 6
        
        score--; // This means "Subtract exactly 1".
        System.out.println("Score after -- : " + score); // Output: 5


        // 3. Comparison Operators (Asking Yes or No questions)
        System.out.println("\n--- Asking Questions ---");
        int myAge = 10;
        int brotherAge = 12;

        System.out.println("Am I older than brother? " + (myAge > brotherAge));   // Output: false
        System.out.println("Am I younger than brother? " + (myAge < brotherAge)); // Output: true
        // '==' asks "Are they exactly the same?" (We use two == because one = is for giving a value)
        System.out.println("Are we twins? " + (myAge == brotherAge));             // Output: false


        // 4. Logical Operators (Combining questions!)
        // && means "AND" (Both must be true)
        // || means "OR" (Only one needs to be true)
        // ! means "NOT" (Flips true to false, false to true)
        System.out.println("\n--- Combining Questions ---");
        boolean isSunny = true;
        boolean hasBike = false;

        System.out.println("Can I ride my bike in the sun? " + (isSunny && hasBike)); // Output: false (I don't have a bike!)
        System.out.println("Is it sunny OR do I have a bike? " + (isSunny || hasBike)); // Output: true (At least it's sunny!)
    }
}