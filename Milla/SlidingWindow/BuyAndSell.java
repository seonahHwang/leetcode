package Milla.SlidingWindow;

public class BuyAndSell {
    /*
    * length of price array can be 0? => No
    * What if all of elements are 0 => return 0
    * Max profit can be negative?
    *
    * plan
    * 1. find out mininum value
    * 2. compare gap of current value and minimum value and find max value
    * */

    public static void main(String[] args) {
        int arr[] = {7,1,5,3,6,4};
        System.out.println(maxProfit(arr));
    }
    public static int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for(int i=0;i<prices.length;i++){
            min = Math.min(min,prices[i]);
            ans = Math.max(ans,prices[i]-min);
        }
        return ans;
    }
}
