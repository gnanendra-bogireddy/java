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

        //isLetter() returns whether passes value is letter or not
        System.out.println(Character.isLetter('A'));
        System.out.println(Character.isLetter('0'));

        //isDigit() returns whether passes value is letter or not
        System.out.println(Character.isDigit('A'));
        System.out.println(Character.isDigit('0'));

        //isWhitespace() returns whether passes value is white space or not
        System.out.println(Character.isWhitespace(' '));

        //isUpperCase() returns whether passes value is upper case or not
        System.out.println(Character.isUpperCase('U'));
        System.out.println(Character.isLowerCase('l'));

        System.out.println("She said \"Hello!\" to me.");


    }
}

