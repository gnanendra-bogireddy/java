package dsa.thirdTen;

import java.util.Arrays;

public class ProblemThree {
    // Find second highest element in Integer array
    public static void main(String[] args) {
        int[] array = {1, 6, 9, 3, 8, 90, 45, 3, 1, 90, 34, 678, 4, 3, 7, 88, 99, 67};
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > first) {
                second = first;
                first = array[i];
            } else if (array[i] > second && array[i] < first) {
                second = array[i];
            }
        }
//        Arrays.sort(array);
//        System.out.println(Arrays.toString(array));
        System.out.println(second);
        System.out.println(first);
    }
}
