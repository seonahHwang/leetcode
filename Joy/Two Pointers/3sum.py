'''
Explore
input: array[int]
output: 2D array - triplets nums[i] + nums[j] + nums[k] == 0

Clarifications
- Can the input array have the duplicated values? Yes
- Can the array contain the negative values? Yes
- Double check if the out should be a list of unique triplets that sum up to zero
- If there are no possible triplet sum up to 0, do we return empty array? Yes

Test Cases
[-1,0,1,2,-1,-4] -> [[-1,-1,2],[-1,0,1]]
[0,1,1] -> []
[0,0,0] -> [[0,0,0]]

Brainstorm
- brute force: Use loops to check all the possible scenarios O(N^3)]
- optimal approach: use three pointer. 
    -one pointer iterate through the array, 
    -other two pointers will find the pairs that sum up to the complement to the current element 

Plan
1.Sort the array  => in order to use pointers, the array must be sorted
2.Iterate through the array
    2-1. initialize left and right pointers
    2-2. If the sum is zero, add the triplet to the result list
    2-3. If the sum > target:
        move right pointer -= 1 
    2-4. If the sum < target:
        move left pointer += 1
'''


def threeNumberSum(nums):
    result = []
    nums.sort()

    for i, a in enumerate(nums):
        left, right = i + 1, len(nums) - 1

        if i > 0 and a == nums[i-1]:
            continue

        while left < right:
            num_sum = a + nums[left] + nums[right]

            if num_sum > 0:
                right -= 1
            
            elif num_sum < 0:
                left += 1
            
            else:
                result.append([a, nums[left], nums[right]])
                left += 1
                right -= 1
                while nums[left] == nums[left - 1] and left < right:
                    left += 1
    
    return result

    
# normal case
print(threeNumberSum([-1,0,1,2,-1,-4]) == [[-1,-1,2],[-1,0,1]])

# edge case
print(threeNumberSum([0,0,1]) == [])
print(threeNumberSum([0,0,0]) == [[0,0,0]])
