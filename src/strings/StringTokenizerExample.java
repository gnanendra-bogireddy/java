package strings;

import java.util.StringTokenizer;

public class StringTokenizerExample {
    public static void main(String[] args) {

        // Constructor 1
        System.out.println("Using Constructor 1 - ");

        // Creating object of class inside main() method
        StringTokenizer st1 = new StringTokenizer("Hello Geeks How are you", " ");

        // Condition holds true till there is single token
        // remaining using hasMoreTokens() method
        while (st1.hasMoreTokens())
            // Getting next tokens
            System.out.println(st1.nextToken());

        // Constructor 2
        System.out.println("Using Constructor 2 - ");

        // Again creating object of class inside main()
        // method
        StringTokenizer st2 = new StringTokenizer("JAVA : Code : String", " :");

        // If tokens are present
        while (st2.hasMoreTokens())

            // Print all tokens
            System.out.println(st2.nextToken());

        // Constructor 3
        System.out.println("Using Constructor 3 - ");

        // Again creating object of class inside main()
        // method
        StringTokenizer st3 = new StringTokenizer("JAVA : Code : String", " :", true);

        while (st3.hasMoreTokens()) System.out.println(st3.nextToken());


        // Creating a StringTokenizer
        StringTokenizer str = new StringTokenizer("Welcome to GeeksforGeeks");

        StringTokenizer temp = new StringTokenizer("");

        // countTokens Method
        int count = str.countTokens();
        System.out.println(count);

        // hasMoreTokens Methods
        System.out.println("Welcome to GeeksforGeeks: " + str.hasMoreTokens());
        System.out.println("(Empty String) : " + temp.hasMoreTokens());

        // nextElement() Method
        System.out.println("\nTraversing the String:");

        while (str.hasMoreTokens()) {
            System.out.println(str.nextElement());
        }
    }
}