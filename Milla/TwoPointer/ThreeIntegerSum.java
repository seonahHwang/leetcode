package Milla.TwoPointer;

import java.util.Arrays;
import java.util.List;

//twopointer에 대해서 정리하기!
public class ThreeIntegerSum {
    public static void main(String[] args) {

    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int target = -nums[i];
            int l = i+1;
            int r = nums.length -1;
            while (l<r){
                int sum = nums[l] + nums[r];
            }
        }
    }
}
