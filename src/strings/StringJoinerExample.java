package strings;

import java.util.ArrayList;
import java.util.StringJoiner;

public class StringJoinerExample {
    public static void main(String[] args) {
        // Creating an empty ArrayList of string type
        ArrayList<String> al = new ArrayList<>();

        // Adding elements to above List
        al.add("Ram");
        al.add("Shyam");
        al.add("Alice");
        al.add("Bob");

        // Creating object of class inside main()
        StringJoiner sj1 = new StringJoiner(",");

        // Using setEmptyValue() method,
        // The corresponding string will be added if string is empty,
        // After calling add method this will be void.
        sj1.setEmptyValue("sj1 is empty");
        System.out.println(sj1);

        // Using add() method,
        // Takes single string, and we can use multiple times and add those string with provided delimiter.
        sj1.add(al.get(0)).add(al.get(1));
        System.out.println(sj1);

        // Using length() method
        System.out.println("Length of sj1 : " + sj1.length());

        // Updates delimiter value if we uses again.
        StringJoiner sj2 = new StringJoiner(":");
        sj2.add(al.get(2)).add(al.get(3));

        // Using merge() method,
        // It merges and returns updated string.
        sj1.merge(sj2);

        // Using toString() method
        System.out.println(sj1.toString());

        System.out.println("Length of new sj1 : " + sj1.length());
    }

}
