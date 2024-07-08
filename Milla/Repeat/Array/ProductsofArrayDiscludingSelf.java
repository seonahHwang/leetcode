package Milla.Repeat.Array;

import java.util.Arrays;

public class ProductsofArrayDiscludingSelf {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,4,6})));
    }
    public static int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] answer = new int[nums.length];

        Arrays.fill(left,1);
        Arrays.fill(right,1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                left[i] *= nums[j];
            }
            for (int j = i+1; j < nums.length; j++) {
                right[i] *= nums[j];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            answer[i] = left[i]*right[i];
        }
        return answer;
    }
}
