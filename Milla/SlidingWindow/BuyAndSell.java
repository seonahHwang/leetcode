package Milla.SlidingWindow;

public class BuyAndSell {
    /*
    * length of price array can be 0? => No
    * What if all of elements are 0 => return 0
    * Max profit can be negative?
    *
    * plan 1
    * 1. find out mininum value
    * 2. compare gap of current value and minimum value and find max value
    *
    * plan 2 - Two pointer
    * 1. start left at 0, right at 1
    * 2. when right value is greater than left, calculate gap and find max value.
    * 3. if left is greater than right, then we don't need to calculate and just left pointer move to right pointer
    * */

    public static void main(String[] args) {
        int arr[] = {7,1,5,3,6,4};
        System.out.println(maxProfit2(arr));
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

    public static int maxProfit2(int[] prices) {
        if(prices.length == 0) return 0;

        int l = 0;
        int r = 1;
        int ans = 0;

        while (r < prices.length){
            if(prices[l] < prices[r]){
                ans = Math.max(ans,prices[r]-prices[l]);
            }else { //왼쪽이 더 크면
                l = r; //오른쪽이 작은 상황이므로 left를 right로 옮겨줌. left는 right보다 작아야 값을 따져볼 수 있으므로
            }
            r++;
        }
        return ans;
    }
}
