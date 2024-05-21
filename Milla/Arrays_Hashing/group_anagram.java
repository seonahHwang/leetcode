package Milla.Arrays_Hashing;

import java.util.*;

public class group_anagram {
//    Input: strs = ["eat","tea","tan","ate","nat","bat"]
//    Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
//    Example 2:
//
//    Input: strs = [""]
//    Output: [[""]]
//    Example 3:
//
//    Input: strs = ["a"]
//    Output: [["a"]]

    public static void main(String[] args) {
        String[] arr = {"eat","tea","tan","ate","nat","bat"};

        groupAnagrams(arr);
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> li = new LinkedList<>();

        Map<String, List<String>> map = new HashMap<>();

        for(int i=0;i<strs.length;i++){
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String sortS = new String(c);

            if(map.containsKey(sortS)){
                List<String> subList = map.get(sortS);
                subList.add(strs[i]);
                map.put(sortS,subList);
            }else {
                List<String> subList = new LinkedList<>();
                subList.add(strs[i]);
                map.put(sortS,subList);
            }
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            li.add(entry.getValue());
        }

        return li;
    }
}