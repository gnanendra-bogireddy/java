package dsa.secondTen;

import java.util.*;

public class ProblemFour {
    // Write a Java program to find all duplicate elements in an array.
    public static void main(String[] args) {
        int[] array = {1, 3, 6, 4, 8, 9, 0, 3, 4, 5, 8, 9, 2, 4, 4, 6, 8, 9, 0};

        Arrays.sort(array);
        List<Integer> list = new ArrayList<>();
        for (int temp : array) {
            list.add(temp);
        }
        HashSet<Integer> hashSet = new HashSet<>();
        for (int temp : list) {
            if (Collections.frequency(list, temp) > 1) {
                hashSet.add(temp);
            }
        }
        System.out.println(hashSet);
    }
}
