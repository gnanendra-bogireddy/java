package modernJava;

/**
 * Records (Java 16) are like a Magic ID Card!
 * 
 * If you just want to store data (like a Player's Name and Score),
 * the old way took 50 lines of code! You had to write a Constructor, Getters, Setters, toString(), etc.
 * 
 * A 'Record' writes ALL of that boring code for you in ONE line!
 * It is completely "Immutable" (once the ID card is printed, you cannot change the info).
 */

// BOOM! In one line, Java builds the constructor, getName(), getScore(), and toString()!
record PlayerIDCard(String name, int score) { 
    // You can even add a tiny rule while making the card!
    public PlayerIDCard {
        if (score < 0) {
            System.out.println("Error: Score cannot be negative! Fixing it to 0.");
            score = 0;
        }
    }
}

public class RecordExample {
    public static void main(String[] args) {

        System.out.println("--- Printing ID Cards ---");

        // 1. Create a player using our magic record
        PlayerIDCard player1 = new PlayerIDCard("Hero123", 500);
        
        // Let's try to break the rule!
        PlayerIDCard player2 = new PlayerIDCard("Villain99", -50); 

        // 2. We can automatically print them because toString() is already made!
        System.out.println(player1);
        System.out.println(player2);

        // 3. We use .name() instead of .getName() to read the info.
        System.out.println("\nThe winner is: " + player1.name() + " with " + player1.score() + " points!");

        // player1.score = 1000; // ERROR! You can't change an ID card once it's printed!

        /*
         * Expected Output:
         * --- Printing ID Cards ---
         * Error: Score cannot be negative! Fixing it to 0.
         * PlayerIDCard[name=Hero123, score=500]
         * PlayerIDCard[name=Villain99, score=0]
         * 
         * The winner is: Hero123 with 500 points!
         */
    }
}