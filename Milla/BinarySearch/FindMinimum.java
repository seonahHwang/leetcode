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

    /*
    * Clarify
    * 이해한 내용 확인하기
    *
    * Brainstorm / approach
    * Binary search
    *
    * Plan
    * 1. with two pointers, one at the beginning and one at the end of the array.
    * 2. calculate the middle index.
    * 3. if the middle is greater than left pointer then, the minimum element must be in the right half of the array.
    * 4. Otherwise, it must be in the left half. We'll continue this process until we find the minimum element.
    *
    * Edge cases
    * an empty array -> should I return 0?
    * an array with all elements being the same -> should I return one element?
    * an array with only two elements -> should I compare two of them?
    *
    * TC
    * O(logN)
    *
    * SC
    * O(1)
    *
    * Dry run
    *
    * */
    public static void main(String[] args) {
        int a[] = {3,4,5,6,1,2};
        int b[] = {4,5,0,1,2,3};
        int c[] = {4,5,6,7};
        int d[] = {2,1};
        System.out.println(findMin(d)); //
    }
    public static int findMin(int[] nums) {
        int l = 0;
        // Initializes a left pointer 'l' to the beginning of the array.
        int r = nums.length - 1;
        // Initializes a right pointer 'r' to the end of the array.

        while (l < r) {
            // Continues the loop as long as the left pointer is less than the right pointer.
            int mid = (r + l) / 2;
            // Calculates the middle index of the current subarray to divide possible space
            if (nums[l] < nums[r]) {
                // If the element at the left is smaller than the element at the right,
                // the array is not rotated and the minimum element is at the beginning.
                return nums[l];
            }
            if (nums[mid] >= nums[l]) {
                // If the middle element is greater than or equal to the left element,
                // the minimum element is in the right half.
                l = mid + 1;
            } else {
                // Otherwise, the minimum element is in the left half.
                r = mid;
            }
        }
        return nums[l];
        // When the loop terminates, the left and right pointers will be pointing to the same index,
        // which is the index of the minimum element.
    }
}
