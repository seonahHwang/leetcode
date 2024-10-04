package Milla.Repeat.Array;

import java.util.Arrays;

public class Product {
    /*
     * Brainstorm
     * left부터 현재 인덱스 전까지 곱 * 현재 인덱스 다음부터 right까지 곱
     *
     * Plan
     * 1. 배열을 반복문으로 돌면서 각 곱을 계산하고 left[] right[] 배열 두개를 만들어서 양 사이드의 곱을 저장함.
     * 2. left[i]*right[i]를 곱하여 결과 배열을 구성한다.
     *
     * Edge cases
     * if nums is null -> return null
     * if nums has only one value -> return value right away
     *
     * TC
     * O(N) -> go through as long as length of array
     *
     * SC
     * O(N) -> create two array to store product. the length of array is going to be same as length of nums
     *
     * Dry run
     * */

    public static void main(String[] args) {
        productExceptSelf(new int[]{1,2,4,6});
    }
    public static int[] productExceptSelf(int[] nums) {
        int[] right = new int[nums.length];
        int[] left = new int[nums.length];
        int[] ans = new int[nums.length];

        Arrays.fill(left,1);
        Arrays.fill(right,1);
        int total = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            total *= nums[i];
            left[i+1] = total;
        }

        total = 1;
        for (int i = nums.length - 1; i > 0; i--) {
            total *= nums[i];
            right[i-1] = total;
        }
        for (int i = 0; i < nums.length; i++) {
            ans[i] = left[i]*right[i];
        }
        return ans;
    }
}
