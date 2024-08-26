package Milla.Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets {

    static List<List<Integer>> ans;
    public static void main(String[] args) {
        subsets(new int[]{1,2,3});
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(nums, 0, subset, res);
        return res;
    }

    private static void dfs(int[] nums, int i, List<Integer> subset, List<List<Integer>> res) {
        if (i >= nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        dfs(nums, i + 1, subset, res);
        subset.remove(subset.size() - 1);
        dfs(nums, i + 1, subset, res);
    }

//    public static List<List<Integer>> subsets(int[] nums) {
//        ans = new ArrayList<>();
//        LinkedList<Integer> list = new LinkedList();
//        for (int i = 0; i < nums.length; i++) {
//            list.add(nums[i]);
//            dfs(nums,list,i);
//            list.removeLast();
//        }
//        ans.add(new ArrayList<>());
//        return ans;
//    }
//
//    public static void dfs(int[] nums, LinkedList<Integer> list, int idx){
//        if(list.size() > 0 ){
//            List<Integer> list2 = new ArrayList<>();
//            list2.addAll(list);
//            ans.add(list2);
//        }
//        if(nums.length == list.size()) return;
//
//        for (int i = idx+1; i < nums.length; i++) {
//            list.add(nums[i]);
//            dfs(nums,list,i);
//            list.removeLast();
//        }
//    }
}
