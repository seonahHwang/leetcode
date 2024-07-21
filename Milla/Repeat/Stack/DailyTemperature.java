package Milla.Repeat.Stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperature {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{30,38,30,36,35,40,28})));
    }
    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[temperatures.length];

        for (int i = 0 ; i < temperatures.length ; i++){
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                int prev = stack.pop();
                answer[prev] = i - prev;
            }
            stack.push(i);
        }
        return answer;
    }
}