package dsa.firstTen;

import java.util.Arrays;
import java.util.OptionalInt;

public class ProblemFive {
    // Find the sum of all elements in an array and average and find min and max elements in array
    // Sort an array
    public static void main(String[] args) {
        int[] intArray = {0, 5, 9, 98, 56, 123, 890, 907, 56, 1, 4, 7, 45, 90, 2, 6, 8};
        int sum = 0;
        for (int temp : intArray) {
            sum += temp;
        }
        System.out.println("Sum of all elements in Array : " + sum);

        // By using stream() methods.

        int total = Arrays.stream(intArray).sum();
        System.out.println("Sum of all elements using stream() function is : " + total);

        double average = Arrays.stream(intArray).average().orElseThrow();
        System.out.println("Average of all elements is : " + average);

        int max = Arrays.stream(intArray).max().orElseThrow();
        System.out.println("Max element in Array is : " + max);

        int min = Arrays.stream(intArray).min().orElseThrow();
        System.out.println("Min element in Array is : " + min);

        Arrays.sort(intArray);
        System.out.println("Array after sorting : " + Arrays.toString(intArray));
    }
}
