package Milla.SlidingWindow;

public class MinimumWindowWithCharacters {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
    }
    public static String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";

        String shortest = "";
        int shortLen = Integer.MAX_VALUE;

        int l = 0;
        for (int r = t.length()-1; r < s.length(); r++) {
            String sub = s.substring(l,r);
            while (compare(sub,t) && l < r){
                sub = s.substring(l,r);
                if(shortLen > r-l){
                    shortLen = r-l;
                    shortest = sub;
                }
                l++;
            }
        }
        return shortest;
    }
    public static boolean compare(String sub, String t){
        for (int i = 0; i < t.length(); i++) {
            String a = String.valueOf(t.charAt(i));
            if(!sub.contains(a)) return false;
        }
        System.out.println("sub: "+sub+", t: "+t);
        return true;
    }
}
