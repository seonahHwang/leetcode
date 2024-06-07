package Milla.Stack;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {
    static List<String> res;

    public static void main(String[] args) {
        res = new LinkedList<>();
        generateParenthesis(3);
    }
    public static List<String> generateParenthesis(int n) {
        backtrack(0,0,n,"");
        return res;
    }

    public static void backtrack(int left, int right, int n, String str){
        if(left == n && right == n){
            res.add(str);
            return;
        }

        if(left < n){
            backtrack(left+1,right,n,str+"(");
        }
        if(right < left){
            backtrack(left,right+1,n,str+")");
        }
    }
}
