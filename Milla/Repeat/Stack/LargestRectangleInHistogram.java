package Milla.Repeat.Stack;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{7,1,7,2,2,4}));
    }

    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= heights.length ; i++) {
            int curHeight = i == heights.length ? 0 : heights[i];
            while (!stack.isEmpty() && curHeight < heights[stack.peek()]){
                int h = heights[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea,w*h);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
