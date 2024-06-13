package Milla.Stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    /*
    * Edge case
    * 1) if all temperatures are the same, do I return 0?
    * 2) Can the temperature array be empty?
    *
    * Idea
    * using stack for the waiting list
    *
    * Plan
    *
    *
    *
    * TC : O(n). Because I iterate through the array once.
    * SC : I'll use answer, stack it means O(n) space each structure and
    * the total SC is O(n) + O(n) so is going to O(n).
    * */
//웨이팅리스트를 스택으로 저장
    public static void main(String[] args) {
        int a[] = {30,38,30,36,35,40,28};
        System.out.println(Arrays.toString(dailyTemperatures(a)));
    }
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        //I'll loop through each day
        for (int i = 0; i < temperatures.length ; i++){
            /*
            * for each day, I'll check if the stack is empty
            * */
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int prev = stack.pop();
                ans[prev] = i - prev;
            }
            stack.push(i);
        }
        return ans;
    }
}
