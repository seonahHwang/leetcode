package Milla.Repeat.Stack;

import java.util.*;

public class CarFleet {
    public static void main(String[] args) {
        System.out.println(carFleet(10,new int[]{4,1,0,7},new int[]{2,2,1,1}));
    }
    public static int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] cars = new double[n][2];

        for (int i = 0; i < cars.length; i++) {
            double time = (double) (target - position[i])/speed[i];
            cars[i][0] = position[i];
            cars[i][1] = time;
        }

        Arrays.sort(cars,Comparator.comparingDouble(a -> -a[0]));

        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            double time = cars[i][1];
            if(!stack.isEmpty() && stack.peek() >= time){
                continue;
            }
            stack.push(time);
        }
        return stack.size();
    }
}