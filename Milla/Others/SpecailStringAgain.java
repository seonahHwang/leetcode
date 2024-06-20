package Milla.Others;

public class SpecailStringAgain {
    public static void main(String[] args) {
        String s = "abcbaba";
        System.out.println(substrCount(7,s));
    }
    static long substrCount(int n, String s) {
        long result = 0;
        for (int i = 0; i < s.length(); i++) {
            int offset = 1;
            while (i - offset >= 0 && i + offset < n &&
                    s.charAt(i - 1) == s.charAt(i + offset)
                    && s.charAt(i - 1) == s.charAt(i - offset)) { //i-1과 비교하는 이유는 이전의 비교했던 문자가 이번것과도 같은지 aabaa같은 경우를 확인하기 위함이다.
                offset++;
                result++;
            }

            int repeat = 0;
            while (i + 1 < n && s.charAt(i) == s.charAt(i + 1)) {
                repeat++;
                i++;
            }
            result += repeat * (repeat + 1) / 2;
        }
        return result + n;
    }
}
