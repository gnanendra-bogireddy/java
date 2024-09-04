package arrays;

import arrays.model.Student;

public class ArrayExample {
    public static void main(String[] args) {

        // both are valid declarations
        int intArray[];
        int[] intArrayTwo;

        // allocating memory to array
        intArray = new int[20];
        // combining both statements in one
        int[] intArrayFull = new int[20];

        // Declaring array literal
        int[] intArrayLiteral = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // accessing the elements of the specified array
        for (int i = 0; i < intArrayLiteral.length; i++)
            System.out.println("Element at index " + i + " : " + intArrayLiteral[i]);

        Student[] arr = new Student[5]; //Student is a user-defined class

        int[][] intArrayTwoD = new int[10][20]; //a 2D array or matrix
        int arrTwo[][] = {{2, 7, 9}, {3, 6, 1}, {7, 4, 2}};

        int[][][] intArrayThreeD = new int[10][20][10]; //a 3D array

        // Syntax for multi dimensional array
        int[][] multiDimentionalArr = new int[3][3];
        // 3 row and 3 column

        // Number of Rows
        System.out.println("Number of Rows:" + multiDimentionalArr.length);

        // Number of Columns
        System.out.println("Number of Columns:" + multiDimentionalArr[0].length);

        int intArr[] = {1, 2, 3};
        int cloneArray[] = intArr.clone();

        // will print false as shallow copy is created
        System.out.println(intArr == cloneArray);

        int[] myArray = {10, 30, 67, 58, 45};

        // To find the length of an array
        int length = myArray.length;
        System.out.println("Array length is : " + length);

    }
}
