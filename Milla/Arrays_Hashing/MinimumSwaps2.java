package Milla.Arrays_Hashing;

import java.util.Arrays;

public class MinimumSwaps2 {
    public static void main(String[] args) {
        int a[] = {4, 3, 1, 2};
        System.out.println("결과:"+minimumSwaps(a));
    }

    static int minimumSwaps(int[] arr) {
        int result = 0;
        int tmp = 0;
        int i = 0;

        while (i < arr.length){
            if(arr[i] != i+1){ //다르면, 맞을때 까지 계속 값을 변경함!
                tmp = arr[i];
                arr[i] = arr[tmp - 1];
                arr[tmp - 1] = tmp;
                result++;
            }else { //맞으면 넘어가고
                i++;
            }
        }

        return result;
    }
}
