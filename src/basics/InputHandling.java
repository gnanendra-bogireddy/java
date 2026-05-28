package basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class InputHandling {

    public static void main(String[] args) throws IOException {

        // Taking input in Java programming language using Scanner.
        Scanner sc = new Scanner(System.in); // System.in represents standard input (keyboard).

        int a = sc.nextInt(); // To take integer input.
        double b = sc.nextDouble(); // To take double input.
        sc.hasNext(); // To check if there is another token in the input.
        sc.hasNextLine(); // To check if there is another line in the input.
        String str = sc.nextLine(); // To take string input.
        String str1 = sc.next(); // To take string input without space.

        sc.close(); // Closing the Scanner object to prevent memory leaks.

        // Example
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter First Number: ");
        int a1 = scn.nextInt();

        System.out.print("Enter Second Number: ");
        int b1 = scn.nextInt();

        System.out.println("Sum: " + (a1 + b1));
        scn.close();

        // Taking input in Java programming language using BufferedReader.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine(); // To read a line of text from the input.
        br.read(); // To read a single character from the input.
        br.lines(); // To read all lines from the input and return a Stream of lines.
        br.close(); // to close the BufferedReader object to prevent memory leaks.
    }


}
