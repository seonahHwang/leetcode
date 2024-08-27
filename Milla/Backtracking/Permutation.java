package Milla.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permutation {
    /*
    * Input: nums = [1,2,3]

Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

    * */
    public static void main(String[] args) {
        permute(new int[]{1,2,3});
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<Integer> sub = new LinkedList<>();

        if(nums.length == 0){
            ans.add(new ArrayList<>());
            return ans;
        }
        if(nums.length == 1){
            ans.add(Arrays.asList(nums[0]));
            return ans;
        }

        boolean[] v = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            v[i] = true;
            sub.add(nums[i]);
            dfs(nums,ans,sub,i,v);
            sub.removeLast();
            v[i] = false;
        }
        return ans;
    }

    public static void dfs(int[] nums, List<List<Integer>> ans, LinkedList<Integer> sub, int idx, boolean[] v){
        if(sub.size() == nums.length){
            ans.add(new LinkedList<>(sub));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(v[i]) continue;
            v[i] = true;
            sub.add(nums[i]);
            dfs(nums, ans, sub, i,v);
            sub.removeLast();
            v[i] = false;
        }
    }
}
