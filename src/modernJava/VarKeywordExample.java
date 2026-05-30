package modernJava;

import java.util.ArrayList;

/**
 * 'var' Keyword (Java 10) is like a Magic Box!
 * 
 * In the old days, you had to write the name of the toy TWICE:
 * ArrayList<String> box = new ArrayList<String>();
 * 
 * With 'var', Java is smart enough to look at what you put in the box,
 * and it automatically labels the box for you!
 */
public class VarKeywordExample {
    public static void main(String[] args) {

        System.out.println("--- Using the Magic Box (var) ---");

        // Java sees the number 10, so it knows this is an 'int' box!
        var age = 10;
        
        // Java sees quotes, so it knows this is a 'String' box!
        var name = "Super Coder";

        // Java sees an ArrayList, so it labels the box 'ArrayList<String>'
        var toyBox = new ArrayList<String>();
        toyBox.add("Robot");
        toyBox.add("Car");

        System.out.println("My name is " + name + " and I am " + age + " years old.");
        System.out.println("In my toy box: " + toyBox);

        // BE CAREFUL! 
        // Once the magic box is labeled, you CANNOT put a different toy inside!
        // age = "Ten"; // ERROR! The box was already labeled 'int'.

        /*
         * Expected Output:
         * --- Using the Magic Box (var) ---
         * My name is Super Coder and I am 10 years old.
         * In my toy box: [Robot, Car]
         */
    }
}