package dsa.secondTen;

import java.util.HashSet;
import java.util.Set;

// Write a Java program to find the longest substring without repeating characters.
public class ProblemThree {
    public static void main(String[] args) {
        String string = "abcfefghijkltttttt";
        int length = 0;
        int finalLength = 0;
        String longestString = null;
        String finalString = null;
        Set<Character> set = new HashSet<>();
        for(int i=0; i<string.length(); i++){
            set.add(string.charAt(i));
            for(int j= i+1; j<string.length(); j++){
                char temp = string.charAt(j);
                boolean contains = set.contains(temp);
                if(contains){
                    break;
                }
                else{
                    set.add(temp);
                    longestString = string.substring(i,j+1);
                    length = longestString.length();
                }
            }
            if(length> finalLength){
                finalString = longestString;
                finalLength = length;
            }
            set.clear();
        }
        System.out.println(finalString);
    }
}
