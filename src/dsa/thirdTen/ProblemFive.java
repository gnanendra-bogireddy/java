package dsa.thirdTen;

import java.util.Arrays;

// Arrange Strings by alphabetic order keep spaces and order of strings in same format
public class ProblemFive {
    public static void main(String[] args) {
        String string = "Suraj Gnanendra Three";
        String[] strArray = string.split(" ");
        StringBuilder sb = new StringBuilder();
        char[] charArray = null;
        for (String temp : strArray) {
            charArray = temp.toCharArray();
            Arrays.sort(charArray);
            String temp1 = new String(charArray);
            sb.append(temp1);
            sb.append(" ");
        }
        System.out.println(sb.toString());

    }
}
