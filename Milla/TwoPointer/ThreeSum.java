package Milla.TwoPointer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
    /**
     * egde case
     * what if there is no combination to make zero => return empty list
     *
     * brainstorm
     * One of three each item is fixed, and find left two elements with two pointer.
     * Array is must sorted to make left, right pointer.
     *
     * plan
     * One of three each item is fixed using for loop.
     * Others are determined by while loop and two pointer.
     * There's no duplicated combination so, we need to skip duplicated element
     *
     * tc : O(n^2) , sc: O(n) 정렬 + O(K) 결과 저장 => O(n)
     */

    public static void main(String[] args) {
        int arr[] = {-1,0,1,2,-1,-4};
        List<List<Integer>> li = threeSum(arr);
        System.out.println();
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new LinkedList<>();

        for (int i = 0;i<nums.length-2; i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            int left = i + 1; //이미 지나온건 for문에서 선택한 인덱스가 봤기 때문에 i+1로 시작해도됨
            int right = nums.length - 1;

            while (left < right){
                int target = nums[i] + nums[left] + nums[right];
                if(target == 0){
                    ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while (nums[left] == nums[left+1]) left++;
                    while (nums[right] == nums[right-1]) right--;
                    left++;
                    right--;
                }else if(target < 0){
                    left++;
                }else {
                    right--;
                }
            }
        }
        return ans;
    }
}
