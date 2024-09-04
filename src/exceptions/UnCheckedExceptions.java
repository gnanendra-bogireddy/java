package exceptions;

public class UnCheckedExceptions {
    public static void main(String[] args) {

        // Here we are dividing by 0
        // which will not be caught at compile time
        // as there is no mistake but caught at runtime
        // because it is mathematically incorrect
        // Exception in thread "main" java.lang.ArithmeticException: / by zero
        int x = 0;
        int y = 10;
        int z = y / x;


        // Here we are calling and printing a null value
        // Exception in thread "main" java.lang.NullPointerException because "a" is null
        String a = null; // Assigning null value
        System.out.println(a.charAt(0)); //Printing null value

        // Here we are accessing 25 th char of string
        // Exception in thread "main" java.lang.StringIndexOutOfBoundsException: String index out of range: 24
        String outOfBound = "This is like chipping "; // length is 22
        char c = outOfBound.charAt(24); // accessing 25th element
        System.out.println(c);

        // Here we are converting string to int value
        // Exception in thread "main" java.lang.NumberFormatException: For input string: "akki"
        int num = Integer.parseInt("akki"); // String value does not contain int value
        System.out.println(num);

        // Here we are accessing n+1 th element for size n array
        // Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 6 out of bounds for length 5
        int arr[] = new int[5];
        arr[6] = 9; // accessing 7th element (6th index) in an array of size 5

    }
}
