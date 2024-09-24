package exceptions;

import java.io.IOException;

public class TryCatchExample {

    // This method throws an exception to be handled,
    // by caller,
    // of caller and so on.
    static void fun() throws IllegalAccessException, IOException {
        System.out.println("Inside fun(). ");
        throw new IllegalAccessException("IllegalAccessException");
    }

    public static void main(String[] args) {

        try {
            // block of code to monitor for errors
            // the code you think can raise an exception
            // ArithmeticException code
            int a = 5;
            int b = 0;
            System.out.println(a / b);

        }
        catch (ArithmeticException exception) {
            // statement(s) that handle an exception
            // examples, closing a connection, closing
            // file, exiting the process after writing
            // details to a log file.
            // exception handler for ArithmeticException
            //Prints stack trace for the exception.
            exception.printStackTrace(); //prints: java.lang.ArithmeticException: / by zero

            //Prints exception message.
            exception.getMessage(); // prints: by zero

            //Converts and prints exception string.
            exception.toString(); //prints: java.lang.ArithmeticException: / by zero

        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            // exception handler for ArrayIndexOutOfBoundsException
        }
        // optional finally block
        finally {
            // block of code to be executed after try block ends
            System.out.println("I am in final block");
        }

        try {
            // Throwing new exception using throw keyword.
            throw new RuntimeException("error_unknown");
        } catch (RuntimeException exception) {
            System.out.println("Caught inside help().");
            // rethrowing the exception
            throw exception;
        }

    }
}
