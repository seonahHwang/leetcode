package Milla.Others;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class Stringmanipulation {
    public static void main(String[] args) {
        System.out.println(isValid("aaabbbcc"));
    }
    public static String isValid(String s) {
        // Write your code here
        Map<Character,Integer> charMap = new HashMap<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            charMap.put(c,charMap.getOrDefault(c,0)+1);
        }
        for (int count : charMap.values()){
            map.put(count, map.getOrDefault(count,0)+1);
        }
        if(map.size() > 2) return "NO";
        if(map.size() == 1) return "YES";

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int count : map.keySet()){
            max = Math.max(max,count);
            min = Math.min(min,count);
        }

        if(map.get(min) == 1 && (min == 1 || max == min + 1) ) return "YES";
        if(map.get(max) == 1 && max == min + 1) return "YES";

        return "NO";
    }

}
