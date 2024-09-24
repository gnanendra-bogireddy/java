package dsa.firstTen;

public class ProblemTwo {
    // // Write a Java Program to generate Output "a2b3c4" with the input "aabbbcccc"
    public static void main(String[] args) {

        String str1 = "aaddaaaaabbbcccc";
        String string = "";
        int count = 1;
        char temp = str1.charAt(0);
        for (int i = 1; i < str1.length(); i++) {
            if (str1.charAt(i) == temp) {
                count++;
            } else {
                string = string.concat(Character.valueOf(temp).toString()).concat(Integer.valueOf(count).toString());
                count = 1;
                temp = str1.charAt(i);
            }
        }
        string = string.concat(Character.valueOf(temp).toString()).concat(Integer.valueOf(count).toString());
        System.out.println(string);
    }
}
