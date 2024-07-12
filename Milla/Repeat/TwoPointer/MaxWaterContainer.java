package Milla.Repeat.TwoPointer;

public class MaxWaterContainer {
    public static void main(String[] args) {

    }
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int max = Integer.MIN_VALUE;

        while (l < r){
            int h = Math.min(heights[l],heights[r]);
            int area = (r-l)*h;
            max = Math.max(max,area);
            if(heights[l] > heights[r]) r--;
            else l++;
        }
        return max;
    }
}
