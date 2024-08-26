package Milla.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationTargetSum {
    public static void main(String[] args) {
        combinationSum(new int[]{2,5,6,9},9);
    }

    public static List<List<Integer>> combinationSum(int[] nums, int target){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, target, new LinkedList<>(), result, 0);
        return result;
    }

    //target과 비교해서 리턴하는게 아니라 remain을 계산해서 판단하는게 더 중요함! 그래서 정렬도 쓰고!
    private static void backtrack(int[] nums, int sum, int target, LinkedList<Integer> sub, List<List<Integer>> result, int start){
        if(sum == target){
            result.add(new LinkedList<>(sub));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (nums[i] > target - sum) break; //이 부분이 매우 중요함. 기저사례에서 길이로 체크하는 게 불가능함
            sub.add(nums[i]);
            backtrack(nums, sum + nums[i], target, sub, result, i);
            sub.removeLast();
        }
    }
}
