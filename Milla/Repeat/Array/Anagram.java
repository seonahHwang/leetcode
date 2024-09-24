package Milla.Repeat.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

public class Anagram {
    /*
    * Brainstorm
    * 해쉬맵을 만들어서 정렬된 문자열을 키, 같은 문자열 구성을 가진 것들을 List에 담아 value로 저장
    *
    * Plan
    * 1. go through given strs array, and sort each element and store to hashmap
    * 2. hashmap has sorted str as a key and list of string as a value.
    * 3. Iterate the hashmap and store to result as a list.
    *
    * Edge cases
    * if array can be null? then should I return null?
    * if an element can be ""? then should I return "" 그대로?
    * if array has only one element -> return element
    *
    * TC
    * TC is going to be O(nlogN)
    * we use sorting
    *
    * SC
    * SC is going to be O(N + m * K)
    *
    * Dry run
    * act, cat, tca
    * act / act, cat, tca
    *
    * */
    public static void main(String[] args) {

    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);

            String sortedStr = new String(arr);

            List<String> sub = map.getOrDefault(sortedStr, new ArrayList<>());
            sub.add(strs[i]);
            map.put(sortedStr, sub);
        }

        for (List<String> sub : map.values()) {
            ans.add(sub);
        }
        return ans;
    }
}
