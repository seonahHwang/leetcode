package Milla.Heap;

import java.util.PriorityQueue;

public class KthLargest {
    static PriorityQueue<Integer> minHeap;
    static int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();
        for (int num : nums){
            minHeap.offer(num);
            if(minHeap.size() > k){
                minHeap.poll(); //가장 앞의 원소가 삭제되는것
            }
        }
        System.out.println();
    }

    public int add(int val) {
        minHeap.offer(val);
        if(minHeap.size() > k) minHeap.poll();
        return minHeap.peek();
    }
    public static void main(String[] args) {
        KthLargest kth = new KthLargest(3,new int[]{1,2,3,4});
        kth.add(3);   // return 3
        kth.add(5);   // return 3
        kth.add(6);   // return 3
        kth.add(7);   // return 5
        kth.add(8);   // return 6
    }
}
