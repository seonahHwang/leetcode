package Milla.Arrays_Hashing;

import java.util.Arrays;

public class MinimumSwaps {
    public static void main(String[] args) {
        int a[] = {4, 3, 1, 2};
        System.out.println(minimumSwaps(a));
    }
    static int minimumSwaps(int[] arr) {
        int i = 0;
        int temp = 0;
        int min = 0;

        while(i < arr.length){
            if(arr[i] != i+1){
                temp = arr[i];
//                arr[i] = arr[arr[i]-1];
                arr[i] = arr[temp-1];
                arr[temp-1] = temp;
                min++;
                System.out.println(Arrays.toString(arr));
            }else {
                i++;
            }
        }
        return min;
    }
}
