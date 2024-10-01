package dsa.secondTen;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Print only alphabets from given input String input = "this is sample String!!!"
public class ProblemEight {
    public static void main(String[] args) {
        String input = "this is sample String!!!";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            Character temp = input.charAt(i);
            if (Character.isLetter(temp)) {
                sb.append(temp);
            }
        }
        String two = sb.toString().toLowerCase();
        System.out.println(two);
        char[] array = two.toCharArray();
        Character[] charArray = new Character[array.length];
        for (int i = 0; i < array.length; i++) {
            charArray[i] = array[i];
        }
        List<Character> list = Arrays.asList(charArray);
        System.out.println(list);
        for (char temp : list) {
            int count = Collections.frequency(list, temp);
            if (count > 1) {
                System.out.println(temp);
            }
        }
    }
}
