package Milla.Repeat.Stack;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    private Integer min;
    private Integer sndMin;
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(-2);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }

    public MinStack() {
        this.stack = new Stack<>();
        this.min = Integer.MAX_VALUE;
        this.sndMin = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if(min >= val){
            stack.push(min);
            min = val;
        }
        stack.push(val);
    }

    public void pop() {
        int pop = stack.pop();
        if(pop == min){
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
