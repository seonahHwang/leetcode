package Milla.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public static void main(String[] args) {

    }
    public int[][] kClosest(int[][] points, int k) {
        Comparator<Dot> dotComparator = new Comparator<Dot>() {
            @Override
            public int compare(Dot o1, Dot o2) {
                return Double.compare(o1.d,o2.d);
            }
        };

        PriorityQueue<Dot> dots = new PriorityQueue<>(dotComparator);

        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            double d = Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
            dots.add(new Dot(x,y,d));
        }

        int[][] ans = new int[k][2];

        for (int i = 0; i < k; i++) {
            Dot dot = dots.poll();
            ans[i][0] = dot.x;
            ans[i][1] = dot.y;
        }
        return ans;
    }

    class Dot{
        int x;
        int y;
        double d;

        public Dot(int x,int y, double d){
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}
