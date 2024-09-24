package dsa.firstTen;

public class ProblemThree {

    // Write a Java Program to reverse a number and check number is palindrome or not
    public static void main(String[] args) {

        int num1 = 12321;
        int originalNum = num1; // Store the original number
        int temp = 0;
        int rem;

        while (num1 > 0) {
            rem = num1 % 10;
            num1 = num1 / 10;
            temp = (temp * 10) + rem;
        }

        System.out.println(temp);

        if (originalNum == temp) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }

    }
}
