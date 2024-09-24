package Milla.Repeat.Array;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopK {
    /*
     * Brainstorm
     * count frequent by using hashmap. and sort by value using priority queue
     *
     * Plan
     * 1. store frequent and number to hashmap
     * 2. Sort by using prioritiy queue.
     * 3. priority queue is going to have array as an element.
     * 4. store number and freq to queue.
     * 5. pop from the queue until k.
     *
     * Edge cases
     * nums is null -> not happen
     * nums has only one value -> if k = 0, return null / if k = 1, return the value.
     *
     * TC
     * pq -> O(logN)
     * map store -> O(N)
     * 최종 O(N)
     *
     * SC
     * O(N)
     *
     * Dry run
     * */
    public static void main(String[] args) {

    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a->-a[0]));

        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n,0)+1);
        }

        for (int key : freq.keySet()){
            pq.add(new int[]{freq.get(key),key});
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll()[1];
        }
        return res;
    }
}
