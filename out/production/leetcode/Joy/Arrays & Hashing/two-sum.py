'''
Explore
input: array[int], integer - target
output: array - indices of the two numbers that add up to target

Questions
1. Are the arrays sorted? No
2. Can there be duplicate elements in the array? Yes
2. Can the array contain the negative numbers? Yes

Test Cases
[2, 7, 11, 15], 9  ->  [0, 1]
[1, 2, 3, 4, 5], 10 -> False

[3, 3], 6 -> [0,1]
[1, -1], 0 -> [0,1]

Brainstorm
1. Brute-force: Double for-loop O(N^2)
2. Efficient: use dictionary O(N)

Plan
1. Declare the dictionary
2. Go through each element in the array
    2-1. find diff between the current element and the target
    2-2. check if diff in the array
        2-3. Return the indices if exist
    2-4. Add the value in the dict

TC: O(N), SC: O(N)
'''

def twoSum(nums, target):
    num_dict = {}
    for i, num in enumerate(nums):
        diff = target - num
        if diff in num_dict:
            return [num_dict[diff], i]
        num_dict[num] = i

# normal case
print(twoSum([2, 7, 11, 15], 9) == [0, 1])
print(twoSum([1, 2, 3, 4, 5], 10) is None)

# edge case
print(twoSum([3, 3], 6) == [0,1])
print(twoSum([1, -1], 0) == [0, 1])
 