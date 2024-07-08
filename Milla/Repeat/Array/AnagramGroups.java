package Milla.Repeat.Array;

import java.util.*;

public class AnagramGroups {
    public static void main(String[] args) {

    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new LinkedList<>();
        Map<String,List<String>> anagrams = new HashMap<>();

        List<String> subList = new LinkedList<>();
        for (String str : strs){
            char[] cArr = str.toCharArray();
            Arrays.sort(cArr);
            String sortedS = new String(cArr);
            subList = anagrams.getOrDefault(sortedS,new LinkedList<>());
            subList.add(str);
            anagrams.put(sortedS,subList);
        }

        for(List<String> li : anagrams.values()){
            result.add(li);
        }
        return result;
    }
}
