'''
❓ rotated 된 array와 target이 주어졌을때, O(log n)시간복잡도로 target의 인덱스를 찾는 문제
Explore
input: array[int] - rotated array, integer - target
output: integer - index of target, or -1 if not in nums

Clarifications
1. Is the array guranteed to be non-empty? Yes
2. Can the array have duplicate elements? No

Test Case
[3,4,5,6,1,2], 2 -> 5    /  [3,1], 1 -> 1   /   [4,5,6,7,1,2,3], 8 -> -1

Brainstorm
- Brute force: iterate through the array to find the target. O(n)
- Optimal approach: Use binary search to find the target. O(logn)

Plan
1. Initialize left, right pointers
2. While left <= right (b/c we are finding the specific number)
    2-1. find the mid point and mid value
    2-2. If mid value is equal to the target, return the index
    2-3. If mid value is greater than the arr[last], that means we are in left portion
        2-4. If nums[left] <= target < mid value, move right pointer. 
        2-5. otherwise, move left pointer
    2-6. Do the same for the right portion
=> TC: O(logn), SC: O(1)
'''
def search(nums, target):
    left, right = 0, len(nums) - 1 
    
    while left <= right:
        mid = (left + right) // 2
        mid_val = nums[mid]

        if mid_val == target:
            return mid
        
        if mid_val > nums[right]:
            if nums[left] <= target < mid_val:
                right = mid - 1
            else:
                left = mid + 1
        
        else:
            if mid_val < target <= nums[right]:
                left = mid + 1
            else:
                right = mid - 1
    return - 1

print(search([3,4,5,6,1,2], 2) == 5)
print(search([3,1,], 1) == 1)
print(search([4,5,6,7,1,2,3], 8) == -1)

