package Milla.Arrays_Hashing;

public class MinimumSwaps {
    public static void main(String[] args) {
        int a[] = {7, 1, 3, 2, 4, 5, 6};
        System.out.println(minimumSwaps(a));
    }
    static int minimumSwaps(int[] arr) {
        int i = 0;
        int temp = 0;
        int min = 0;

        while(i < arr.length){
            if(arr[i] != i+1){
                temp = arr[i];
                arr[i] = arr[arr[i]-1];
                arr[temp-1] = temp;
                min++;
            }else {
                i++;
            }
        }
        return min;
    }
}
