package dsa.thirdTen;

public class ProblemOne {
    // How do you swap two numbers without using a third variable in Java?
    public static void main(String[] args) {
        int num1 = 1;
        int num2 = 2;
        num2 = num1 + num2;
        num1 = num2 - num1;
        num2 = num2 - num1;

        System.out.println(num1 + " " + num2);
    }
}
