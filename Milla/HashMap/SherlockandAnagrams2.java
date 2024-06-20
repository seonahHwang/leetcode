package Milla.HashMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SherlockandAnagrams2 {
    public static void main(String[] args) {
//        System.out.println(sherlockAndAnagrams("kkkk"));
        System.out.println(sherlockAndAnagrams("abba"));
    }

    public static int sherlockAndAnagrams(String s) {
        // Write your code here
        Map<String,Integer> map = new HashMap<>();
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                String sub = s.substring(i,j);
                System.out.println("sub " + sub);
                char[] c = sub.toCharArray();
                Arrays.sort(c);
                String sortedStr = new String(c);
                map.put(sortedStr,map.getOrDefault(sortedStr,0)+1);
            }
        }

        for(int cnt : map.values()){
            if(cnt > 1 ) {
                System.out.println("cnt : "+cnt);
                result += (cnt *( cnt - 1))/2;
            }
        }
        return result;
    }
}
