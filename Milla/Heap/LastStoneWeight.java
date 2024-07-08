package Milla.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue(Collections.reverseOrder());
        for(int stone : stones){
            maxHeap.offer(stone);
        }
        while (maxHeap.size() > 1){
            int x = maxHeap.poll();
            int y = maxHeap.poll();
            if(x > y) maxHeap.offer(x-y);
        }
        return maxHeap.size() == 1 ? maxHeap.poll() : 0;
    }

    public static void main(String[] args) {

    }
}
