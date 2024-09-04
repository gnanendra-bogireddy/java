package wrapperClasses;

import java.util.ArrayList;

public class GeneralExample {
    public static void main(String[] args) {

        // Java program to demonstrate Autoboxing
        char ch = 'a';

        // Autoboxing- primitive to Character object
        // conversion
        Character a = ch;

        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        // Autoboxing because ArrayList stores only objects
        arrayList.add(25);

        // printing the values from object
        System.out.println(arrayList.get(0));

        Character chr = 'a';

        // unboxing - Character object to primitive
        // conversion
        char ab = chr;

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(24);

        // unboxing because get method returns an Integer
        // object
        int num = list.get(0);

        // printing the values from primitive data types
        System.out.println(num);

        // byte data type
        byte abc = 1;

        // Use with Java 9
        Byte byteobj = Byte.valueOf(abc);

        // int data type
        int bcd = 10;

        // Use with Java 9
        Integer intobj = Integer.valueOf(bcd);

        // float data type
        float cde = 18.6f;

        // Use with Java 9
        Float floatobj = Float.valueOf(cde);

        // double data type
        double def = 250.5;

        // Use with Java 9
        Double doubleobj = Double.valueOf(def);

        // char data type
        char e = 'a';

        // wrapping around Character object
        Character charobj = e;

        // printing the values from objects
        System.out.println("Values of Wrapper objects (printing as objects)");
        System.out.println("\nByte object byteobj: " + byteobj);
        System.out.println("\nInteger object intobj: " + intobj);
        System.out.println("\nFloat object floatobj: " + floatobj);
        System.out.println("\nDouble object doubleobj: " + doubleobj);
        System.out.println("\nCharacter object charobj: " + charobj);

        // objects to data types (retrieving data types from
        // objects) unwrapping objects to primitive data
        // types
        byte bv = byteobj;
        int iv = intobj;
        float fv = floatobj;
        double dv = doubleobj;
        char cv = charobj;

        // printing the values from data types
        System.out.println("\nUnwrapped values (printing as data types)");
        System.out.println("\nbyte value, bv: " + bv);
        System.out.println("\nint value, iv: " + iv);
        System.out.println("\nfloat value, fv: " + fv);
        System.out.println("\ndouble value, dv: " + dv);
        System.out.println("\nchar value, cv: " + cv);

    }

}

