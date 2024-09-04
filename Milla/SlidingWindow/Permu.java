package Milla.SlidingWindow;

public class Permu {

    public static void main(String[] args) {
//        s1="adc"
//        s2="dcda"
        System.out.println(checkInclusion("adc","dcda"));
    }
    public static boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int chk1[] = new int[26];
        int chk2[] = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            chk1[s1.charAt(i)-'a']++;
            chk2[s2.charAt(i)-'a']++;
        }
        int l = 0;
        if(compare(chk1,chk2)) return true;
        for (int r = s1.length(); r < s2.length(); r++) {
            chk2[s2.charAt(l)-'a']--;
            chk2[s2.charAt(r)-'a']++;
            System.out.println("l :"+l +"r : "+r);
            if(compare(chk1,chk2)) return true;
            l++;
        }
        return false;
    }

    public static boolean compare(int chk1[], int chk2[]){
        for (int i = 0; i < chk1.length ; i++) {
            if(chk1[i] != chk2[i]) return false;
        }
        return true;
    }
}
