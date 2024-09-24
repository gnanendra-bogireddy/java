package dsa.firstTen;

import java.util.Arrays;

public class ProblemNine {
    // Factorial for given number
    public static void main(String[] args) {
        int num = 10;
        long factorial = 1;
        while (num > 0) {
            factorial *= num;
            num -= 1;
        }
        System.out.println(factorial);
    }
}
