package exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Checked Exceptions are like a strict teacher checking your homework!
 * 
 * The Java compiler (the teacher) says: 
 * "I see you are trying to open a file. BUT what if the file isn't there?! 
 * You MUST write code to handle that problem, or I won't let you run this program!"
 * 
 * We call these "Checked" because Java *checks* them before you even press Play.
 */
public class CheckedException {
    
    // We add 'throws ExceptionName' to say: "Hey, I know this might break, 
    // but I'm warning you so you can be ready."
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        System.out.println("Trying to read a secret file...");
        
        try {
            // Trying to read a file that probably doesn't exist on your computer!
            FileReader file = new FileReader("C:\\super_secret_file_that_does_not_exist.txt");
            BufferedReader fileInput = new BufferedReader(file);
            System.out.println(fileInput.readLine());
            fileInput.close();
            
        } catch (IOException e) {
            // Because we used 'try-catch', the program doesn't crash! It just says oops.
            System.out.println("Oops! The file is missing! (This is our caught exception)");
            /*
             * Expected Output:
             * Trying to read a secret file...
             * Oops! The file is missing! (This is our caught exception)
             */
        }
    }
}