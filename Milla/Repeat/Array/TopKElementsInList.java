package Milla.Repeat.Array;

import java.util.*;

public class TopKElementsInList {
    public static void main(String[] args) {
        int r[] = topKFrequent(new int[]{1,2,2,3,3,3},2);
        System.out.println(r);
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> numToFreq = new HashMap<>();
        int[] result = new int[k];

        for (int num : nums){
            numToFreq.put(num,numToFreq.getOrDefault(num,0)+1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> topKelements = new PriorityQueue<>((e1,e2)->e1.getValue() - e2.getValue());

        for(Map.Entry<Integer, Integer> entry : numToFreq.entrySet()){
            topKelements.add(entry);
        }


        for (int i = 0; i < numToFreq.size() - k ; i++){
            topKelements.poll();
        }

        int cnt = 0;
        while (!topKelements.isEmpty()) {
            result[cnt] = topKelements.poll().getKey();
            cnt++;
        }
        return result;
    }
}