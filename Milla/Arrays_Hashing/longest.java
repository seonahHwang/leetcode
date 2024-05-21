package Milla.Arrays_Hashing;

import java.util.HashSet;

public class longest {
    /*
    * Explore

    Clarifications
    1. What if the array length is one or zero. => we returen one/zero.
    2. Is there same number in one sequence?
    *
    Test Cases

    Brainstorm
    1. Should I sort array?
    => No. Just find if there is next element or not.
    2. How can we check if is it consecutive sequence
    *  => the difference between current element and next element is would be 1.
    3. test case [1,2,1,0]
    * => we can skip when next element is same as previous one.
    *
    *
    Plan
    * 1. Use hashset to check if it has specific elements or not.
    * 2. Find out first element. It means find element which has no left neighbor
    * 3. it might have several sequence so we need to compare their legnth.
    *   if it has +1 element, we can up count.
    * 4. compare length to find max count.

    *
    TC: O(N), SC: O(N)
    *
    *
    * */
    public static void main(String[] args) {
        int arr[] = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(arr));
    }
    public static int longestConsecutive(int[] nums) {
        if(nums.length == 0 || nums.length == 1) return nums.length;
        HashSet<Integer> set = new HashSet();

        for (int i = 0 ; i<nums.length ; i++){
            set.add(nums[i]);
        }

        int ans = 0;
        for(Integer item : set){
            if(set.contains(item - 1)) continue; // 왼쪽요소가 연속되지 않는 요소부터 시작해야하므로
            int nextval = item + 1;
            int len = 1;
            while (set.contains(nextval)){ //+1 한 숫자가 set안에 있다면 계속 1씩 증가하면서 확인하기, 카운트 세기
                nextval++;
                len++;
            }
            ans = Math.max(ans,len);
        }
        return ans;
    }
}
