package Milla.Greedy;

import java.util.Arrays;
import java.util.List;

public class MaxMin2 {
    public static void main(String[] args) {
        Integer a[] = {
                100,
                200,
                300,
                350,
                400,
                401,
                402};
        System.out.println(maxMin(3,Arrays.asList(a)));
    }

    public static int maxMin(int k, List<Integer> arr) {
        // Write your code here
        int array[] = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            array[i] = arr.get(i);
        }
        Arrays.sort(array);
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < array.length ; i++) {
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            if( i + k -1 < array.length){
                for (int j = i; j < i + k; j++) {
                    min = Math.min(array[j],min);
                    max = Math.max(array[j],max);
                }
                answer = Math.min(answer,max-min);
            }

        }
        return answer;
    }
}
