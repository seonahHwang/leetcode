package Milla.LinkedList;

/*

* Edgecase
* Brainstorm
* We need to identify the duplicate in the array without modifying the array and using only constant extra space.
* Use Floyd's algorithm to find the duplicate.
* Use two pointers, slow and fas, to detect the cycle formed by the duplicate number.
*
* Plan
* Both slow and fast pointers start at the first element of the array.
* Move slow pointer one step at a time
* Move fast pointer twe steps at a time
* Continue unitl slow and afast meet inside the cycle.
*
* And I'll start second round.
* Move fast pointer back to the start of the array/
* Move both slow and fast pointer one step at a time unitl they meet again.
* The meeting point tis the duplicate number.
*
* TC : each pointer moves at most n stpes So time complexity is going to be O(n)
* SC : just O(1) because I'm not going to use extra data structures.
*
* */
public class FindDuplicateInteger {
    public static void main(String[] args) {

    }

    public int findDuplicate(int[] nums) {
        //Initialize the slow and fast pointers to the first element of the array
        int slow = nums[0];
        int fast = nums[0];


        do{
            slow = nums[slow];
            fast = nums[nums[fast]]; //move fast pointer two steps
        }while (slow != fast); //countinue until slow and fast pointers meet

        //To find the duplicate, move the fast pointer to the start of the array.
        fast = nums[0];

        //Move both pointers one stpe at a time unitl they meet
        while (slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        //I'm going to return meeting point which is the duplicate number.
        return slow;
    }
}
