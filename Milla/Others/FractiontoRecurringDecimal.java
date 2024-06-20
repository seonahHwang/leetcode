package Milla.Others;

import java.util.HashMap;
import java.util.Map;

public class FractiontoRecurringDecimal {
    public static void main(String[] args) {
        /*Input: numerator = 4, denominator = 333
Output: "0.(012)"
        * */
//        System.out.println(fractionToDecimal(4,333));
//        System.out.println(fractionToDecimal2(4,333));
        System.out.println(fractionToDecimal(4,333));
    }
    /*
    * 부호 처리:
    분자와 분모 중 하나만 음수인 경우 결과는 음수입니다. 이를 확인하여 결과 문자열에 '-'를 추가합니다.
    정수 부분 계산:

    분자와 분모를 long 타입으로 변환하여 정수 부분을 계산합니다. 이는 오버플로우를 방지하기 위함입니다.
    정수 부분은 num / den으로 계산되고, 나머지는 num % den으로 계산됩니다.
    소수 부분 계산:

    소수 부분이 있는지 확인합니다. 나머지가 0이면 소수 부분이 없으므로 현재 결과를 반환합니다.
    나머지가 0이 아니면 소수점을 결과 문자열에 추가하고 소수 부분 계산을 시작합니다.
    반복 소수 처리:

    나머지와 그 위치를 기록하기 위해 Map을 사용합니다.
    나머지를 10배로 곱해 다음 자릿수를 계산합니다.
    계산된 나머지가 이미 Map에 존재하면 반복이 시작된 위치를 알 수 있습니다. 이 경우 괄호를 추가하여 반복 부분을 표시합니다.
    * */
    public static String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0 || denominator == 0) return "0";
        StringBuilder result = new StringBuilder();
        if(numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0) result.append("-");

        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        long a = num/den;
        long b = num%den;

        result.append(a);
        if(b == 0) return result.toString();

        result.append(".");

        long remainder = num % den;
        Map<Long,Integer> map = new HashMap<>();

        while(remainder != 0){
            if(map.containsKey(remainder)){
                int start = map.get(remainder);
                result.insert(start,"(");
                result.append(")");
                break;
            }

            map.put(remainder, result.length());
            remainder *= 10;
            result.append(remainder/den);
            remainder %= den;
        }

        return result.toString();
    }

    public static String fractionToDecimal2(int numerator, int denominator) {
        if (numerator == 0) return "0";  // 분자가 0이면 결과는 0

        StringBuilder result = new StringBuilder();

        // 부호 결정
        if ((numerator > 0) ^ (denominator > 0)) {
            result.append("-");
        }

        // long 타입으로 변환하여 절대값을 계산 (오버플로우 방지)
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // 정수 부분 계산
        result.append(num / den);
        long remainder = num % den;
        System.out.println("while 시작 전 remainder " + remainder);

        if (remainder == 0) return result.toString();  // 나머지가 0이면 소수 부분 없음

        result.append(".");  // 소수점 추가

        // 나머지 위치를 기록하기 위한 맵
        Map<Long, Integer> remainderMap = new HashMap<>();

        while (remainder != 0) {
            if (remainderMap.containsKey(remainder)) {
                int start = remainderMap.get(remainder);
                System.out.println("strat : "+start);
                result.insert(start, "(");
                result.append(")");
                break;
            }

            // 나머지와 현재 결과 문자열 길이 기록
            remainderMap.put(remainder, result.length());
            remainder *= 10;
            result.append(remainder / den);
            remainder %= den; //10배를 한 후 나머지값을 다시 몫으로 나눈다.
        }

        return result.toString();
    }
}
