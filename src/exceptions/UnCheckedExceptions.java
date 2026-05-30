package exceptions;

/**
 * Unchecked Exceptions are like sudden surprises!
 * 
 * The Java compiler (the teacher) trusts you and DOES NOT check these before you press play.
 * But when the program runs, SURPRISE! A bug happens and the program crashes.
 * 
 * Note: These are commented out so the program can run, but if you uncomment them, boom!
 */
public class UnCheckedExceptions {
    public static void main(String[] args) {

        System.out.println("Watch out for surprise bugs!");

        // 1. ArithmeticException
        // We are dividing by 0. The compiler doesn't notice the math mistake until we run it.
        /*
        int x = 0;
        int y = 10;
        int z = y / x; // CRASH! ArithmeticException: / by zero
        */

        // 2. NullPointerException
        // Imagine looking for a toy inside an empty box (null). There's nothing there!
        /*
        String emptyBox = null; 
        System.out.println(emptyBox.length()); // CRASH! NullPointerException
        */

        // 3. StringIndexOutOfBoundsException
        // Trying to read the 100th letter of a 5-letter word!
        /*
        String shortWord = "Hello"; 
        char c = shortWord.charAt(10); // CRASH! StringIndexOutOfBoundsException
        */

        // 4. NumberFormatException
        // Trying to turn words into a number. You can't turn "Apple" into the number 5!
        /*
        int num = Integer.parseInt("Apple"); // CRASH! NumberFormatException
        */

        // 5. ArrayIndexOutOfBoundsException
        // You have a 3-piece puzzle (array size 3), but you try to place a 4th piece!
        /*
        int arr[] = new int[3];
        arr[5] = 9; // CRASH! ArrayIndexOutOfBoundsException
        */
        
        System.out.println("If we ran those bad lines of code, the program would have crashed!");
    }
}