package dsa.thirdTen;

import java.util.ArrayList;
import java.util.List;

public class ProblemTwo {
    // Write a Java program to check if a vowel is present in a string.
    public static void main(String[] args) {
        String string = "wrttrtwrtwrwt";
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("e");
        list.add("i");
        list.add("o");
        list.add("u");
        boolean flag = false;
        for (int i = 0; i < string.length(); i++) {
            if (list.contains(String.valueOf(string.charAt(i)).toLowerCase())) {
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println("List contains Vowel");
        }


        // Simple one

        if (string.toLowerCase().matches(".*[aeiou].*")) {
            System.out.println("List contains Vowel");
        }
    }
}
