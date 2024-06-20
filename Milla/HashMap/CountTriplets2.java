package Milla.HashMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountTriplets2 {
    public static void main(String[] args) {
//        Long[] arr = {1L, 3L, 9L, 9L, 27L, 81L};
        Long[] arr = {1L, 2L, 2L, 4L};
        List<Long> list = Arrays.asList(arr);
        System.out.println(countTriplets(list,2));
    }
    static long countTriplets(List<Long> arr, long r) {
        Map<Long,Long> pairs = new HashMap<>();
        Map<Long,Long> triplet = new HashMap<>();
        long answer = 0L;

        for (int i = 0; i < arr.size(); i++) {
            if(triplet.containsKey(arr.get(i))){
                answer += triplet.get(arr.get(i));
            }

            if(pairs.containsKey(arr.get(i))){
                long cnt = pairs.get(arr.get(i));
                triplet.put(arr.get(i)*r,triplet.getOrDefault(arr.get(i)*r,0L)+cnt);
            }
            pairs.put(arr.get(i)*r,pairs.getOrDefault(arr.get(i)*r,0L)+1);
        }

        return answer;
    }
}
