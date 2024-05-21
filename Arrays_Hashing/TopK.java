package Arrays_Hashing;

import com.sun.source.tree.Tree;

import java.util.*;

public class TopK {
    /* 미팅 이후 다시 풀어보기!
    * Edge case
    * 1) what if length of array is 0 => 1 <= numbs.length <= 10^5
    * 2) what if some elements have same count => It's unique
    *
    * Solution
    * 1. count how they show in array each numbers using hashmap
    * 2. use PriorityQueue for sorting
    * 3. loop until reach to K
    *
    * TC =>
    * SC =>
    * */
    public static void main(String[] args) {
        int arr[] = {1,1,1,2,2,3};
        int k = 2;
        topKFrequent(arr,2);
    }
    public static int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer,Integer> numFrequencyMap = new HashMap<>();

        for(int i=0 ; i < nums.length ; i++){
            if(numFrequencyMap.containsKey(nums[i])){
                numFrequencyMap.put(nums[i],numFrequencyMap.get(nums[i])+1);
            }else {
                numFrequencyMap.put(nums[i],1);
            }
        }
        PriorityQueue<Map.Entry<Integer,Integer>> topKElements = new PriorityQueue<>((e1,e2) -> e1.getValue() - e2.getValue());
        for(Map.Entry<Integer,Integer> entry : numFrequencyMap.entrySet()){
            topKElements.add(entry);
            if(topKElements.size() > k){
                topKElements.poll();
            }
        }

        int[] topNumbers = new int[k];
        int cnt = 0;
        while (!topKElements.isEmpty()){
            topNumbers[cnt] = topKElements.poll().getKey();
            cnt++;
        }
        return topNumbers;
    }
}
