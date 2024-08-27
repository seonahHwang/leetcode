package Milla.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationTargetSum2 {
    public static void main(String[] args) {
        System.out.println();
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        boolean[] v = new boolean[candidates.length];
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        dfs(candidates,0,ans,new LinkedList<>(),target,v);
        return ans;
    }

    public static void dfs(int[] candidates, int idx, List<List<Integer>> ans, LinkedList<Integer> sub, int remain, boolean[] v){
        if(remain == 0){
            ans.add(new ArrayList<>(sub));
        }
        for (int i = idx; i < candidates.length; i++) {
            if(v[i]) continue;
            if(i > idx && candidates[i] == candidates[i-1]) continue;
            v[i] = true;
            sub.add(candidates[i]);
            dfs(candidates,i+1,ans,sub,remain-candidates[i],v);
            v[i] = false;
            sub.removeLast();
        }
    }
}