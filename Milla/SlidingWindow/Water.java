package Milla.SlidingWindow;

public class Water {
    public int maxArea(int[] height) {
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        int area = 0;

        while (left < right){
            int h = Math.min(height[left],height[right]);
            area = (right-left)*h;
            res = Math.max(res,area);

            if(height[left] < height[right]) left++;
            else right--;
        }

        return res;
    }
}
