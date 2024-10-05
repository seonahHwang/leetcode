package Milla.SlidingWindow;

import java.util.HashMap;

public class MaxNumberOf2Pairs {
    public static void main(String[] args) {
        System.out.println(maxOperations(new int[]{2,2,2,3,1,1,4,1},4));
        System.out.println(maxOperations(new int[]{1,2,3,4},5));
        System.out.println(maxOperations(new int[]{3,1,3,4,3},6));
        System.out.println(maxOperations(new int[]{3,5,1,5},2));
    }
    public static int maxOperations(int[] nums, int k) {
        int operations = 0;
        HashMap<Integer,Integer> freqMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = k - nums[i];
            if(freqMap.getOrDefault(diff,0) > 0){
                freqMap.put(diff, freqMap.getOrDefault(diff,0)-1);
                operations++;
            }
            else freqMap.put(nums[i],freqMap.getOrDefault(nums[i],0)+1);
        }

        return operations;
    }
}
