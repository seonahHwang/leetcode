package Milla.SlidingWindow;

public class MaxNumbersOfVowel {
    public static void main(String[] args) {
        System.out.println(maxVowels("abciiidef",3));
    }
    public static int maxVowels(String s, int k) {
        int max = Integer.MIN_VALUE;
        int cnt = 0;

        String vowels = "aeiou";

        //from 0 to k-1

        for (int i = 0; i < k; i++) { //I've already verified the first three indices.
            if(vowels.indexOf(s.charAt(i)) != -1) cnt++;
        }

        max = Math.max(cnt,max);
        int left = 0;
        for (int right = k; right < s.length(); right++) {
            if(vowels.indexOf(s.charAt(right)) != -1) cnt++;
            if(vowels.indexOf(s.charAt(left)) != -1) cnt--;
            left++;
            max = Math.max(cnt,max);
        }

        return max;
    }
}
