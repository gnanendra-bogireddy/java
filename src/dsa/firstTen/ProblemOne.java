package dsa.firstTen;

public class ProblemOne {
    // Write a Java Program to generate Output "aabbbcccc" with the input "a2b3c4"

    public static void main(String[] args) {
        String str1 = "a2b3c4";
        StringBuilder sb = new StringBuilder();
        String temp = "";
        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            temp = Character.valueOf(str1.charAt(i)).toString();
            count = Integer.parseInt(String.valueOf(str1.charAt(i + 1)));
            int tmp = 0;
            while (tmp < count) {
                sb.append(temp);
                tmp++;
            }
            i++;
        }

        System.out.println(sb.toString());
    }
}
