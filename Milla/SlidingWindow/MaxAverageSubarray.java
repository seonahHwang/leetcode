package Milla.SlidingWindow;

public class MaxAverageSubarray {
    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{1,12,-5,-6,50,3},4));
    }
    public static double findMaxAverage(int[] nums, int k) {
        double res = Integer.MIN_VALUE;
        double avg = 0;
        int left = 0;
        int sum = 0;
        double kk = k;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        avg = sum/kk;
        res = Math.max(avg,res);

        for (int right = k; right < nums.length; right++) {
            sum += nums[right];
            sum -= nums[left];

            avg = sum/kk;
            res = Math.max(avg,res);

            left++;
        }
        return res;
    }
}
