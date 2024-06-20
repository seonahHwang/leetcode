package Milla.Search;

import java.util.Arrays;
import java.util.HashMap;

public class TripleSum {
    public static void main(String[] args) {

        int a[] = {1,3,5,7};
        int b[] = {5,7,9};
        int c[] = {7,9,11,13};

        System.out.println(triplets(a,b,c)); //5가 정답

    }

    public static long triplets(int[] a, int[] b, int[] c) {
        int[] aSorted = Arrays.stream(a).distinct().sorted().toArray();
        int[] bSorted = Arrays.stream(b).distinct().sorted().toArray();
        int[] cSorted = Arrays.stream(c).distinct().sorted().toArray();
        int cnt = 0;

        for(int q : bSorted){
            long pCnt = getLessThanOrEqualToCount(a,q);
            long rCnt = getLessThanOrEqualToCount(c,q);
            cnt += pCnt*rCnt;
        }
        return cnt;
    }

    private static long getLessThanOrEqualToCount(int[] array, int value) {
        int mid = 0;
        int low = 0;
        int high = array.length; //배열의 마지막 위치까지 고려하기
        while(low<high){
            mid = (low + high) / 2;
            if(array[mid] <= value) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}
