package dsa.firstTen;

import java.util.Arrays;

public class ProblemSix {
    // Write a program to copy elements from one array to other
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 2, 4, 6, 8, 10, 56, 867, 890, 643};

        int[] array = Arrays.copyOf(arr, 10);
        System.out.println(Arrays.toString(array));

        int[] intArray = new int[10];
        System.arraycopy(array, 0, intArray, 0, 5);

        System.out.println(Arrays.equals(array, intArray));

    }
}
