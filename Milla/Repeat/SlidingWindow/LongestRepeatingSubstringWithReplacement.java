package Milla.Repeat.SlidingWindow;

public class LongestRepeatingSubstringWithReplacement {
    public static void main(String[] args) {

    }
    public int characterReplacement(String s, int k) {
        int l = 0;
        int max = Integer.MIN_VALUE;
        int result = 0;
        int chk[] = new int[27];

        for (int r = 0; r < s.length(); r++) {
            chk[s.charAt(r)-'A']++;
            max = Math.max(max,chk[s.charAt(r)-'A']);

            while (r - l + 1 - max > k){
                chk[s.charAt(l)-'A']--;
                l++;
            }
            result = Math.max(result,r - l + 1);
        }
        return result;
    }
}
