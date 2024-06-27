package Milla.Others;

public class OA1 {
    public static void main(String[] args) {
        /*GGGGGrrrrrrrrrrrrrrt
Sample Output
5G14r1t
        * */
        System.out.println(solve1("GGGGGrrrrrrrrrrrrrrt"));
    }

    static String solve1(String s){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int repeat = 1;

            while(i < s.length() -1 && s.charAt(i) == s.charAt(i+1)){
                repeat++;
                i++;
            }
            result.append(repeat);
            result.append(s.charAt(i));
            repeat = 1;
        }
        return result.toString();
    }
}
