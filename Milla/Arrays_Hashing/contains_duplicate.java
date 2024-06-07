package Milla.Arrays_Hashing;
import java.util.HashMap;

class contains_duplicate{
    public static void main(String[] args) {
        int arr[] = {1,2,3,4};
        System.out.println(containsDuplicate(arr));
    }
    public static boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap();
        for(int i=0;i<nums.length;i++){ // start a loop to go through each number in the array.
            if(!map.containsKey(nums[i])) map.put(nums[i],1); //for each number, I'll check if it its already in the map.
            else return true; // if the number is already in the map, it means we've found a duplicate. So we return true.
        }
        return false;
    }
}
