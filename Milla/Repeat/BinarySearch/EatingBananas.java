package Milla.Repeat.BinarySearch;

import java.util.Arrays;

public class EatingBananas {
    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{1,4,3,2},9));
//        System.out.println(minEatingSpeed(new int[]{3,6,7,11},8)); //4
//        System.out.println(minEatingSpeed(new int[]{25,10,23,4},4));
    }
    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        int ans = right;

        int min = Integer.MAX_VALUE;
        int midRate = 0;
        while (left <= right){
            midRate = (right + left)/2;
            System.out.println("left "+left +", right : "+right + "midRate "+midRate);
            int total = 0;
            for (int i = 0; i < piles.length; i++) {
                total += Math.ceil((double) piles[i]/midRate);
            }
            System.out.println("total "+total);
            if(total <= h){
                System.out.println("더 작게");
                ans = midRate;
                right = midRate - 1;
            }
            else {
                System.out.println("더 크게");
                left = midRate + 1;
            }
        }
        return ans;
    }
}
