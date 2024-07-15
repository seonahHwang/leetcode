package Milla.Repeat.SlidingWindow;

import java.util.Arrays;
import java.util.HashSet;

public class LongestSubstringWithoutDuplicates {
    public static void main(String[] args) {
        String s = "zxyzxyz"; //3
        char c = ' ';
//        System.out.println(c - 1);
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        int chk[] = new int[200];
        Arrays.fill(chk,0);
        char arr[] = s.toCharArray();
        int l = 0;
        int r = 1;
        int max = Integer.MIN_VALUE;
        int cnt = 1;

       while (l < r && r < s.length()) {
           int leftIdx = arr[l] - 1;
           chk[leftIdx] = 1;
            while (l < r  && r < s.length()){
                int rightIdx =  arr[r] - 1;
                if (chk[rightIdx] == 0) {
                    chk[rightIdx] = 1;
                    cnt++;
                    r++;
                }else break;
            }
            max = Math.max(max,cnt);
            cnt = 1;
            Arrays.fill(chk,0);
            l++;
            r = l + 1;
        }
        return max;
    }

//    public static int lengthOfLongestSubstring(String s) {
//        HashSet<Character> charSet = new HashSet<>();
//        int l = 0;
//        int res = 0;
//
//        for (int r = 0; r < s.length(); r++) {
//            while (charSet.contains(s.charAt(r))) {
//                charSet.remove(s.charAt(l));
//                l++;
//                System.out.println("remove("+s.charAt(l)+") , l : "+ l);
//            }
//            charSet.add(s.charAt(r));
//            System.out.println("add("+s.charAt(r)+") , r : "+ r);
//            res = Math.max(res, r - l + 1);
//        }
//        return res;
//    }
}
