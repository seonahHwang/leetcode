'''
❓ rotated 된 array가 주어졌을때, O(log n)시간복잡도로 minimum element를 찾는 문제

Explore
input: array[int] - rotated sorted
output: integer - minimum element of the array

Clarifications
1. Is the array guranteed to be non-empty? Yes
2. Can the array have duplicate elements? No

Test Cases
[4,5,6,7,1,2] -> 1
[1] -> 1
[2,1] -> 1

Brainstorm
- Brute Force: we can just iterate over the array. O(N), 
But this is not the time complexity that the question is asking for
- Binary search: if we find the mid point, we can check if we are in the left portion or right portion
We can keep checking until left < right, and return the minimum element. O(logn)

Plan
1. declare two pointers: left, right
2. While left < right
    2-1. Find the mid point and the value
    2-2. If the mid value is greater than the num[right], that means we are in the left portion
        2-3. Decrease the range mid + 1
    2-4. Else, we are in the right portion. Decrease the range mid - 1
3. Return num[left]
=> TC: O(logn), SC: O(1)
'''

def findMin(nums):
    left, right = 0, len(nums) - 1

    while left < right:
        mid = (left + right) // 2
        mid_val = nums[mid]

        if mid_val > nums[right]:
            left = mid + 1
        else:
            right = mid
    
    return nums[left]

# normal case
print(findMin([3,4,5,6,7,1,2]) == 1)

# edge case
print(findMin([1]) == 1)
print(findMin([2,1]) == 1)
