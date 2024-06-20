package Milla.Others;

import java.util.HashMap;
import java.util.Map;

public class K_diff2 {
    public static void main(String[] args) {
        int a[] = {3,1,4,1,5};
//        int a[] = {1,3,1,5,4};
//        int a[] = {1,2,3,4,5};
        System.out.println(findPairs(a,2));
    }
    public static int findPairs(int[] nums, int k) {
        int result = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        HashMap<Integer,Integer> Pairs = new HashMap<>();

        //첫번째 풀이
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }

        for (int i = 0; i <nums.length ; i++) { ////for문안에서 돌리려면 pairs를 사용해서 유니크한 쌍이 맞는지 확인이 필요한데,
            if(map.containsKey(nums[i]+k) && map.get(nums[i]+k) != i && !Pairs.containsKey(nums[i])) {
                result++;
                Pairs.put(nums[i],nums[i]+k);
            }
        }

        //두번째 풀이
//        Map<Integer,Integer> map2 = new HashMap();
//        int result = 0;
//
//        for (int i = 0 ; i < nums.length ; i++){
//            map2.put(nums[i],map2.getOrDefault(nums[i],0)+1); //같은 넘버의 빈도수를 체크함!
//        }
//        for(int num : map2.keySet()){ //그냥 map안에서 돌면 이미 중복값은 나가리 되어있어서 괜찮음!! 대신 이 경우는 k == 0 일 때를 따로 처리해야함!
//            if(k > 0 && map2.containsKey(num+k) || k == 0 && map2.get(num) > 1) result ++;
//        }
//
        return result;
    }
}
