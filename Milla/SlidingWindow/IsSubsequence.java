package Milla.SlidingWindow;

public class IsSubsequence {
    public static void main(String[] args) {
        System.out.println(isSubsequence("abc","ahbgdc"));
    }
    public static boolean isSubsequence(String s, String t) {
        if(s.length() == 0) return true;
        if(t.length() == 0) return false;

        int pointer = 0;
        int cnt = 0;
        for (int i = 0; i < t.length(); i++) {
            if(pointer < s.length() && s.charAt(pointer) == t.charAt(i)){
                pointer++;
                cnt++;
            }
        }
        System.out.println(cnt);
        return cnt == s.length();
    }
}
