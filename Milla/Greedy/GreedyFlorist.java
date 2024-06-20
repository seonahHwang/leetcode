package Milla.Greedy;

import java.util.Arrays;

public class GreedyFlorist {
    public static void main(String[] args) {
        int cost[] = {1,3,5,6,7,9}; //29
        int k = 3;
        System.out.println(getMinimumCost(k,cost));
    }

    static int getMinimumCost(int k, int[] c) {
        Arrays.sort(c);
        int n = c.length;
        int minPrice = 0;
        int friendIdx = 0;

        int[] trackPrice = new int[k];

        for(int i = n - 1 ; i >= 0 ; i--){
            friendIdx = (n - i - 1) % k;
            trackPrice[friendIdx]++; //A라는 친구가 두번째 살때는 2배를, 3번째 살때는 3배를 받기 위함.
            minPrice += trackPrice[friendIdx]*c[i];
        }
        return minPrice;
    }
}
