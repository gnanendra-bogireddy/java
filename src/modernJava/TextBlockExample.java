package modernJava;

/**
 * Text Blocks (Java 15) are like a big piece of drawing paper!
 * 
 * Before, writing a long story or an email template in Java was super messy. 
 * You had to use "\n" to make a new line, and "+" to glue pieces together.
 * 
 * Now, you just use THREE quotes (""") to open the paper, write normally, 
 * and THREE quotes (""") to close it!
 */
public class TextBlockExample {
    public static void main(String[] args) {

        System.out.println("--- The Old Messy Way ---");
        String oldWay = "Dear Mom,\n" +
                        "I am having fun at camp.\n" +
                        "Send more cookies!\n" +
                        "Love, Me";
        System.out.println(oldWay);

        System.out.println("\n--- The Cool New Text Block Way ---");
        // Look how clean this is! You can just press 'Enter' and type.
        String newWay = """
                        Dear Mom,
                        I am having fun at camp.
                        Send more cookies!
                        Love, Me
                        """;
        System.out.println(newWay);

        /*
         * Expected Output (both look the exact same, but the new way is easier to write!):
         * --- The Old Messy Way ---
         * Dear Mom,
         * I am having fun at camp.
         * Send more cookies!
         * Love, Me
         * 
         * --- The Cool New Text Block Way ---
         * Dear Mom,
         * I am having fun at camp.
         * Send more cookies!
         * Love, Me
         */
    }
}