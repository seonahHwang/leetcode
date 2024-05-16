'''
Explore
input: array[int] 
output: boolean - check if the given array has the duplicated number or not

Clarifying Questions
1. Can the same number appear more than 2 times? -> Yes
2. Can the array have the negative numbers? -> Yes

Test Cases
[1,2,3,1] -> True
[1,2,3,4] -> False

[] -> False
[1] -> False

Brainstrom
1. Brute force -> double for-loop O(N^2)
2. Use set -> O(N)

Plan
1. Initialize the set
2. Iterate over the array
    2-1. For each element, check if it's in the set. 
        2-2. Return True if the element is in the set
        2-3. Otherwise, add the element to the set. 
3. return False since no duplicates are found.

=>TC: O(N), SC: O(N)
'''

def containsDuplicate(nums):
    num_set = set()
    for num in nums:
        if num in num_set:
            return True
        num_set.add(num)
    return False


#Normal case
print(containsDuplicate([1,2,3,1]) == True)
print(containsDuplicate([1,2,3,4]) == False)

#Edge case
print(containsDuplicate([]) == False)
print(containsDuplicate([1]) == False)

