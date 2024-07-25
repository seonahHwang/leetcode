package Milla.Repeat.BinarySearch;

public class FindTarget {
    public static void main(String[] args) {
        System.out.println(search(new int[]{3,4,5,6,1,2}, 1));
    }
//    public static int search(int[] nums, int target) {
//        int l = 0;
//        int r = nums.length - 1;
//        int ans = 0;
//
//        while (l < r){
//            int mid = (r+l)/2;
//            if(nums[l] < nums[r]) {
//                if(target < mid){
//                    r = mid - 1;
//                }else if(target > mid) l = mid + 1;
//                else return mid;
//            }
//            if(nums[mid] >= nums[l]) l = mid + 1;
//            else r = mid;
//        }
//        return ans;
//    }
public int search(int[] nums, int target) {
    int l = 0; // 배열의 시작 인덱스
    int r = nums.length - 1; // 배열의 마지막 인덱스

    while (l <= r){
        int mid = (l + r)/2;
        if(nums[mid] == target) return mid;
        if(nums[l] <= nums[mid]){
            //오른쪽으로 이동
            if(target < nums[mid] || target < nums[r]) l = mid + 1;
        }else {

        }
    }
    return -1;
}

}
