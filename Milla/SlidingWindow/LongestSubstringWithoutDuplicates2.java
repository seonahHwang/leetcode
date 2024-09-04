package Milla.SlidingWindow;

public class LongestSubstringWithoutDuplicates2 {
    public static void main(String[] args) {
        System.out.println(' ' - 0); //32
        System.out.println(lengthOfLongestSubstring("zxyzxyz"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("  "));
    }
    public static int lengthOfLongestSubstring(String s) {
        if(s.equals("")) return 0;
        if(s.length() == 1) return 1;
        int max = Integer.MIN_VALUE;
        int chk[] = new int[200];

        int l = 0;
        int r = 0;

        while (l<=r && r < s.length()){
            if(chk[s.charAt(r)-0] == 1){
                chk[s.charAt(l)-0]--;
                l++;
            }else {
                chk[s.charAt(r)-0]++;
                r++;
                max = Math.max(max,r-l);
            }
        }
        return max;
    }
}
