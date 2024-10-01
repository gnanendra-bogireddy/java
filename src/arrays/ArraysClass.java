package arrays;

import java.util.Arrays;
import java.util.List;

public class ArraysClass {
    public static void main(String[] args) {
        // Create the Array by using Integer as type not int
        Integer[] intArr = {10, 20, 15, 22, 35};

        // To convert the elements as List by using asList(array);
        System.out.println("Integer Array as List: " + Arrays.asList(intArr));

        List<Integer> list = Arrays.asList(intArr);
        System.out.println("First element in Array list : " + list.get(0));

        // Sorting an array by using sort(array) method.
        Arrays.sort(intArr);

        int intKey = 22;
        // Print the key and corresponding index using binarySearch(arr, key);
        // If not found returns -1.
        System.out.println(intKey + " found at index = " + Arrays.binarySearch(intArr, intKey));

        // Binary search with start and end index
        // Print the key and corresponding index,
        // If not found returns -1.
        System.out.println(intKey + " found at index = " + Arrays.binarySearch(intArr, 1, 3, intKey));

        // Get the Array
        int intArr1[] = {10, 20, 15, 22, 35};

        int intArr2[] = {10, 15, 22};

        // To compare both arrays lexicographically. If both arrays are equal then returns 0
        System.out.println("Integer Arrays on comparison: " + Arrays.compare(intArr1, intArr2));

        // Get the Array
        int intArrCopy[] = {10, 20, 15, 22, 35};

        // To print the elements in one line or convert to String.
        System.out.println("Integer Array: " + Arrays.toString(intArrCopy));

        System.out.println("\nNew Arrays by copyOf:\n");

        // Copies the Array to new array with given length,
        // If the whole array does not have enough elements it fills with default values.
        System.out.println("Integer Array: " + Arrays.toString(Arrays.copyOf(intArr, 10)));

        System.out.println("\nNew Arrays by copyOfRange:\n");

        // To copy the array into an array of new length with specified ranges.
        System.out.println("Integer Array: " + Arrays.toString(Arrays.copyOfRange(intArrCopy, 1, 3)));

        // Get the first Array
        int intArrOne[][] = {{10, 20, 15, 22, 35}, {20, 89, 9}};

        // Get the second Array
        int intArrTwo[][] = {{10, 20, 15, 22, 35}, {20, 89, 9}};

        // To compare two arrays element by element
        System.out.println("Integer Array: " + Arrays.deepEquals(intArrOne, intArrTwo));

        // Get the Array
        int intDeepString[][] = {{10, 20, 15, 22, 35}, {40, 60, 95, 42, 15}};

        // To get the deep String of the arrays
        System.out.println("Integer Array: " + Arrays.deepToString(intDeepString));

        // Get the Arrays
        int intArrEqualsOne[] = {10, 20, 15, 22, 35};

        // Get the second Arrays
        int intArrEqualsTwo[] = {10, 20, 15, 22, 35};

        // To compare both arrays
        System.out.println("Integer Arrays on comparison: " + Arrays.equals(intArrEqualsOne, intArrEqualsTwo));

        // Get the Array
        int intArrParallelSort[] = {10, 20, 15, 22, 35};

        // To sort the array using parallelSort
        Arrays.parallelSort(intArrParallelSort);

        System.out.println("Integer Array: " + Arrays.toString(intArrParallelSort));

        // Get the Array
        int intArrSort[] = {10, 20, 15, 22, 35};

        // To sort the array using Sort
        Arrays.sort(intArrSort);
        System.out.println("Integer Array: " + Arrays.toString(intArrSort));

        // Get the Array
        int intArrString[] = {10, 20, 15, 22, 35};

        // To print the elements in one line
        System.out.println("Integer Array: " + Arrays.toString(intArrString));

    }
}
