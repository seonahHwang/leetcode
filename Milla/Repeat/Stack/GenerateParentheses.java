package Milla.Repeat.Stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {
    public static void main(String[] args) {

    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        backtrack(n,0,0,stack,res);
        return res;
    }
    public void backtrack(int n, int openN, int closeN, Stack<Character> stack, List<String> res){
        if(openN == closeN && n == openN){
            StringBuilder sb = new StringBuilder();
            for(char c : stack){
                sb.append(c);
            }
            res.add(sb.toString());
            return;
        }

        if(openN < n){
            stack.push('(');
            backtrack(n,openN+1,closeN,stack,res);
            stack.pop();
        }
        if(closeN < openN){
            stack.push(')');
            backtrack(n,openN,closeN+1,stack,res);
            stack.pop();
        }
    }
}
