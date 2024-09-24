package dsa.firstTen;

import java.util.Arrays;
import java.util.Comparator;

public class ProblemSeven {
    // Find third-largest element in Array
    public static void main(String[] args) {
        int[] arr = {1, 3, 7, 89, 45, 32, 78, 90, 0, 67};

        int num = Arrays.stream(arr).boxed().distinct().sorted(Comparator.reverseOrder()).limit(3).min(Comparator.naturalOrder()).orElse(-1);
        System.out.println(num);

        Arrays.sort(arr);
        System.out.println(arr[arr.length - 3]);
    }
}
