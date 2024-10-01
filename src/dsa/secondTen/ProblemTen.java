package dsa.secondTen;

// Print maximum occurrence word in a given sentence input = " bla bla;
public class ProblemTen {
    public static void main(String[] args) {

        String string = "A computer is a digital device. Computer used for"
                + "calculating maths and used extensively in a scientific research"
                + " Commuters can be used for general purpose. Comports used by humans and "
                + "machines both." + "Computer is a computing device";
        String[] str = string.split(" ");
        int frequency = 0;
        String print = "";
        for (String temp : str) {
            int count = 0;
            for (int i = 0; i < str.length; i++) {
                if (temp.equals(str[i])) {
                    count++;
                }
            }
            if (count > frequency) {
                print = temp;
                frequency = count;
            }
        }
        System.out.println(print);
    }
}
