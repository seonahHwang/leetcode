package Milla.TwoPointer;

import java.util.Arrays;

public class TwoIntegerSum2 {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4};
        int tar = 3;
        System.out.println(Arrays.toString(twoSum(arr,tar)));
    }
    public static int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        int sum = 0;
        while (left <= right){
            sum = numbers[left] + numbers[right];
            if(sum == target){
                ans[0] = left;
                ans[1] = right;
                break;
            }
            if(sum < target) left++;
            if(sum > target) right--;
        }
        return ans;
    }
}
