package strings;

public class StringBufferExample {
    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer();

        StringBuffer sbTwo = new StringBuffer("Java");

        // String buffer append method
        sb.append("Hello");
        sb.append(" ");
        sb.append("world");
        sb.append(" ");
        sb.append(sbTwo,0,4); // Adds Java to string
        String message = sb.toString();
        System.out.println(message); // prints Hello world Java

        // Insert method inserts new string or chars at given position
        StringBuffer insertSrting = new StringBuffer("Hello ");
        insertSrting.insert(1, "Java"); // Prints HJavaello

        // Now original string is changed
        System.out.println(insertSrting); // Prints HJavaello

        // Replace method replace given string with corresponding position
        StringBuffer replaceString = new StringBuffer("Hello");
        replaceString.replace(1, 3, "Java");
        System.out.println(replaceString); // Prints HJavalo

        // Delete method deletes chars at given positions
        StringBuffer deleteString = new StringBuffer("Hello");
        deleteString.delete(1, 3);
        System.out.println(deleteString); // Prints Hlo

        //Reverse method prints chars in reverse order
        StringBuffer stringReverse = new StringBuffer("Hello");
        stringReverse.reverse();
        System.out.println(stringReverse); //Prints olleH

        // String capacity ensures capacity is increases with addition of new chars
        StringBuffer capacity = new StringBuffer();
        System.out.println(capacity.capacity()); // default 16
        capacity.append("Hello");
        System.out.println(capacity.capacity()); // now 16
        capacity.append("java is my favourite language");
        System.out.println(capacity.capacity());
        // Now (16*2)+2=34     i.e (oldcapacity*2)+2

    }
}
