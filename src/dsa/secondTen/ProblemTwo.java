package dsa.secondTen;

import java.util.ArrayList;
import java.util.List;

public class ProblemTwo {
    // Write a Java program to check if a given number is a perfect number or not.
    public static void main(String[] args) {
        int number = 9;

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                list.add(i);
            }
        }
        int sum = 0;
        for (int temp : list) {
            sum += temp;
        }

        if (number == sum) {
            System.out.println("Perfect number");
        } else {
            System.out.println("Not a perfect number");
        }
    }
}
