package basics;

public class ReturnExample {
        // A simple method that takes two integers as input and
        // returns their sum
        public static int calculateSum(int num1, int num2)
        {
            // Print a message indicating the method has started
            System.out.println("Calculating the sum of " + num1
                    + " and " + num2);
            int sum = num1 + num2;
            System.out.println("The sum is: " + sum);

            // Return the calculated sum
            return sum;

            // Note: Any code after the 'return' statement will
            // not be executed. But "Final" is an exception in
            // the case of try-catch-final block.
            // System.out.println("end"); // error : unreachable
            // statement
        }
        public static void main(String[] args)
        {
            // Call the calculateSum method
            int result = calculateSum(5, 10);

            // Print the result
            System.out.println("Result: " + result);
        }
    }

