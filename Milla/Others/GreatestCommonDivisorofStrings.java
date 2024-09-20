package Milla.Others;

public class GreatestCommonDivisorofStrings {
    public static void main(String[] args) {
        gcdOfStrings("ABABAB","ABAB");
    }

    public static String gcdOfStrings(String str1, String str2) {
        if(!((str2+str1).equals(str1+str2))) return "";
        int gcd = gcd(str1.length(), str2.length());
        return str1.substring(0,gcd);
    }
    public static int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a%b);
    }

}
