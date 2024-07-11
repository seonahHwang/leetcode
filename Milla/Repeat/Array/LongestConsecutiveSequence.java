package Milla.Repeat.Array;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {

    }
    public static int longestConsecutive(int[] nums) {
        if(nums.length == 0 || nums.length == 1) return nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,1);
        }
        int max = Integer.MIN_VALUE;
        int cnt = 1;
        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];
            while (map.containsKey(start+1)){
                start++;
                cnt++;
            }
            max = Math.max(max,cnt);
            cnt = 1;
        }
        return max;
    }
}
