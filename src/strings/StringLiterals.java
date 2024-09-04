package strings;

import java.nio.charset.Charset;

public class StringLiterals {

    public static void main(String[] args) {

        // String literals are saved in String constant pool for memory safety
        String demoString = "GeeksforGeeks";

        //Strings created using string objects are stored in Heap memory
        String demoStringHeap = new String("GeeksforGeeks");

        //Why Strings are immutable in java?
    /* Java uses String constant pool to store the strings and a reference will be
       assigned to String pool and this is done to manage memory efficiently
     */

        // String are immutable programme

        String immutable = "Immutable String";

        immutable.concat("Mutable");

        //Prints Immutable String
        System.out.println(immutable);

        // String are mutable programme - Here Reference updated so does the value

        String mutable = "Immutable String";

        mutable = mutable.concat("Mutable");

        //Prints Mutable
        System.out.println(immutable);

        // Strings using char array by using charset as optional param Default charset UTF-8

        byte[] b_arr = {71, 101, 101, 107, 115};
        Charset cs = Charset.defaultCharset();
        String s_byte_char = new String(b_arr, cs); //Prints Geeks

        // Forms a String from char array

        byte[] char_arr = {'S', 't', 'r', 'i', 'n', 'g'};
        String string_byte_char = new String(char_arr); //Prints String

        String string_byte_char_2 = new String(char_arr, 1, 3); //Prints tri

    }
}
