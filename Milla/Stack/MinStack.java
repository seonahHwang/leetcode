package Milla.Stack;

import java.util.Stack;

public class MinStack {
    /*
    *
    *
    * */
    static Stack<Integer> stack;
    static int min;
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        minStack.push(0);
        System.out.println(minStack.getMin()); // return 0
        minStack.pop();
        System.out.println(minStack.top());    // return 2
        System.out.println(minStack.getMin());
    }

    public MinStack() {
        min = Integer.MAX_VALUE;
        stack = new Stack<>();
    }

    public void push(int val) {
        if(val <= min){
            stack.push(min);
            min = val;
        }
        stack.push(val);
    }

    public void pop() {
        if(stack.pop() == min){
            int sndMin = stack.pop();
            min = sndMin;
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
