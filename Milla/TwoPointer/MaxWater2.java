package Milla.TwoPointer;

public class MaxWater2 {
    public static void main(String[] args) {

    }
    public int maxArea(int[] heights) {
        int max = Integer.MIN_VALUE;
        int l = 0;
        int r = heights.length-1;

        while (l<r){
            int w = r-l;
            int h = Math.min(heights[l],heights[r]);
            max = Math.max(h*w,max);

            if(heights[l] < heights[r]){
                l++;
            }else {
                r--;
            }
        }

        return max;
    }
}
