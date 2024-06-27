package Milla.Search;

public class MinimumTimeRequired2 {
    public static void main(String[] args) {

    }
    static long minTime(long[] machines, long goal) {
        long l = 1;
        long r = goal*machines.length;
        long mid = 0;

        while(l<r){
            mid = (l+r)/2;

            long total = 0;
            for (int i = 0; i < machines.length; i++) {
                total += mid/machines[i];
            }

            if(total < goal){
                l = mid + 1;
            }else {
                r = mid;
            }
        }
        return l;
    }
}
