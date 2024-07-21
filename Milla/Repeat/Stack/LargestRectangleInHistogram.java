package Milla.Repeat.Stack;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }

    public static int largestRectangleArea(int[] heights) {
        int maxArea = Integer.MIN_VALUE;
        int start = 0;
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < heights.length; i++) {
            start = i;
            while (!stack.isEmpty() && stack.peek()[1] > heights[i]){
                int pair[] = stack.pop();
                int idx = pair[0];
                int h = pair[1];
                int w = i - idx;
                start = idx;
                maxArea = Math.max(maxArea,h*w);
            }
            stack.push(new int[]{start, heights[i]});
        }

        for(int [] a : stack){
            int idx = a[0];
            int h = a[1];
            int w = heights.length - idx;
            maxArea = Math.max(maxArea,h*w);
        }
        return maxArea;
    }

}
