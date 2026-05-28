package basics;

public class Loops {
    public static void main(String[] args) {


//        for (initialization; condition; increment/decrement) {
//            // code to be executed
//        }
        for (int i = 0; i <= 10; i++) {
            System.out.print(i + " ");
        }

//        for (dataType variable : arrayOrCollection) {
//            // code to be executed
//        }
        String[] names = {"Sweta", "Gudly", "Amiya"};

        for (String name : names) {
            System.out.println("Name: " + name);
        }

//        while (condition) {
//            // code to be executed
//        }
        int i = 0;
        while (i <= 10) {
            System.out.print(i + " ");
            i++;
        }

        for (int j = 0; j < 5; j++) {
            {
                if (j == 2) {
                    {
                        System.out.println();
                        // using continue keyword
                        // to skip the current iteration
                        continue;
                    }
                }
                System.out.println(j);
            }
        }

        int n = 10;
        for (int k = 0; k < n; k++) {
            if (k == 4)
                // using break keyword
                // to break the loop
                break;
            System.out.println(k);
        }
    }
}
