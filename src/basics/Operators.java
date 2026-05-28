package basics;

public class Operators {

    public static void main(String[] args) {
        int a = 10, b = 3;

        // Addition
        int sum = a + b;

        // Subtraction
        int diff = a - b;

        // Multiplication
        int mul = a * b;

        // Division 10/2 returns 5.
        int div = a / b;

        // Modulus returns the reminder value  10 % 2 returns 0
        int mod = a % b;      // Modulus

        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + diff);
        System.out.println("Multiplication: " + mul);
        System.out.println("Division: " + div);
        System.out.println("Modulus: " + mod);


        // Integer declared
        int a1 = 10;
        int b1 = 10;

        // Using unary operators
        System.out.println("Postincrement : " + (a1++));
        System.out.println("Preincrement : " + (++a1));

        System.out.println("Postdecrement : " + (b1--));
        System.out.println("Predecrement : " + (--b1));


        // initial value
        int num = 10;
        System.out.println("Initial: " + num);

        // add 5 → num = num + 5
        num += 5;
        System.out.println("After +5: " + num);

        // multiply by 2 → num = num * 2
        num *= 2;
        System.out.println("After *2: " + num);

        // subtract 5 → num = num - 5
        num -= 5;
        System.out.println("After -5: " + num);

        // divide by 2 → num = num / 2
        num /= 2;
        System.out.println("After /2: " + num);

        // remainder after dividing by 3 → num = num % 3
        num %= 3;
        System.out.println("After %3: " + num);

        // Comparison operators
        int a2 = 10;
        int b2 = 3;
        int c2 = 5;

        System.out.println("a > b: " + (a2 > b2));
        System.out.println("a < b: " + (a2 < b2));
        System.out.println("a >= b: " + (a2 >= b2));
        System.out.println("a <= b: " + (a2 <= b2));
        System.out.println("a == c: " + (a2 == c2));
        System.out.println("a != c: " + (a2 != c2));

        // Logical operators
        boolean x = true;
        boolean y = false;

        System.out.println("x && y: " + (x && y));
        System.out.println("x || y: " + (x || y));
        System.out.println("!x: " + (!x));

        int a3 = 10;
        int b3 = 20;

        // If (a > b) is true, 'max' gets assigned 'a'. Otherwise, it gets 'b'.
        int max = (a3 > b3) ? a3 : b3;

        System.out.println(max); // 20

        int num1 = -5;

        String type = (num1 > 0) ? "Positive" : ((num1 < 0) ? "Negative" : "Zero");

        System.out.println(num1 + " is " + type); // -5 is Negative
    }
}
