package Milla.Arrays_Hashing;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TwoDArray {
    public static void main(String[] args) {
        Integer a[] = {1, 1, 1, 0, 0, 0};

        List<List<Integer>> arr = new LinkedList<>();
        arr.add(Arrays.asList(1, 1, 1, 0, 0, 0));
        arr.add(Arrays.asList(0, 1, 0, 0, 0, 0));
        arr.add(Arrays.asList(1, 1, 1, 0, 0, 0));
        arr.add(Arrays.asList(0, 0, 2, 4, 4, 0));
        arr.add(Arrays.asList(0, 0, 0, 2, 0, 0));
        arr.add(Arrays.asList(10, 0, 1, 2, 4, 0));

        System.out.println(hourglassSum(arr));
    }

    public static int hourglassSum(List<List<Integer>> arr) {
        // Write your code here
        int[][] matrix = new int[6][6];
        int sum = 0;

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                sum = 0;
                for (int k = 0; k < 3; k++) {
                    for (int m = 0; m < 3; m++) {
                        if (k == 1 && m == 0 || k == 1 && m == 2) continue;
                        sum += arr.get(i + k).get(j + m);
                    }
                }
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }
}
