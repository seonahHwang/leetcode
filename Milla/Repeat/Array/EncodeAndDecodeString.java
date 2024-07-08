package Milla.Repeat.Array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class EncodeAndDecodeString {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("neet");
        list.add("code");
        list.add("love");
        list.add("you");

        String arr[] = {"we","say",":","yes","!@#$%^&*()"};
        decode(encode(Arrays.asList(arr)));
//        decode(encode(list));
    }
    public static String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        for (String str : strs) {
            encodedString.append(str.length()).append("#").append(str);
        }
        return encodedString.toString();
    }

    public static List<String> decode(String str) {
        List<String> result = new LinkedList<>();
        int i = 0;
        int last = 0;
        while (i < str.length()){
            if(str.charAt(i) == '#'){
                String lenStr = str.substring(last,i);
                System.out.println("last" + last +", i : "+i);
                int len = Integer.parseInt(lenStr);
                String s = str.substring(i+1,i+1+len);
                result.add(s);
                i = i+1+len;
                last = i;
            }
            i++;
        }
        return result;
    }
}
