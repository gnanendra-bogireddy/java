package generics;

// Generics can take anything passes to it.
// It is introduced to remove Type safety issues.
// It increases code re-usability, and it can any type
// We can define generics by '<anything>' general convention is T, stands for Type
// We can restrict the Type of Object passed to the class by using extends after Type parameter (T)
// We can use class and interface names using same keyword extends but make sure use class name first.
public class GenericsDemo<T extends Parent> {

    T thingToPrint;

    public GenericsDemo(T thingToPrint) {
        this.thingToPrint = thingToPrint;
    }

    public void print() {
        System.out.println("Something to Print : " + thingToPrint);
    }

    public static void main(String[] args) {
        GenericsDemo<ChildOne> genericsDemo1 = new GenericsDemo<>(new ChildOne());
        System.out.println("Printing object address of Child One : " + genericsDemo1.thingToPrint);
        GenericsDemo<ChildTwo> genericsDemo2 = new GenericsDemo<>(new ChildTwo());
        System.out.println("Printing object address of Child One : " + genericsDemo2.thingToPrint);

        // Passing ChildThree object which is not extends Parent class
//        GenericsDemo<ChildThree> genericsDemo3 = new GenericsDemo<>(new ChildThree());

        // Now every method inside Parent class is available inside variable called thingToPrint
        // Because it is extending parent class
        // If we have one more class which is extending type of T
        // <T extends Class & interface>
        genericsDemo1.thingToPrint.printTwo();

    }

}

class ChildOne extends Parent {

}

class ChildTwo extends Parent {

}

class ChildThree {

}

class Parent {

    public void printTwo() {
        System.out.println("Printing inside parent class method");
    }


}
