'''
Explore
input: array[int] - heights
output: integer - maximum amount of water a container can store

Clarification
- Can the array contain the duplicated heights? Yes
- Can the height be negative? No
- Can the array contain zero heights? Yes

Test Cases
[1,8,6,2,5,4,8,3,7] -> 49
[1, 1] -> 1
[0,0,2,0,0] -> 0

Brainstorm
-brute force: double for-loop O(N^2)
-optimal: Two Pointer- TC O(N), SC O(1)

Plan
1. Initialize two pointers
2. Iterate with two pointers
    2-1. calculate the area using left and right pointers
    2-2. Update teh max area
    2-3. Move the poitners
3. Return max area

=> TC O(N), SC O(1)

'''

def maxArea(height):
    left, right = 0, len(height) - 1
    max_area = 0

    while left < right:
        w = right - left
        h = min(height[left], height[right])
        area = w * h
        max_area = max(max_area, area)

        if height[left] < height[right]:
            left += 1
        else:
            right -= 1

    return max_area



# normal case
print(maxArea([1,8,6,2,5,4,8,3,7]) == 49)

# edge case
print(maxArea([1, 1]) == 1)
print(maxArea([0, 0, 2, 0, 0]) == 0)
print(maxArea([]) == 0)

