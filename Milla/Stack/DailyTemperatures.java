package Milla.Stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
//웨이팅리스트를 스택으로 저장
    public static void main(String[] args) {
        int a[] = {30,38,30,36,35,40,28};
        System.out.println(Arrays.toString(dailyTemperatures(a)));
    }
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length ; i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int prev = stack.pop();
                ans[prev] = i - prev;
            }
            stack.push(i);
        }
        return ans;
    }
}
