package Milla.Others;

public class MinimizetheMaximumOfTwoArrays {
    public static void main(String[] args) {
        System.out.println(minimizeSet(2,7,1,3));
    }
    private static int gcd(int a, int b) {
        return b == 0? a : gcd(b, a % b);
    }

    public static int minimizeSet(int d1, int d2, int u1, int u2) {
        long lo = 1, hi = (int) 10e10;
        long ans = hi;
        long lcm = ((long) d1 * (long) d2) / gcd(d1, d2);
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            System.out.println("mid : "+mid);
            System.out.println("mid / d1 " + mid / d1);
            System.out.println("mid / d2 " + mid / d2);
            int x = (int) (mid - mid / d1);
            int y = (int) (mid - mid / d2);
            System.out.println("x : "+x);
            System.out.println("y : "+y);
            int z = (int) (mid - mid / lcm);
            if (x < u1 || y < u2 || z < u1 + u2) {
                lo = mid + 1;
            } else {
                ans = Math.min(ans, mid);
                hi = mid - 1;
            }
            System.out.println("----------------------------");
        }

        return (int) ans;
    }
}
