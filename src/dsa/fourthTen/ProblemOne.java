package dsa.fourthTen;
// Find the indices that sum to target.
// Array input = [1,8,11,15] and target = 9
public class ProblemOne {
    public static void main(String[] args) {
       int[] array = {1,8,11,15};
       int target = 19;
       int first = 0;
       int second = 0;
       aa: for(int i=0; i<array.length; i++){
           int temp = array[i];
           first = i;
           for(int j=0; j< array.length; j++){
               if(i!=j ){
                   second = j;
                   if(array[j] == (target - temp)){
                       break aa;
                   }
               }
           }
        }
        System.out.println(first + " " + second);
    }
}
