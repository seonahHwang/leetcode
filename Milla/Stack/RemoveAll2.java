package Milla.Stack;

import java.util.Stack;

public class RemoveAll2 {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("pbbcggttciiippooaais",2));
    }
    public static String removeDuplicates(String s, int k) {
        StringBuilder result = new StringBuilder();
        char[] c = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if(!stack.isEmpty() && stack.peek() == c[i]){
                countStack.push(countStack.peek() + 1);
            }else {
                countStack.push(1);
            }
            stack.push(c[i]);
            if(!countStack.isEmpty() && countStack.peek() == k){
                for (int j = 0; j < k; j++) {
                    countStack.pop();
                    stack.pop();
                }
            }
        }

        while (!stack.isEmpty()){
            char cc = stack.pop();
            result.insert(0,cc);
        }

        return result.toString();
    }
}
