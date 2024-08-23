package Milla.Heap;

import java.util.*;

public class LeastInterval {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char task : tasks){
            counts.put(task, counts.getOrDefault(task, 0)+1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap.addAll(counts.values());

        int time = 0;
        Deque<int[]> queue = new ArrayDeque<>();
        while (!maxHeap.isEmpty() || !queue.isEmpty()){
            if(!queue.isEmpty() && time >= queue.peek()[1]){
                maxHeap.add(queue.poll()[0]);
            }

            if(!maxHeap.isEmpty()){
                int cnt = maxHeap.poll() - 1;
                int t = time + n + 1;
                if(cnt > 0) queue.add(new int[]{cnt, t});
            }

            time++;
        }

        return time;
    }
}
