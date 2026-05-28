package strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternClass {

    public static void main(String[] args) {


        // Pattern matches a regular expression against a string.It is used to define a pattern for searching or
        // manipulating strings. It is a compiled representation of a regular expression.
        var pattern = Pattern.compile("[a-zA-Z]");

        // returns false because it checks the whole string and not just a part of it.
        boolean flag = Pattern.matches("[a-zA-Z]", "Hello");

        // Matcher is an engine that performs match operations on a character sequence by interpreting a Pattern.
        Matcher matcher = pattern.matcher("Hello");

        // Matches "Hello", "HELLO", "hELlo", etc.
        Pattern pattern1 = Pattern.compile("Hello",  Pattern.CASE_INSENSITIVE);

        // if the input is multiple lines, then ^ and $ will match the start and end of each line, respectively, instead of the start and end of the entire input.
        Pattern pattern2 = Pattern.compile("Hello",  Pattern.CASE_INSENSITIVE | Pattern.MULTILINE );

        // Split the input based on the above pattern.
        String[] splitArray = pattern2.split("Hello\nWorld\nHello\nJava");


    }
}
