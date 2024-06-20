package Milla.Stack;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesinString {
    /*
    * count stack / 문자열 저장 stack
    * 똑같이 push하고 비우기. 매 문자에 대해서 push함!
    * 가장 상위 count가 k와 같아졌을 때 k만큼 pop하기!
    * stringbuilder reverse 하기
    * */
    public static void main(String[] args) {
        String s = "deeedbbcccbdaa";
        int k = 3;
        System.out.println(removeDuplicates(s,k));
    }
    public static String removeDuplicates(String s, int k) {
        Stack<Character> chars = new Stack<>();
        Stack<Integer> count = new Stack<>();

        for(char c : s.toCharArray()){
            if(!chars.isEmpty() && c == chars.peek()){
                count.push(count.peek()+1); //상위값 가져와서 +1 해서 업데이트
            }else {
                count.push(1);
            }

            chars.push(c);

            if(!count.isEmpty() && count.peek() == k){
                for(int i = 0 ; i < k ; i++){
                    chars.pop();
                    count.pop();
                }
            }
        }

        StringBuilder answer = new StringBuilder();

        while(!chars.isEmpty()){
            answer.append(chars.pop());
        }
        return answer.reverse().toString();
    }
}
