package Arrays_Hashing;
import java.util.HashMap;

class contains_duplicate{
    public static void main(String[] args) {
        int arr[] = {1,2,3,4};
        System.out.println(containsDuplicate(arr));
    }
    public static boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])) map.put(nums[i],1);
            else return true;
        }
        return false;
    }
}
