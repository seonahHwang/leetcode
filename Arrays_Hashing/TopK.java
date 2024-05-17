package Arrays_Hashing;

import com.sun.source.tree.Tree;

import java.util.*;

public class TopK {
    /*
    * Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
    * */
    public static void main(String[] args) {
        int arr[] = {1,1,1,2,2,3};
        int k = 2;
        topKFrequent(arr,2);
    }
    public static int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else {
                map.put(nums[i],1);
            }
        }

        Map<Integer,Integer> map2 = new HashMap<>();

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            map2.put(entry.getValue(),entry.getKey());
        }
        List<Integer> keySet = new ArrayList<>(map2.keySet());

        // 키 값으로 오름차순 정렬
        Collections.sort(keySet);

        int cnt = 0 ;
        for (Integer key : keySet) {
            if(cnt > ans.length-1) break;
            ans[cnt] = key;
            cnt++;
        }
        return ans;
    }
}
