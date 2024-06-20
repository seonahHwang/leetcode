package Milla.Greedy;

import java.util.Arrays;
import java.util.List;

public class MaxMin {
    public static void main(String[] args) {
        Integer arr[] = new Integer[]{1,2,3,4,10,20,30,40,100,200};
        List<Integer> list = Arrays.asList(arr);
        int k = 4;
        System.out.println(maxMin(k,list));
    }
    public static int maxMin(int k, List<Integer> arr) {
        int array[] = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            array[i] = arr.get(i);
        }
        Arrays.sort(array);

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            if(i+k-1 < array.length){
                for(int j = i ; j < i+k ; j++){
                    min = Math.min(min,array[j]);
                    max = Math.max(max,array[j]);
                }
                System.out.println("max : "+max);
                System.out.println("min : "+min);
                answer = Math.min(answer,max-min);
            }
        }
        return answer;
    }
}
