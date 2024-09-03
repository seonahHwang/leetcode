package Milla.TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//twopointer에 대해서 정리하기!
public class ThreeIntegerSum {
    public static void main(String[] args) {
//        threeSum(new int[]{-1,0,1,2,-1,-4}); //-4,-1,-1,0,1,2
//        threeSum(new int[]{0,0,0});
//        threeSum(new int[]{1,-1,-1,0}); // -1,-1,0,1
        threeSum(new int[]{-1,0,1,2,-1,-4,-2,-3,3,0,4}); //-4,-3,-2,-1,-1,0,0,1,2,3,4
//        int [] a = {-1,0,1,2,-1,-4,-2,-3,3,0,4}; //-4,-3,-2,-1,-1,0,0,1,2,3,4
//        Arrays.sort(a);
//        for (int i = 0; i < a.length; i++) {
//            System.out.print(a[i]+",");
//        }
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if(i>0 && nums[i] == nums[i-1]) continue;
            int target = -nums[i];
            int l = i+1;
            int r = nums.length -1;
            while (l<r){
                System.out.println("i : "+i + "/ l : "+l + "/ r : "+r);
                System.out.println("nums[i] : "+nums[i] + " nums[l] : "+nums[l] + " nums[r] : "+nums[r]);
                int sum = nums[l] + nums[r];
                if(target == sum){
                    System.out.println("////////추가!");
                   ans.add(Arrays.asList(new Integer[]{nums[i],nums[l],nums[r]}));
                    l++;
                    r--;
                   while (l < nums.length && nums[l] == nums[l-1]){ //l과 r을 같이 엮으면 안됌!! 놓치는 케이스가 생겨버림
                       l++;
                   }
                   while (r > 0 && nums[r] == nums[r+1]) r--;
                }
                else if(sum < target){
                    l++;
                }else r--;
            }
        }
        return ans;
    }
}
