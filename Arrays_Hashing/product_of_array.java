package Arrays_Hashing;

import java.util.Arrays;

public class product_of_array {
    /*
    * Edge case
    * 1) nums.length : >= 2
    *
    * Solution
    * 1) product every elements in left side except self and store to left[]
    * 2) product every elements in right side except self and store to right[]
    * 3) product left[] and right[]ㅁㅋ ㅋㅁㅁㅁㅁㅁ
    * */
    public static void main(String[] args) {
        int arr[] = {1,2,3,4};
        Arrays.toString(productExceptSelf(arr));
    }
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        int left[] = new int[n];
        int right[] = new int[n];

        int curr = 1;
        Arrays.fill(ans,1);
        Arrays.fill(left,1);
        Arrays.fill(right,1);

        for (int i=0;i<n;i++){
            left[i] *= curr;
            curr *= nums[i];
        }

        curr = 1;
        for(int i=n-1;i>=0;i--){
            right[i] *= curr;
            curr *= nums[i];
        }

        for(int i = 0;i<n;i++){
            ans[i] = left[i] * right[i];
        }

        return ans;
    }
}
