package exceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CheckedException {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // Reading file from path in local directory
        // This will throw java.io.FileNotFoundException - This is a subclass of IOException
        FileReader file = new FileReader("C:\\test\\a.txt");

        // Creating object as one of ways of taking input
        BufferedReader fileInput = new BufferedReader(file);

        // Printing first 3 lines of file "C:\test\a.txt"
        for (int counter = 0; counter < 3; counter++)
            // This will throw java.io.IOException
            System.out.println(fileInput.readLine());

        // Closing file connections
        // using close() method
        // This will throw java.io.IOException
        fileInput.close();

        // Class is not defined in workspace or classpath.
        Class.forName("Class1");   // Class1 is not defined

    }
}
