package Milla.Stack;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class CarFleet {
    /*
    * Input: target = 10, position = [4,1,0,7], speed = [2,2,1,1]
    Output: 3
    * */

    public static void main(String[] args) {
        int target = 10;
        int[] position = {4,1,0,7};
        int[] speed = {2,2,1,1};
        System.out.println(carFleet(target,position,speed));
    }
    public static int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double cars[][] = new double[position.length][2];

        for(int i = 0 ; i < n ; i++){
            cars[i][0] = position[i];
            cars[i][1] = (double) (target - position[i]) / speed[i];
        }

        Arrays.sort(cars,Comparator.comparingDouble(a -> -a[0]));

        Stack<Double> stack = new Stack<>();

        for(int i = 0 ; i < n ; i++){
            double time = cars[i][1];

            if(!stack.isEmpty() && time <= stack.peek()) continue;
            stack.push(time);
        }
        return stack.size();
    }
}
