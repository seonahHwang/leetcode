package Milla.Heap;

public class KthLargestElementInanArray {

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{2,3,1,5,4},3));
    }
    public static int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int left = 0, right = nums.length -1;
        int pivot = nums[right];

        while (left < right){ //이진탐색처럼
            pivot = partition(nums,left,right);
            if(pivot < k){
                left = pivot + 1;
            }else if(pivot > k){
                right = pivot - 1;
            }else {
                break;
            }
        }
        return nums[k];
    }

    private static int partition(int[] nums, int left, int right){
        int fill = left;
        int pivot = nums[right];

        for (int i = left; i < right; i++) {
            if(nums[i] <= pivot){
                int tmp = nums[fill];
                nums[fill++] = nums[i];
                nums[i] = tmp;
            }
        }
        nums[right] = nums[fill];
        nums[fill] = pivot;
        return fill;
    }
}
