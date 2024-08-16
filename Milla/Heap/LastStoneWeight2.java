package Milla.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight2 {
    public static void main(String[] args) {
        lastStoneWeight(new int[]{2,3,6,2,4});
    }
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int n : stones){
            heap.add(n);
        }

        while (!heap.isEmpty() && heap.size() > 1){
            int y = heap.poll();
            int x = heap.poll();
            if(y > x){
                int d = y-x;
                heap.add(d);
            }
        }

        if(heap.size() == 0) return 0;
        else return heap.poll();
    }
}
