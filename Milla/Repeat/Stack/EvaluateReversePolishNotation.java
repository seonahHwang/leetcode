package Milla.Repeat.Stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"1","2","+","3","*","4","-"}));
    }
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String str : tokens) {
            if(str.equals("+")){
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2+num1);
            }else if(str.equals("-")){
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2-num1);
            }else if(str.equals("*")){
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2*num1);
            }else if(str.equals("/")){
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2/num1);
            }else {
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }
}
