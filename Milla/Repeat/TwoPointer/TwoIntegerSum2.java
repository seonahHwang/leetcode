package Milla.Repeat.TwoPointer;

import java.util.Arrays;

public class TwoIntegerSum2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{1,2,3,4},8)));
    }
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int ans[] = new int[2];

        while (left < right){
            int sum = numbers[left] + numbers[right];
            if(sum == target) {
                ans[0] = left + 1;
                ans[1] = right + 1;
                return ans;
            }
            else if(sum < target) left++;
            else right--;
        }
        return new int[0];
    }
}
