package dsa.thirdTen;

// For a given input array and element find the first and last element of occurrence.
// input = [1,5,3,4,6,5,7,5,8,5] and element = 5
public class ProblemTen {
    public static void main(String[] args) {
        int[] array = {1,5,3,4,6,5,7,5,8,5,0,7};
        int element = 5;
        int first = 0, last = 0, count = 0;
        int position1 = 0;
        for(int i=0; i< array.length; i++){
            if(array[i] == element){
                first = last = i;
                count++;
                continue;
            }
            if(count == 1){
                position1 = first;   
            }
        }
        System.out.println(position1 + " " +last);
    }
}
