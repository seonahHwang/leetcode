package Milla.SlidingWindow;

public class LongestSubarrayAfterDeletingOneElement {
    /*
    * Input: nums = [1,1,0,1]
    Output: 3
    Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
    Example 2:

    Input: nums = [0,1,1,1,0,1,1,0,1]
    Output: 5
    Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].
    Example 3:

    Input: nums = [1,1,1]
    Output: 2
    Explanation: You must delete one element.
    *
    * */
    public static void main(String[] args) {
//        System.out.println(longestSubarray(new int[]{1,1,0,1}));
        System.out.println(longestSubarray(new int[]{0,1,1,1,0,1,1,0,1}));
        System.out.println(longestSubarray(new int[]{1,1,1}));
    }

    public static int longestSubarray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int left = 0;
        int zeroCnt = 0; //count of zero in the range

        //1, 1 ,0 ,1
        //l,       r
        //

        //zeroCnt = 1
        //max = 3

        for (int right = 0; right < nums.length; right++) {
            if(nums[right] == 0) zeroCnt++;
            while (zeroCnt > 1){
                if(nums[left] == 0) zeroCnt--;
                left++;
            }
            max = Math.max(max,right-left); //renew
        }

        return max; //3
    }
}
