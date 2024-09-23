package Milla.Others;

public class ReverseVowels {
    public static void main(String[] args) {
//        String s = "aabc";
//        StringBuilder ss = new StringBuilder();
//        ss.append("icecream");
//        ss.replace(0,1, "a");
//        System.out.println(ss);

        System.out.println(reverseVowels("leaid"));
    }
    public static String reverseVowels(String s) {
        char[] word = s.toCharArray();
        String vowels = "aeiouAEIOU";

        int l = 0;
        int r = s.length() - 1;

        while (l<r){
            while (l<r && vowels.indexOf(word[l]) == -1){
                l++;
            }
            while (l<r && vowels.indexOf(word[r]) == -1){
                r--;
            }
            char tmp = word[l];
            word[l] = word[r];
            word[r] = tmp;

            l++;
            r--;
        }
        return new String(word);
    }
}
