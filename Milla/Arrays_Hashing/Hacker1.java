package Milla.Arrays_Hashing;

import java.util.List;

public class Hacker1 {
    public static void miniMaxSum(List<Integer> arr) {
        long min = Integer.MAX_VALUE;
        long max = Integer.MIN_VALUE; //-1381747223
        long total = 0;

        for (Integer integer : arr) {
            min = Math.min(min, integer);
            max = Math.max(max, integer);
            total += integer;
        }
        System.out.println("min:"+min);
        System.out.println("total:"+total);
        System.out.print(total - max+" ");
        System.out.print(total - min);
    }
}
