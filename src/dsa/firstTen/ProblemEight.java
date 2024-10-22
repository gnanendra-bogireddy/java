package dsa.firstTen;

// Swap two number without using third variable
public class ProblemEight {
    public static void main(String[] args) {
        int a = 20;
        int b = 30;

        a = a + b - (b = a);
        System.out.println(a + " " + b);
    }
}
