package basics;

/**
 * Loops are a way to make the computer do something over and over again 
 * so you don't have to write the same code 100 times!
 * 
 * Think of it like a teacher telling you to "Write your name 5 times on the board."
 */
public class Loops {
    public static void main(String[] args) {

        // 1. The 'for' loop
        // Best when you know EXACTLY how many times you want to do something.
        // (Start at 1; keep going as long as i is less than or equal to 3; add 1 each time)
        System.out.print("Counting to 3: ");
        for (int i = 1; i <= 3; i++) {
            System.out.print(i + " ");
        }
        System.out.println(); 
        // Output: Counting to 3: 1 2 3 

        // 2. The 'enhanced for' loop (also called for-each)
        // Best for looking inside a toy box (array) and playing with every single toy, one by one.
        String[] toyBox = {"Car", "Robot", "Dinosaur"};
        System.out.print("Toys in my box: ");
        for (String toy : toyBox) {
            System.out.print(toy + " ");
        }
        System.out.println();
        // Output: Toys in my box: Car Robot Dinosaur 

        // 3. The 'while' loop
        // Best when you don't know how many times, but you want to keep going WHILE something is true.
        // Like "Keep eating candy WHILE there is still candy in the bowl."
        System.out.print("Eating candies: ");
        int candies = 1;
        while (candies <= 3) {
            System.out.print("Yum" + candies + " ");
            candies++; // Eat one!
        }
        System.out.println();
        // Output: Eating candies: Yum1 Yum2 Yum3 

        // 4. The 'do-while' loop
        // This is just like the while loop, but you DO it at least ONCE before checking the rules.
        // Like "Eat a cookie first, then check if mom is watching."
        System.out.print("Eating cookies: ");
        int cookies = 1;
        do {
            System.out.print("Chomp" + cookies + " ");
            cookies++;
        } while (cookies <= 3);
        System.out.println();
        // Output: Eating cookies: Chomp1 Chomp2 Chomp3 


        // --- Magic Loop Words: Break and Continue ---
        
        // CONTINUE means "Skip this one and go to the next!" 
        // Like eating vegetables: "If it's broccoli (2), skip it! Otherwise, eat it."
        System.out.print("Skipping number 2: ");
        for (int j = 1; j <= 4; j++) {
            if (j == 2) {
                continue; // Skip 2!
            }
            System.out.print(j + " ");
        }
        System.out.println();
        // Output: Skipping number 2: 1 3 4 

        // BREAK means "STOP EVERYTHING AND GET OUT!" 
        // Like playing outside: "If mom calls me (number 3), stop playing and go inside."
        System.out.print("Stopping at 3: ");
        for (int k = 1; k <= 5; k++) {
            if (k == 3) {
                break; // Stop completely!
            }
            System.out.print(k + " ");
        }
        System.out.println();
        // Output: Stopping at 3: 1 2 
    }
}