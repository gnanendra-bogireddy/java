package dsa.firstTen;

import java.util.Scanner;

public class ProblemFour {
    // Write a program to print given input and command line arguments.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the input : ");
        String name = scanner.nextLine();
        System.out.println("You have entered : " + name);

        for (String temp : args) {
            System.out.println(temp);
        }

    }
}
