package oop;

public class ConstructorExample {

    String name;

    // Default Constructor
    ConstructorExample(){
        System.out.println("Default constructor");
    }

    // Constructor
    ConstructorExample(String name) {
        this.name = name;
    }

    int id =0;
    // Parameterized Constructor
    ConstructorExample(String name, int id)
    {
        this.name = name;
        this.id = id;
    }

    void display() {
        System.out.println("Name: " + name);
    }

    public static void main(String[] args) {
        ConstructorExample s1 = new ConstructorExample("Vishnu");
        s1.display();

    }

    class Geeks{

        // constructor with one argument
        Geeks(String name){

            System.out.println("Constructor with one "
                    + "argument - String: " + name);
        }

        // constructor with two arguments
        Geeks(String name, int age){

            System.out.println(
                    "Constructor with two arguments: "
                            + " String and Integer: " + name + " " + age);
        }

        // Constructor with one argument but with different
        // type than previous
        Geeks(long id)
        {
            System.out.println(
                    "Constructor with one argument: "
                            + "Long: " + id);
        }
    }

}
