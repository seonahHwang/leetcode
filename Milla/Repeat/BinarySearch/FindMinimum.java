package Milla.Repeat.BinarySearch;

public class FindMinimum {
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3,4,5,6,1,2}));
        System.out.println(findMin(new int[]{4,5,0,1,2,3}));
    }
    public static int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r){
            int mid = (r+l)/2;
            if(nums[l] < nums[r]) return nums[l];
            if(nums[mid] >= nums[l]) l = mid + 1;
            else r = mid;
        }
        return nums[l];
    }
}
