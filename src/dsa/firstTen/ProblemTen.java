package dsa.firstTen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ProblemTen {
    // Reverse a String without using StringBuilder or StringBuffer
    public static void main(String[] args) {

        String string = "Gnanendra";
        char[] chars = string.toCharArray();
        List<Character> list = new ArrayList<>();
        for (int i = chars.length - 1; i >= 0; i--) {
            list.add(chars[i]);
        }
        Character[] characters = list.toArray(new Character[0]);
        char[] reversed = new char[characters.length];

        for (int i = 0; i < characters.length; i++) {
            reversed[i] = characters[i];
        }
        System.out.println(new String(reversed));

        // Simple one

        String reversedOne = "";
        for (int i = string.length() - 1; i >= 0; i--) {
            reversedOne += String.valueOf(string.charAt(i));
        }

        System.out.println(reversedOne);
    }
}
