package Milla.Others;

import java.util.HashMap;
import java.util.Map;
/*
*
* */
public class K_diff {
    // k 만큼 차이나는 pair의 개수
    /*
    * 배운점 : map.getOrDefault(), for(int num : map.keySet())
    * */
    public static void main(String[] args) {
        int n[] = {3,1,4,1,5};
        int k = 2;
        int n2[] = {1,2,3,4,5};
        int k2 = 1;
        int n3[] = {1,3,1,5,4};
        int k3 = 0;
        int n4[] = {1,2,4,4,3,3,0,9,2,3}; //답 2
        int k4 = 3;
        System.out.println(findPairs(n,k));
        System.out.println(findPairs(n2,k2));
        System.out.println(findPairs(n3,k3));
        System.out.println(findPairs(n4,k4));
    }
    public static int findPairs(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap();
        int result = 0;


        for (int i = 0 ; i < nums.length ; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        for(int num : map.keySet()){
            if(k > 0 && map.containsKey(num+k) || k == 0 && map.get(num) > 1) result++;
        }
        return result;
    }
}
