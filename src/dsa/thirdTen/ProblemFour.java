package dsa.thirdTen;

import oop.interfaces.InterfaceExample;

import java.util.*;

public class ProblemFour {
    //  Write a java code to check two Strings are anagrams or not
    // Anagram - Two strings are anagrams if they have same chars and number of corresponding position

    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";

        List<Character> list1 = new ArrayList<>();
        List<Character> list2 = new ArrayList<>();
        for (char c : str1.toCharArray()) {
            list1.add(c);
        }
        for (char c : str2.toCharArray()) {
            list2.add(c);
        }
        Collections.sort(list1);
        Collections.sort(list2);
        System.out.println(list1);
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (char c : list1) {
            int count = Collections.frequency(list1, c);
            map1.put(c, count);
        }
        for (char c : list2) {
            int count = Collections.frequency(list1, c);
            map2.put(c, count);
        }
        System.out.println(map2);
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry<Character, Integer> e : map1.entrySet()) {
            sb1.append(Character.valueOf(e.getKey()).toString() + Integer.valueOf(e.getValue()).toString());
        }
        for (Map.Entry<Character, Integer> e : map2.entrySet()) {
            sb2.append(Character.valueOf(e.getKey()).toString() + Integer.valueOf(e.getValue()).toString());
        }
        System.out.println(sb1);
        System.out.println(sb2);
        if (sb1.toString().equals(sb2.toString())) {
            System.out.println("Anagram");
        }

    }
}
