package Milla.BinarySearch;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FindMinimum {
    /*
    * Input: nums = [3,4,5,6,1,2]

        Output: 1
        Example 2:

        Input: nums = [4,5,0,1,2,3]

        Output: 0
        Example 3:

        Input: nums = [4,5,6,7]

        Output: 4
    *
    * 한글 설명
    * : 탐색 범위가 정렬된 상태라면 가장 왼쪽 값이 최소값이 된다. => 루프가 돌때마다, 정렬되어있는지를 확인 후 그렇다면 왼쪽값이 최소값인지 확인 후 반환한다. 종료.
    * 오른쪽포인터의 값이 중간 값보다 더 작다면, 오른쪽을 탐색해야한다.
    * 그 반대라면, 왼쪽을 탐색해야한다.
    * 그렇게 r과 l을 조정해나가다가, 타겟값을 찾듯 중간값이 최소값이 되는지를 계속 탐색한다.
    *
    * */
    public static void main(String[] args) {
        int a[] = {3,4,5,6,1,2};
        int b[] = {4,5,0,1,2,3};
        int c[] = {4,5,6,7};
        int d[] = {2,1};
//        System.out.println(findMin(a));
//        System.out.println(findMin(b));
//        System.out.println(findMin(c));
        System.out.println(findMin(d)); //1
    }
    public static int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int ans = nums[l];
        int m = 0;

        while (l <= r){
            m = (l+r)/2;
            System.out.println("m:"+m);
            if(nums[l] < nums[r]) { //범위를 좁혀서 l을 이동하게 됐을 때도 해당됨.
                ans = Math.min(ans, nums[l]);
                break;
            }

            ans = Math.min(ans, nums[m]);
            if(nums[m] > nums[r]){
                l = m + 1;
            }else {
                r = m - 1;
            }
        }
        return ans;
    }
}
