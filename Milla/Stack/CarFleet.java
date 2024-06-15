package Milla.Stack;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class CarFleet {
    /*
    * Input: target = 10, position = [4,1,0,7], speed = [2,2,1,1]
    Output: 3
    *
    * Brute force way
    * If I apporoach in brute force way to check each element, I need to compare every element to every element.
    * So It would take O(n^2) time complexity.
    * Therefore, I will approach this problem with a different way.
    *
    * Edge case
    * if position or speed array are empty, there are no cars to form fleets, so the output should be 0.
    * If there is only one car at the target position, it forms a fleet by itself, so the output should be 1.
    *
    * Plan
    * Calculate time the each car will take to reach the destination.
    * Sort the cars based on their starting positions in descending order.
    * Use a stack to track the formation of fleets.
    *
    * TC => O(Nlogn)
    * SC => o(n) I'm going to store time to reach destination by new array and track the formation using stack. Each data structure has o(n) space complexity. so its space complexity is going to o(n)
    * */

    public static void main(String[] args) {
        int target = 10;
        int[] position = {4,1,0,7};
        int[] speed = {2,2,1,1};
        System.out.println(carFleet(target,position,speed));
    }
    public static int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double cars[][] = new double[position.length][2]; // => O(n) 설명필요 cars array의 길이는 position의 길이와 같아서 O(n)만큼 차지한다.

        for(int i = 0 ; i < n ; i++){
            cars[i][0] = position[i];
            cars[i][1] = (double) (target - position[i]) / speed[i]; // the position of divide target - position[i] by speed[i] 설명필요
        }

        Arrays.sort(cars,Comparator.comparingDouble(a -> -a[0])); //sort the cars array in descending order of their starting positions.

        Stack<Double> stack = new Stack<>(); // => O(n)

        //Use a stack to count the fleets. If a car's time to the target is greater than the time on top of stack, it means this car starts a new fleet.
        for(int i = 0 ; i < n ; i++){
            double time = cars[i][1];

            if(!stack.isEmpty() && time <= stack.peek()) continue;
            stack.push(time); //push car's time to the target, for the compare with next car's time.
        }
        return stack.size(); //left size of stack means number of car fleets.
    }
}
