package strings;

import java.util.Arrays;

public class StringMethods {
    public static void main(String[] args) {

        String s = "GeeksforGeeks";

        // Returns the number of characters in the String.
        System.out.println("String length = " + s.length());

        // Returns the character at ith index.
        System.out.println("Character at 3rd position = " + s.charAt(3));

        // Return the substring from the ith  index character
        // to end of string
        System.out.println("Substring " + s.substring(3));

        // Returns the substring from i to j-1 index.
        System.out.println("Substring  = " + s.substring(2, 5));


        // Concatenates string2 to the end of string1.
        String s1 = "Geeks";
        String s2 = "forGeeks";
        System.out.println("Concatenated string  = " + s1.concat(s2));

        // Returns the index within the string
        // of the first occurrence of the specified string,
        // Returns -1 if not present.
        String s4 = "Learn Share Learn";
        System.out.println("Index of Share " + s4.indexOf("Share"));

        // Returns the index within the string of the
        // first occurrence of the specified string,
        // starting at the specified index,
        // Returns -1 if not present.
        System.out.println("Index of a  = " + s4.indexOf('a', 3));

        // Returns the last index within the string,
        // Returns -1 if not present.
        String lastIndex = "Learn Share Learn";
        int output = s.lastIndexOf("a"); // returns 14
        String lastIndexTwo = "Learn Share Learn";
        int outputTwo = s.indexOf("Play");  // return -1

        // Checking equality of Strings
        Boolean out = "Geeks".equals("geeks");
        System.out.println("Checking Equality  " + out);
        out = "Geeks".equals("Geeks");
        System.out.println("Checking Equality  " + out);

        out = "Geeks".equalsIgnoreCase("gEeks ");
        System.out.println("Checking Equality " + out);

        //If ASCII difference is zero then the two strings are similar
        // If difference is -ve then String one is after String two
        // If difference is +ve then String one is String one is before String two
        String stringOne = "geeks";
        String stringTwo = "Geeks";
        int out1 = stringOne.compareTo(stringTwo);
        System.out.println("the difference between ASCII value is=" + out1);

        // Ignores case
        int out2 = stringOne.compareToIgnoreCase(stringTwo);
        System.out.println("the difference between ASCII value is without case is=" + out2);

        // Converting cases
        String word1 = "GeeKyMe";
        System.out.println("Changing to lower Case " + word1.toLowerCase());

        // Converting cases
        String word2 = "GeekyME";
        System.out.println("Changing to UPPER Case " + word2.toUpperCase());

        // Trimming the word
        String word4 = " Learn Share Learn ";
        System.out.println("Trim the word " + word4.trim());

        // Returns a string after removing white spaces at beginning and end of the word
        String word5 = " Learn Share Learn ";
        System.out.println("Trim the word " + word5.strip());

        // Replacing characters
        String str1 = "feeksforfeeks";
        System.out.println("Original String " + str1);
        String str2 = "feeksforfeeks".replace('f', 'g');
        System.out.println("Replaced f with g -> " + str2);

        // Replacing string
        String strOriginal = "feeksforfeeks";
        System.out.println("Original String " + str1);
        String relpaceAll = "feeksforfeeks".replaceAll("feeks", "Geeks");
        System.out.println("Replaced feeks with Geeks -> " + relpaceAll);

        // Finding original string has given string or not
        String originalString = "geeksforgeeks";
        String find = "geeks";
        boolean value = originalString.contains(find); // return true
        System.out.println("Original string has given string or not : " + value);

        // Converting String to char array
        String stringValue = "geeksforgeeks";
        char[] charArray = stringValue.toCharArray();
        for (char temp : charArray) {
            System.out.println("Characters in Array : " + temp);
        }

        // Finding Starts with given string or not
        String originalStringValue = "geeksforgeeks";
        String startsWith = "geeks";
        boolean valueTwo = originalString.startsWith(find); // return true
        System.out.println("Original string has given string or not : " + valueTwo);

        // Finding ends with given string or not
        String endsWith = "geeks";
        boolean valueThree = originalString.endsWith(find); // return true
        System.out.println("Original string has given string or not : " + valueThree);

        // Finding String constant pool has given value or not,
        // If present it maps the string reference to found value.
        String stringValueOne = "Intern";
        stringValueOne.intern();

        // Finds String is empty or not,
        // Finds the length and if length is 0, prints true
        String emptyString = "";
        System.out.println("Given string is empty or not : " + emptyString.isEmpty());

        // Finds String is blank or not,
        // If string does not contain any value other than blanks, prints true
        String blankString = "  ";
        System.out.println("Given string is empty or not : " + emptyString.isBlank());

        // Finds String is blank or not,
        // If string does not contain any value other than blanks, prints true
        String blankStringTwo = "  ";
        System.out.println("Given string is empty or not : " + emptyString.isBlank());

        // Returns string into String of arrays.
        String splittingString = "Geeks For Geeks";
        String[] stringArray = splittingString.split(" ");

        // Returns joined string into new string.
        String stringJoinOne = "String One";
        String stringJoinTwo = "Two";
        String stringJoinThree = "Three";
        String joinedString = String.join(" ", stringJoinOne, stringJoinTwo, stringJoinThree);
        System.out.println(" Joined string is : " + joinedString);

        // Returns formatted string.
        String myStr = "Hello %s! One kilobyte is %d bytes.";
        String result = String.format(myStr, "World", 1024);
        System.out.println(result);

        // Returns true if the given string matches with regex

        String matches = "Hello";
        System.out.println("Vowels present in String : " + matches.toLowerCase().matches(".*[aeiou].*"));

    }
}
