package dsa.secondTen;

// Convert String number to int without using Integer.parseInt() method.
public class ProblemNine {
    public static void main(String[] args) {

        String string = "98791";
        double number = 0;
        for (int i = 0; i < string.length(); i++) {
            char ascii = string.charAt(i);
            int temp = ascii - '0';
            double power = temp * (Math.pow(10, (string.length() - (i + 1))));
            number = number + power;
        }
        System.out.println((int) number);
    }
}
