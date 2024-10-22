package dsa.thirdTen;
// Given input Strings and form the given output.
// String one = "ABC", String two = "DEFGH", output = "ADBECFGH"
public class ProblemSeven {
    public static void main(String[] args) {

        String one = "ABC";
        String two = "DEFGH";
        int number = Math.min(one.length(), two.length());
        int i=0;
        StringBuilder sb = new StringBuilder();
        while (i<number){
            sb.append(one.charAt(i)).append(two.charAt(i));
            i++;
        }
        sb.append(two.substring(number));
        System.out.println(sb.toString());

        char[] array1 = one.toCharArray();
        char[] array2 = two.toCharArray();
        int m=0;
        StringBuilder stringBuilder = new StringBuilder();
        for(int j=0; j<(Math.max(one.length(),two.length())); j++){
            try{
                stringBuilder.append(array1[m]);
                stringBuilder.append(array2[m]);
            } catch (Exception e) {
                if(array1.length < array2.length){
                    stringBuilder.append(array2[m]);
                }
                else{
                    stringBuilder.append(array1[m]);
                }
            }
            m++;
        }
        System.out.println(stringBuilder.toString());
    }
}
