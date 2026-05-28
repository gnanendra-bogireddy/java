package methods;

public class MethodsExample {


//    returnType methodName(parameters) {
//        // method body
//        return value; // optional (only if returnType is not void)
//    }

    // An example method
    public void printMessage() {
        System.out.println("Hello, Geeks!");
    }

    public static void main(String[] args) {

        // Create an instance of the class
        // containing the method
        MethodsExample obj = new MethodsExample();

        // Calling the method
        obj.printMessage();
    }
}
