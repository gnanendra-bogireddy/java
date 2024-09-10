package oop.interfaces;

// Syntax of nested interfaces
// We need to make sure access specifiers are public for interfaces when we define inside interfaces.
interface first {
    interface second {
    }
}

// We can call second interface by first.second
class firstClass {
    interface interface_name {
    }
}

// We can call second interface by firstClass.interface_name
public class NestedInterfaces {
    interface NestedInterface {
        void show();
    }
}

interface OuterInterface {
    interface InnerInterface {
        void showtime();
    }
}


class TestClassOne implements NestedInterfaces.NestedInterface, OuterInterface.InnerInterface {
    public void show() {
        System.out.println("show method of interface");
    }

    public void showtime() {
        System.out.println("showtime method of interface");
    }

    public static void main(String[] args) {
        NestedInterfaces.NestedInterface object;
        object = new TestClassOne();
        object.show();

        OuterInterface.InnerInterface objectTwo;
        objectTwo = new TestClassOne();
        objectTwo.showtime();
    }
}