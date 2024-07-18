package Milla.Repeat.SlidingWindow;

import java.util.Arrays;

public class PermutationString {
    public static void main(String[] args) {
        System.out.println(checkInclusion("ab","lecabee"));
    }
    public static boolean checkInclusion(String s1, String s2) {
        int chk1[] = new int[26];
        int chk2[] = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            chk1[s1.charAt(i)-'a']++;
            chk2[s2.charAt(i)-'a']++;
        }

        int cnt = 0;
        for (int i = 0; i < 26; i++) {
            if(chk1[i] == chk2[i]) cnt++;
        }
        if(cnt == 26) return true;

        int l = 0;
        for (int i = s1.length(); i < s2.length(); i++) {
            chk2[s2.charAt(i)-'a']++;
            chk2[s2.charAt(l)-'a']--;
            l++;

            cnt = 0;
            for (int j = 0; j < 26; j++) {
                if(chk1[j] == chk2[j]) cnt++;
            }
            if(cnt == 26) return true;
        }
        return cnt == 26 ? true : false;
    }
}
