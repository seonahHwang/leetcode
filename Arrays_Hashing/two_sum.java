package Arrays_Hashing;

import java.util.Arrays;
import java.util.HashMap;

/*
Explore
input: array[int]
output: boolean - check if the given array has the duplicated number or not

Clarifying Questions
1. Can the same number appear more than 2 times? -> Yes
2. Can the array have the negative numbers? -> Yes

Test Cases
[1,2,3,1] -> True
[1,2,3,4] -> False

        [] -> False
[1] -> False

        Brainstrom
1. Brute force -> double for-loop O(N^2)
2. Use set -> O(N)

Plan
1. Initialize the set
2. Iterate over the array
    2-1. For each element, check if it's in the set.
        2-2. Return True if the element is in the set
        2-3. Otherwise, add the element to the set.
        3. return False since no duplicates are found.

        =>TC: O(N), SC: O(N)
*/
public class two_sum {
    public static void main(String[] args) {
//        int arr[] = {2,7,11,15};
        int arr[] = {3,2,4};
//        int t = 9;
        int t = 6;
        System.out.println(Arrays.toString(twoSum(arr,t)));;
    }
//    public static int[] twoSum(int[] nums, int target) {
//        int sum = 0;
//        int[] ans = new int[2];
//
//        for(int i=0;i<nums.length;i++){
//            for(int j=i+1;j<nums.length;j++){
//                sum = nums[i] + nums[j];
//                if(sum == target){
//                    ans[0] = i;
//                    ans[1] = j;
//                    break;
//                }
//            }
//        }
//        return ans;
//    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int ans[] = new int[2];

        for(int i=0;i<nums.length;i++) {
            map.put(nums[i], i);
        }
        int a = 0;
        int idx = 0;

        for (int i=0;i<nums.length;i++){
            a = target - nums[i];
            if(map.containsKey(a)){
                idx = (int) map.get(a);
                if(i == idx) continue;
                ans[0] = i;
                ans[1] = idx;
                break;
            }
        }

        return ans;
    }
}
