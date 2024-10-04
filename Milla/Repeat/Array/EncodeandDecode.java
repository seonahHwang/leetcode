package Milla.Repeat.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeandDecode {

    /*
     * Brainstorm
     * put some character between words
     * and seperate it in decode method.
     *
     * Plan
     * 1. put "/" between words and into a single string
     * 2. if find "/" in string in decode method, add to List.
     *
     * Edge cases
     * strs is empty ->
     * length of element is zero ->
     *
     * 문자열의 길이를 N으로 보면!
     * TC -> O(N)
     * SC -> O(N)
     * Dry run
     *
     * '#'도 UTF-8 문자중에 하나인데 input으로 주어질일이 없는건지.. 일단 제출했을 때 되긴함!
     * 문제핵심
     * - 문자열 뒤에 "/n"를 모두 추가해준다.
     * - decode할때는 문자열전체를 순회하다가 /n이 나오면 서브스트링을 만들어 리스트에 저장한다.
     * - 처음엔 split으로 시도했다가 아예 담기지 않는 것도 있어서 전체순회 방법으로 바꿨다.
     *
     * */
    public static void main(String[] args) {
        String res = encode(Arrays.asList(new String[]{"neet","code","love","you"}));
        //특수문자 아무거나로 분리하면 다 되는건지 확실치 않음!
        List<String> ans = decode(res);
        for(String s : ans){
//            System.out.println("11 "+s);
        }
    }
    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(String s : strs){
            sb.append(s);
            sb.append("\n");
        }

        return new String(sb);
    }

    public static List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < str.length()){
            if(str.charAt(i) == '\n'){
                String ss = str.substring(j,i);
                list.add(ss);
                j = i+1; //특수문자 다음것부터 봐야하므로!
            }
            i++;
        }
        return list;
    }
}
