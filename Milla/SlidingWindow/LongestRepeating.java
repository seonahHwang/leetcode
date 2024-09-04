package Milla.SlidingWindow;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LongestRepeating {
    public static void main(String[] args) {
        System.out.println(characterReplacement("XYYX",2)); //4
    }
    public static int characterReplacement(String s, int k) {
        int l = 0;
        int ans = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;

        int[] arr = new int[27];

        for (int r = 0; r < s.length(); r++) {
            int c = s.charAt(r) - 'A';
            arr[c]++;
            max = Math.max(max, arr[c]);

            while (r-l-max+1 > k){ // +1이 중요
                c = s.charAt(l) - 'A';
                arr[c]--;
                l++;
            }
            ans = Math.max(ans,r-l+1);
        }

        return ans;
    }
}
