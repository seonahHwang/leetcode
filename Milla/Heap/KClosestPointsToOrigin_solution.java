package Milla.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin_solution {
    public static void main(String[] args) {

    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparing(a->a[0]));

        for(int[] point : points){
            int dist = point[0]*point[0] + point[1] * point[1];
            q.add(new int[]{dist,point[0],point[1]});
        }
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            int point[] = q.poll();
            res[i] = new int[]{point[1],point[2]};
        }
        return res;
    }
}
