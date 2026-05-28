package methods;

public class CallStackExample {

        public static void D() {
            float d = 40.5f;
            System.out.println("In Method D");
        }

        public static void C() {
            double c = 30.5;
            System.out.println("In Method C");
        }

        public static void B() {
            int b = 20;
            C(); // Calling C
            System.out.println("In Method B");
        }

        public static void A() {
            int a = 10;
            B(); // Calling B
            System.out.println("In Method A");
        }

        public static void main(String[] args) {
            A(); // Start with function A
            D(); // Then call D
        }
}
