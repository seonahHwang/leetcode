package Milla.Others;

import java.util.HashMap;
import java.util.Map;

public class SherlockandtheValidString {
    public static void main(String[] args) {

    }
    public static String isValid(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Integer,Integer> countMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for (int num : map.values()){
            countMap.put(num,countMap.getOrDefault(num,0)+1);
        }

        if(countMap.size() > 2) return "NO";
        if(countMap.size() == 1) return "YES";

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int len : countMap.keySet()){
            max = Math.max(len,max);
            min = Math.min(len,min);
        }

        if(countMap.get(max) == 1 && max - min == 1) return "YES";
        if(countMap.get(min) == 1 && min == 1) return "YES";

        return "NO";
    }
}
