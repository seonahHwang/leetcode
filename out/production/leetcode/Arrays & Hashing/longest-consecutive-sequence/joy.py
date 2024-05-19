'''
Explore
input: array[int] - unsorted
output: integer - length of the longest consecutive elements sequence

Clarifications
- If the array is empty, do I return 0? Yes
- Double check that the array is unsorted
- Can the array have the negative numbers? Yes
- If the one element is given, is the function supposed to return 1? Yes

Test Cases
[100, 4, 200, 1, 3, 2] -> 4  - 1,2,3,4
[0, 2, 4, 6] -> 1

[] -> 0
[1] -> 1
[1,1,1] -> 1

Brainstorm
brute-force: we can use nested loops to find the consecutive number, but it will take minimum O(N^2)
optimal: We can use set and put all the values into the set. 
We will start the loop only if num - 1 is in the set -> O(N)

Plan
1. declare the set, put all the values
2. for each number in the set,
    2-1. if number - 1 not in the set,
    2-2. count =1, target = number + 1
    2-3. while target exist,
        2-4. count +=1, target +=1
    2-5. update longest value
3. return longest value

TC: O(N), SC: O(N)
'''

def longestConsecutive(nums):
    if len(nums) == 0:
        return 0
    longest = 0
    num_set = set(nums)

    for num in num_set:
        if num - 1 not in num_set:
            cnt = 1
            target = num + 1
            while target in num_set:
                cnt += 1
                target += 1
            
            longest = max(longest, cnt)
    return longest


# normal case
print(longestConsecutive([100, 4, 200, 1, 3, 2]) == 4)
print(longestConsecutive([0, 2, 4, 6]) == 1)


# edge case
print(longestConsecutive([]) == 0)
print(longestConsecutive([1]) == 1)
print(longestConsecutive([1, 1, 1]) == 1)