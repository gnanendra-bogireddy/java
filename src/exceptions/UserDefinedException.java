package exceptions;

public class UserDefinedException extends Exception {
    // A Class that represents user-defined exception
    public UserDefinedException(String s) {
        // Call constructor of parent Exception,
        // We can call avoid this not providing Exception message.
        super(s);
    }
}

// A Class that uses above MyException
class Main {
    // Driver Program
    public static void main(String args[]) {
        try {
            // Throw an object of user defined exception
            throw new UserDefinedException("GeeksGeeks");
        } catch (UserDefinedException ex) {
            System.out.println("Inside Catch block");

            // Print the message from MyException object
            System.out.println(ex.getMessage());
        }
    }
}

