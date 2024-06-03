package Milla.Stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    /*
    * Edge case 연산자가 다른게 들어올 수 있는지
    * 스택이 비어있는데도 연산자가 계속들어올수 있는지
    * calculate using stack
    * */
    public static void main(String[] args) {
//        String s[] = {"1","2","+","3","*","4","-"};
        String s[] = {"1","2","+","3","*","4","-","-","-","-","-"};
        System.out.println(evalRPN(s));
    }
    public static int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int result = 0;
        int a = 0;
        int b = 0;

        for(int i = 0 ; i < tokens.length ; i++){
            if(st.isEmpty()) return 0;
            if(tokens[i].equals("+")){
                a = st.pop();
                b = st.pop();
                st.push(b+a);
            }else if(tokens[i].equals("-")){
                a = st.pop();
                b = st.pop();
                st.push(b-a);
            }else if(tokens[i].equals("*")){
                a = st.pop();
                b = st.pop();
                st.push(b*a);
            }else if(tokens[i].equals("/")){
                a = st.pop();
                b = st.pop();
                st.push(b/a);
            }else {
                int num = Integer.parseInt(tokens[i]);
                st.push(num);
            }
        }
        return st.pop();
    }
}
