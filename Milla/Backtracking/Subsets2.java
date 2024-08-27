package Milla.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Subsets2 {
    /*
    Input: nums = [1,2,1]

Output: [[],[1],[1,2],[1,1],[1,2,1],[2]]
    * */

    //subset1과 비교하기 => 1은 중복구성 허용
    public static void main(String[] args) {
        subsetsWithDup(new int[]{1,2,1});
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums,new LinkedList<>(),ans,0);
        return ans;
    }
    
    public static void dfs(int[] nums, LinkedList<Integer> sub, List<List<Integer>> ans, int idx){
        ans.add(new ArrayList<>(sub));

        for (int i = idx; i < nums.length; i++) {
            if(i > idx && nums[i] == nums[i-1]) continue;
            sub.add(nums[i]);
            dfs(nums,sub,ans,i+1);
            sub.removeLast();
        }
    }
}
