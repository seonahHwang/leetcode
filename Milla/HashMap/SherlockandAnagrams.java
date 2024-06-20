package Milla.HashMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SherlockandAnagrams {
    public static void main(String[] args) {

    }
    public static int sherlockAndAnagrams(String s) {
        // Write your code here
        Map<String,Integer> map = new HashMap<String,Integer>();
        int answer = 0;

        for (int i = 0 ; i < s.length() ; i++){
            for (int j = i+1 ; j <= s.length() ; j++){
                String sub = s.substring(i,j);
                char[] chars = sub.toCharArray();
                Arrays.sort(chars);
                String sortedStr = new String(chars);
                map.put(sortedStr,map.getOrDefault(sortedStr,0)+1);
            }
        }

        for(int count : map.values()){
            if(count > 1) {
                answer += (count * (count - 1)) / 2;
            }
        }
        return answer;
    }
}
