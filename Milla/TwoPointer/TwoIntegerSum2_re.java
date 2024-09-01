package Milla.TwoPointer;

public class TwoIntegerSum2_re {
    public static void main(String[] args) {

    }
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length-1;
        while (l<r){
            int sum = numbers[l]+numbers[r];
            if(sum == target){
                return new int[]{numbers[l],numbers[r]};
            }
            else if(sum < target){
                l++;
            }else r--;
        }
        return new int[]{};
    }
}
