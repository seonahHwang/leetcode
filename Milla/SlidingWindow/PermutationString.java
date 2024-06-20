package Milla.SlidingWindow;

public class PermutationString {
    /*
    * You are given two strings s1 and s2.
    Return true if s2 contains a permutation of s1, or false otherwise. That means if a permutation of s1 exists as a substring of s2, then return true.
    Both strings only contain lowercase letters.
    Example 1:
    Input: s1 = "abc", s2 = "lecabee"
    Output: true
    Explanation: The substring "cab" is a permutation of "abc" and is present in "lecabee".
    Example 2:
    Input: s1 = "abc", s2 = "lecaabee"
    Output: false
    Constraints:
    1 <= s1.length, s2.length <= 1000
    *
    * Edge case
    * if length of s1 is longger than s2, should I return false?
    * if one of the strings is zero, should I return false?
    *
    * Plan
    * Approach using sliding window way.
    * count the match character in s1 and s2.
    * Use integer array to count each character.
    * If the matchCount is going to 26, we can return true.
    * If we go through s1, s2 but we get matchcount less than 26, It means false.
    *
    * TC : O(s1.length() + s2.length()), SC : O(26) -> O(1)
    * */
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";

        String s1_2 = "abc";
        String s2_2 = "lecaabee";
        System.out.println(checkInclusion(s1,s2));
        System.out.println(checkInclusion(s1_2,s2_2));
    }
    public static boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int s1arr[] = new int[26];
        int s2arr[] = new int[26];
        int matchCnt = 0;

        int l = 0;
        int r = 0;
        int idx = 0;

        for(int i = 0; i < s1.length() ; i++){
            idx = s1.charAt(i) - 'a';
            s1arr[idx]++;
            idx = s2.charAt(i) - 'a';
            s2arr[idx]++;
        }

        for(int i = 0 ; i < 26 ; i++){
            if(s1arr[i] == s2arr[i]) matchCnt++;
        }
        System.out.println(matchCnt);
        r = s1.length();

        while (r < s2.length()){
            if(matchCnt == 26) return true;

            idx = s2.charAt(r) - 'a';
            s2arr[idx]++;
            if(s1arr[idx] == s2arr[idx]) matchCnt++;
            else if(s1arr[idx] + 1 == s2arr[idx]) {
                matchCnt--;
            }

            idx = s2.charAt(l) - 'a';
            s2arr[idx]--;
            if(s1arr[idx] == s2arr[idx]) matchCnt++;
            else if(s1arr[idx] - 1 == s2arr[idx]) {
                matchCnt--;
            }

            l++;
            r++;
        }

        return matchCnt == 26;
    }
}
