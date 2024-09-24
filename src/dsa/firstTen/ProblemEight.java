package dsa.firstTen;

import java.util.Scanner;

public class ProblemEight {
    // Swap two number without using third variable
    public static void main(String[] args) {
        int a = 20;
        int b = 30;

        a = a + b - (b = a);
        System.out.println(a + " " + b);
    }
}
