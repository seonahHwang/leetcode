package Milla.SlidingWindow;

public class LongestSubstringWithoutDuplicates {
    /*
    * Edgecase
    * 반드시 알파벳 순서대로여아하는지? 만약 알파벳순은 아니지만 중복되지 않은 길이가 더 길다면..?
    * length is 0 => return 0
    * s = "   "
    *
    * Plan
    * 1. Start left pointer at 0, right pointer at 1
    * 2. if term has duplicate character, move left pointer / else move right pointer forward
    * 3. check duplicate character using ASCII code boolean array.
    *
    * TC : O(N), SC : O(N) //chars[] 때문에
    * */
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("zxyzxyz"));
        System.out.println(lengthOfLongestSubstring("au"));
        System.out.println(lengthOfLongestSubstring("     "));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("xxxx"));
    }
    public static int lengthOfLongestSubstring(String s) {
        if(s.length() == 0 || s.length() == 1) return s.length();

        boolean chk[] = new boolean[91]; //ASCII from 32 to 122
        //boolean 배열 대신 HashSet을 사용할 수도 있고 HashSet을 사용하면 추가 시간복잡도 : O(1), 삭제 시간복잡도 : 평균 O(1), 최악 O(N)

        char chars[] = s.toCharArray();
        int l = 0;
        int r = 1;
        int ans = 1;
        char c;
        int chkIdx = 0;
        chk[s.charAt(0)-32] = true;

        while(r < chars.length){
            c = chars[r];
            chkIdx = c - 32;
            if(chk[chkIdx]) {
                char leftC = chars[l];
                int asciiIdx = leftC - 32;
                chk[asciiIdx] = false;
                l++;
            }
            else {
                chk[chkIdx] = true;
                ans = Math.max(ans,r-l+1);
                r++;
            }
        }
        return ans;
    }
}
