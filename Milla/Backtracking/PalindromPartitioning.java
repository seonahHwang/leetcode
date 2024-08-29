package Milla.Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PalindromPartitioning {
    public static void main(String[] args) {
        partition("aabb");
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        dfs(s,0,new LinkedList<>(),ans);
        return ans;
    }

    public static void dfs(String s, int start, LinkedList<String> sub, List<List<String>> ans){
        if(start >= s.length()){
            System.out.println("-------");
            ans.add(new ArrayList<>(sub));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String subStr = s.substring(start,i+1);

            if(chk(s,start,i)){
                System.out.println("start : "+start +", end : "+(i+1) +", str: "+subStr);
                sub.add(subStr);
                dfs(s,i+1,sub,ans);
                sub.removeLast();
            }
        }
    }

    public static boolean chk(String subStr, int l, int r){
        while (l<r){
            if(subStr.charAt(l) != subStr.charAt(r)) return false;
            l++;
            r--;
        }

        return true;
    }


}
