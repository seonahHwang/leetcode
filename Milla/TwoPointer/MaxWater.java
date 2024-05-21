package Milla.TwoPointer;

public class MaxWater {
    /*
    * edge case
    * Negative numbers : there is no negative
    * Constraints:
        2 <= height.length <= 1000
        0 <= height[i] <= 1000
        *
    * Empty cases : height.lenght >= 2
    *
    * plan
    * compare left height and right height, move smaller one's pointer to make it bigger
    * calculate area size => (gap between left and right) * minimum height
    * compare the area size to find max area.
    *
    * TC : O(N), SC : O(N)
    * */
    public static void main(String[] args) {
//        int arr[] = {1,7,2,5,4,7,3,6};
        int arr[] = {2,2,2};
        System.out.println(maxArea(arr));
    }
    public static int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length -1;
        int ans = Integer.MIN_VALUE;
        int height = 0;
        int area = 0;
        while (left < right){
            height = Math.min(heights[left],heights[right]);
            area = height*(right-left);
            ans = Math.max(area,ans);

            if(heights[left] > heights[right]){
                right--;
            }else {
                left++;
            }
        }
        return ans;
    }
}
