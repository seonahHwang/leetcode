package Milla.HashMap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CountTriplets {
    public static void main(String[] args) {
        List<Long> list = new LinkedList<>();
        list.add(1L);
        list.add(2L);
        list.add(2L);
        list.add(4L);
        System.out.println(countTriplets(list,2));
    }
    static long countTriplets(List<Long> arr, long r) {
        long answer = 0;
        Map<Long,Long> pairMap = new HashMap<>();
        Map<Long,Long> tripletMap = new HashMap<>();

        long num = 0;
        for (int i = 0 ; i < arr.size() ; i++){
            num = arr.get(i);
            if(tripletMap.containsKey(num)){
                answer += tripletMap.get(num);
            }
            if(pairMap.containsKey(num)){
                tripletMap.put(num*r,tripletMap.getOrDefault(num*r,0L)+pairMap.get(num));
            }
            pairMap.put(num*r,pairMap.getOrDefault(num*r,0L)+1);
        }
        return answer;
    }
}
