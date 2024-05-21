'''
Explore
input: array[int] - sorted array, integer - target
output: array[int] - indices + 1 of two numbers adding up to the target

Clarifications
- can the array have the duplicated values? Yes
- constant extra space time -> O(1)
- array is sorted
- can the array have negative numbers? Yes 

Test Cases
[2, 7, 11, 15], 9 -> [1, 2]
[1, 2], 3 -> [1, 2]
[-3, 3, 1, 2], 0 -> [1, 2]


Brainstorm
- brute force: double for-loop O(N^2) , SC O(1) 
- optimal solution: two pointer O(N), SC O(1)

Plan
1. initialize the left and the right pointers
2. while left < right
    2-1. calculate the current sum
    2-2. if the current sum == target, return the indicies
    2-3. if the current sum > target, decrement the right pointer
    2-4. if the current sum < target, increment the left pointer

=> TC: O(N), SC: O(1)

'''

def twoSum(nums, target):
    left, right = 0, len(nums) - 1
    while left < right:
        current_sum = nums[left] + nums[right]
        if current_sum == target:
            return [left + 1, right + 1]
        elif current_sum > target:
            right -= 1
        else:
            left += 1


# normal case
print(twoSum([2, 7, 11, 15], 9) == [1, 2])

# edge case
print(twoSum([1, 2], 3) == [1, 2])
print(twoSum([-3, 3], 0) == [1, 2])

