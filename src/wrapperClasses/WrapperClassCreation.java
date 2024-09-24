package wrapperClasses;

public class WrapperClassCreation {
    public static void main(String[] args) {

        // We can create a wrapper class by using Auto boxing method.
        // ClassName object = value;
        Integer integer = 100;

        // We can create a wrapper class by using valueOf method. Create Integer object.
        // ClassName object = ClassName.valueOf(argument);
        Integer getInteger = Integer.valueOf("100");
        System.out.println("Integer value from wrapper class object is : " + getInteger.toString());

        // parseInt() method parses String to int value unlike valueOf() converts to object.
        String string = "101";
        int value = Integer.parseInt(string);
        System.out.println("Parsing int value from String - Differs from valueOf() : " + value);


        // compare(int1, int2) - the value 0 if x == y; a value less than 0 if x < y; and a value greater than 0 if x > y
        int comparedValue = Integer.compare(100, 101);
        System.out.println("Comparison value is : " + comparedValue);

        // max(int1, int2) - returns the maximum value.
        int maxValue = Integer.max(100, 198);
        System.out.println("Printing maximum value between numbers : " + maxValue);

        // min(int1, int2) - returns the maximum value.
        int minValue = Integer.min(100, 198);
        System.out.println("Printing minimum value between numbers : " + minValue);


        //isLetter() returns whether passed value is letter or not
        System.out.println(Character.isLetter('A'));
        System.out.println(Character.isLetter('0'));

        //isDigit() returns whether passed value is digit or not
        System.out.println(Character.isDigit('A'));
        System.out.println(Character.isDigit('0'));

        //isWhitespace() returns whether passed value is white space or not
        System.out.println(Character.isWhitespace(' '));

        //isUpperCase() returns whether passed value is upper case or not
        System.out.println(Character.isUpperCase('U'));
        System.out.println(Character.isLowerCase('l'));

        //getNumericValue('4') returns whether passed value is numeric or not
        System.out.println(Character.getNumericValue('4'));

        //isAlphabetic('4') returns whether passed value is alphabetic or not
        System.out.println(Character.isAlphabetic('a'));

        //isLetterOrDigit('4') returns whether passed value is numeric or alphabetic or not
        System.out.println(Character.isLetterOrDigit('@'));

        System.out.println("She said \"Hello!\" to me.");

    }
}

