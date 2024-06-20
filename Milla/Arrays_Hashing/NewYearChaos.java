package Milla.Arrays_Hashing;

import java.util.Arrays;
import java.util.List;

public class NewYearChaos {
    public static void main(String[] args) {
//        Integer arr[] = {2, 1, 5, 3, 4};
//        Integer arr[] = {2, 5, 1, 3, 4};
//        Integer arr[] = {1,2,3,5,4,6,7,8};
        Integer arr[] = {1, 2, 5, 3, 7, 8, 6, 4}; //7
        minimumBribes(Arrays.asList(arr));
    }
    public static void minimumBribes(List<Integer> q) {
        int cnt = 0;
        int total = 0;
        // Write your code here
        for (int i = 0; i < q.size(); i++) {
            cnt = 0;
            if(q.get(i) > i + 1){
                cnt = q.get(i) - (i+1);
                System.out.println("q.get(i) "+q.get(i));
                System.out.println("cnt :: "+ cnt);
            }
            if(cnt > 2) {
                System.out.println("Too chaotic");
                return;
            }
            else total += cnt;
        }

        System.out.println(total);
    }
}
