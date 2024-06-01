package Milla.Arrays_Hashing;

import java.util.*;

public class group_anagram {
    /*
    * 쓸 수 있는 표현 Neetcode video
    * go through every string that we're given in the input
    * now we wnat to go through every single character
    * as you can see
    * Let's say
    * we're just gonna increment this by one //++1
    *
    * where m is the number of string we're given and
    * n is the average length of each string
    * */
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

    /*
    * edge case
    * Can the array be empty? -> return null.
    * if the length of array is one => just return the single value.
    * If the array is empty, the function should return 0.
      If the array has only one element, the function should return 1.
    *
    *
    * Can the length of string value going to be different?
    *
    * plan
    * compare sorted each value of the array to identify they have same alphabet or not
    * and when we got the value which be indentified, I'm gonna store in Hashmap.
    * Because we need store into single element of List.
    *
    * TC : O(nlogn) => Because I will use sorting.
    * SC : O(n * m)
    * strs.length를 n으로 표기합니다.
      각 문자열의 평균 길이를 m으로 표기합니다.
    *
    * */
    public static void main(String[] args) {
        String[] arr = {"eat","tea","tan","ate","nat","bat"};

        groupAnagrams(arr);
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> li = new LinkedList<>();

        Map<String, List<String>> map = new HashMap<>();

        // I'll loop length of string array.
        for(int i=0;i<strs.length;i++){
            char[] c = strs[i].toCharArray(); //I'll initialize new character array which has each element of string value
            Arrays.sort(c); //I can identify using sorting of every single value of string array.
            String sortS = new String(c); // I'll initialize new String for identifying.


            if(map.containsKey(sortS)){ // if map already has this value, I'll get the list from hashmap using sorted String
                List<String> subList = map.get(sortS);
                subList.add(strs[i]); // and add current string value.
                map.put(sortS,subList);
            }else {
                List<String> subList = new LinkedList<>(); //if map doesn't have current value, I'll add this value as value and key will be sorted string.
                subList.add(strs[i]);
                map.put(sortS,subList);
            }
        }

        //So now we can get two dimentions
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            li.add(entry.getValue());
        }

        return li;
    }
}