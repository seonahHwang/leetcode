package Milla.BinarySearch;

public class EatingBananas {
    public static void main(String[] args) {
//        Input: piles = [1,4,3,2], h = 9
//
//        Output: 2
        int piles[] = {1,4,3,2}; int h = 9;
        System.out.println(minEatingSpeed(piles,h));
    }
    public static int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int i = 0; i < piles.length; i++){
            max = Math.max(max,piles[i]);
        }

        int left = 0;
        int right = max;
        int min = Integer.MAX_VALUE;
        int mid = 1;

        while(left <= right){
            mid = (left + right)/2;
            if(mid == 0) break;
            int total = 0;
            for(int i = 0; i < piles.length ; i++){
                System.out.println("mid"+mid);
                total += Math.ceil(piles[i]/mid);
            }
            if(total > h){ //K증가
                left = mid + 1;
            }else {
                right = mid - 1;
                min = Math.min(mid,min);
            }
        }
        return min;
    }
}
