package Milla.SlidingWindow;

public class LongestRpeatingSubStringWithReplacement {
    /*
    * edage case
    * =>
    *
    * idea
    * => using two pointers
    * start from left as 0, right as 0
    * while I'm moving right point forward and calculate the length between left and right.
    * if difference is going to more than K, I will change left to current right location.
    *
    * plan
    * =>
    *
    * TC : O(N), SC : O(1)
    * */
    public static void main(String[] args) {
//        System.out.println(characterReplacement("AAABABB",1));
//        System.out.println(characterReplacement("XYYX",2));
        System.out.println(characterReplacement("AAAABBA",1));
    }

    public static int characterReplacement(String s, int k) {
        int a[] = new int['Z'-'A'+1];
        int start = 0;
        int idx = 0;
        int maxCnt = Integer.MIN_VALUE;
        int maxlen = Integer.MIN_VALUE;

        for(int end=0; end<s.length(); end++){ //window 크기 늘리기
            idx = s.charAt(end)-'A';
            a[idx]++; //윈도우내에서 몇 번 등장했는지 increment count
            maxCnt = Math.max(maxCnt,a[idx]); //가장 많이 등장한 횟수
            System.out.println(s.charAt(end));

            if(end - start + 1 - maxCnt > k){ //윈도우 크기 - 몇번등장했는지 = 몇번의 변경이 필요한지
                a[s.charAt(start)-'A']--;
                start++; //크기 줄이기
            }
            maxlen = Math.max(maxlen,end - start +1); //최대 window 길이 구하기
        }
        return maxlen;
    }
}
