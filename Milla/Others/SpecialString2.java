package Milla.Others;

public class SpecialString2 {
    public static void main(String[] args) {
        System.out.println(substrCount(4,"aaaa"));
    }

    static long substrCount(int n, String s) {
        long answer = 0;
        long repeat = 0;
        for (int i = 0; i < n; i++) {
            int offset = 1;
            while (i - offset >= 0 && i + offset < n //범위지정이 중요함!
                    && s.charAt(i-1) == s.charAt(i+offset)
                    && s.charAt(i-offset) == s.charAt(i+offset)){
                offset++;
                answer++;
            }
            repeat = 0;
            while (i + 1 < n && s.charAt(i) == s.charAt(i+1)){ //i+1로 해두면 i가 0인 경우까지 체크할 수 있게 된다.
                repeat++;
                i++;
            }
            answer += (repeat * (repeat + 1)) / 2;
        }
        answer += n;
        return answer;
    }

}

