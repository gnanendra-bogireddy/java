package dsa.secondTen;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class ProblemOne {
    //  Write a Java Program to find the count of each character in the given string
    public static void main(String[] args) {
        String string = "aabbbcccc";

        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            char temp = string.charAt(i);
            int count = 0;
            for (int j = 0; j < string.length(); j++) {
                if (temp == string.charAt(j)) {
                    count++;
                }
            }
            hashMap.put(temp, count);
        }
        System.out.println(hashMap);

        // One using Collections

        char[] chars = string.toCharArray();
        List<Character> list = new ArrayList<>();
        for (char temp : chars) {
            list.add(temp);
        }
        Collections.sort(list);
        HashMap<Character, Integer> hashMap1 = new HashMap<>();

        for (int i = 0; i < chars.length; i++) {
            int count = Collections.frequency(list, chars[i]);
            hashMap1.put(chars[i], count);
        }

        System.out.println(hashMap1);
    }
}
