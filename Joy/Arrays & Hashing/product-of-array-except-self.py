'''
Explore
input: array[int]
output: array[int] - array[i] is equal to the product of all the elements of nums except nums[i]

Questions
1. If the given array is empty, do I return empty array?  Yes
2. If the given array has 1 element, do I return [1]? Yes
3. Can the array contain zeroes? Yes

Test Considerations
[1, 2, 3, 4] -> [24, 12, 8, 6]
[1, 0, 2, 3] -> [0, 6, 0, 0]
[5] -> [1]
[] -> []

Brainstorm
- brute force: double for-loop O(N^2)
- optimal approach: Use two arrays to store cumulative product from the left and right,
then use result array to store the multiiplications of those arrays

Plan
1. Initialize the left and right arrays with left and right multipliers
2. Iterate over the array
    2-1. from left to right, update l_arr with the cumulative product from the left
    2-2. from right to left, update r_arr with the cumulative product from the right
3. Use result array to multiply elements of l_arr and r_arr

=> TC: O(N), SC: O(N)

'''


def productExceptSelf(nums):
    n = len(nums)
    l_mult, r_mult = 1, 1
    l_arr, r_arr = [0] * n, [0] * n

    for i in range(n):
        j = -i - 1
        l_arr[i] = l_mult
        r_arr[j] = r_mult
        l_mult *= nums[i]
        r_mult *= nums[j]
    
    return [l * r for l, r in zip(l_arr, r_arr)]


# normal case
print(productExceptSelf([1, 2, 3, 4]) == [24, 12, 8, 6])
print(productExceptSelf([1, 0, 2, 3]) == [0, 6, 0, 0])

#edge case
print(productExceptSelf([5]) == [1])
print(productExceptSelf([]) == [])
