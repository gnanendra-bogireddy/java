package dsa.thirdTen;

import java.util.Arrays;

// Remove all the trailing 0 from Array. input = [0,20,8,0,0,9,0,12,0,0,0,0,0]; output = [0,20,8,0,0,9,0,12]
public class ProblemNine {
    public static void main(String[] args) {
        int[] array = {0,20,8,0,0,9,0,12,0,0,0,0,0};
        int position = 0;
        for(int i= array.length -1; i>=0; i--){
            if(array[i] == 0){
            }
            else{
                position = i;
                break;
            }
        }
        int[] copyArray = Arrays.copyOfRange(array, 0, position + 1);
        System.out.println(Arrays.toString(copyArray));
    }
}
