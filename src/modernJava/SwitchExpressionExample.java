package modernJava;

/**
 * Switch Expressions (Java 14) are like a Super Fast Vending Machine!
 * 
 * The old switch statement was annoying because if you forgot to write 'break',
 * all the snacks would fall out!
 * 
 * The new Switch Expression uses an arrow '->' and automatically stops.
 * It can even hand you back a snack (return a value) right away!
 */
public class SwitchExpressionExample {
    public static void main(String[] args) {

        System.out.println("--- The Super Fast Vending Machine ---");

        int buttonPressed = 2;

        // See how we store the answer directly into the 'snack' variable?
        String snack = switch (buttonPressed) {
            case 1 -> "Chocolate Bar";
            case 2, 3 -> "Potato Chips"; // We can put multiple buttons on one line!
            case 4 -> {
                System.out.println("Heating up the soup...");
                // 'yield' is like 'return', but specifically for switch blocks!
                yield "Hot Soup"; 
            }
            default -> "Empty Slot";
        }; // Notice the semicolon here!

        System.out.println("You received: " + snack);

        /*
         * Expected Output:
         * --- The Super Fast Vending Machine ---
         * You received: Potato Chips
         */
    }
}