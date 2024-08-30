package Milla.Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PhoneNumber {
    public static void main(String[] args) {
        letterCombinations("34");
    }
    public static List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<>();
        List<String> ans = new ArrayList<>();
        char[][] arr = new char[][]{{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
        dfs(digits, new LinkedList<>(),ans,arr,0);

        return ans;
    }
    public static void dfs(String digits, LinkedList<Character> sub, List<String> ans, char[][] arr, int digitIdx){
        if(sub.size() == digits.length()){
            String s = "";
            for (int i = 0; i < sub.size(); i++) {
                s += sub.get(i);
            }
            ans.add(s);
            return;
        }

        System.out.println("digitIdx "+digitIdx);
        int numIdx = digits.charAt(digitIdx) - 48;
        System.out.println("numIdx" +numIdx);
        for (int i = 0; i < arr[numIdx].length; i++) {
            sub.add(arr[numIdx][i]);
            System.out.println("///");

            dfs(digits,sub,ans,arr,digitIdx+1);
            sub.removeLast();
        }
    }
}
