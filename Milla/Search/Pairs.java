package Milla.Search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Pairs { //leetcode 문제랑 굉장히 비슷하다. 찾아서 다시 풀어볼것 .
    public static void main(String[] args) {
        Integer a[] = {1, 5, 3, 4, 2};
        int k = 2;
        System.out.println(pairs(k, Arrays.asList(a)));
    }
    public static int pairs(int k, List<Integer> arr) {
        // Write your code here
        int answer = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < arr.size(); i++) {
            if(map.containsKey(arr.get(i) + k)){
                answer++;
            }
            if(map.containsKey(arr.get(i) - k)) answer++;
            map.put(arr.get(i),0);
        }
        return answer;
    }

}
