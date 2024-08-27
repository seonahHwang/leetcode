package Milla.Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        subsets(new int[]{1,2,3});
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList();
        dfs(nums, list, 0,ans);
        ans.add(new ArrayList<>());
        return ans;
    }

    public static void dfs(int[] nums, LinkedList<Integer> list, int idx,List<List<Integer>> ans){
        ans.add(new ArrayList<>(list));

        //subset은 따로 기저사례를 만들 필요가 없음!
//        if(list.size() > 0 ){
//            List<Integer> list2 = new ArrayList<>();
//            list2.addAll(list);
//            ans.add(list2);
//        }
//        if(nums.length == list.size()) return;

        for (int i = idx; i < nums.length; i++) { //i = idx부터
            list.add(nums[i]);
            dfs(nums,list,i+1,ans); //i+1로 넘기면, 호출하는 메서드에서 for문을 돌리지 않아도! 0번째부터 시작할 수 있다.
            list.removeLast();
        }
    }
}
