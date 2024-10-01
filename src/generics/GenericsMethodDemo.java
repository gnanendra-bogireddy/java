package generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsMethodDemo<T> {

    T type;

    public GenericsMethodDemo(T type) {
        this.type = type;
    }

    // We need to make sure give what ever in the angle brackets before return type.
    public <T> void methodOne(T var) {
        System.out.println("Printing inside method : " + var);
    }

    // We need to make sure give what ever in the angle brackets before return type.
    // We can use multiple arguments also.
    public <T, V> void methodTwo(T var, V varTwo) {
        System.out.println("Printing inside method : " + var);
        System.out.println("Printing inside method : " + varTwo);
    }

    // We can return type of T also.
    // Wild cards (?) can take anything. If you are sure about type just put ?
    public void printList(List<?> printList) {
        System.out.println(printList);
    }

    public static void main(String[] args) {
        GenericsMethodDemo<String> genericsMethodDemo = new GenericsMethodDemo<>(new String("100"));
        genericsMethodDemo.methodOne(24);
        genericsMethodDemo.methodOne("24");
        genericsMethodDemo.methodOne(24.4);
        genericsMethodDemo.methodTwo("John", 24);

        List<Integer> integerList = new ArrayList<>();
        integerList.add(3);
        genericsMethodDemo.printList(integerList);

        List<GenericsMethodDemoTwo> diffList = new ArrayList<>();
        diffList.add(new GenericsMethodDemoTwo<>(new One(), new Two()));
        genericsMethodDemo.printList(diffList);

    }
}

// We can declare with two type parameters also.
class GenericsMethodDemoTwo<T, V> {

    public GenericsMethodDemoTwo(T typeOne, V typeTwo) {

    }
}

class One {

}

class Two {

}
