package inputOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Java Program for taking user
// input using BufferedReader Class
public class BufferedReaderExample {
    // Main Method
    public static void main(String[] args) throws IOException {
        // Creating BufferedReader Object
        // InputStreamReader converts bytes to
        // stream of character
        BufferedReader bfn = new BufferedReader(new InputStreamReader(System.in));

        // String reading internally
        String str = bfn.readLine();

        // Integer reading internally
        int it = Integer.parseInt(bfn.readLine());

        // Printing String
        System.out.println("Entered String : " + str);

        // Printing Integer
        System.out.println("Entered Integer : " + it);
    }
}

