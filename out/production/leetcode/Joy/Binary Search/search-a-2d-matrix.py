'''
Explore
input: 2D array[int], integer - target
output: Boolean 

Clarification
1. Is the matrix always sorted in ascending order both row-wise and column-wise? -> Yes
2. Can the matrix be empty? No

Test Case
[[1,3,5,7],[10,11,16,20],[23,30,34,60]], 3 -> True
[[1]], 1  -> True

Brainstorm
Brute-force: We can go through each element in the array
Optimal approach: "sorted" -> binary search

Plan
1. declare left and right pointers ( 0, rows * columns - 1)
2. while left <= right
    2-1. Do the binary search

=> TC: O(logN), SC: O(1)
    '''
def searchMatrix(matrix, target):
    if not matrix or not matrix[0]:
        return False

    rows, cols = len(matrix), len(matrix[0])
    left, right = 0, rows * cols - 1

    while left <= right:
        mid = (left + right) // 2
        r = mid // cols 
        c = mid % cols  
        mid_num = matrix[r][c]

        if target == mid_num:
            return True
        elif target < mid_num:
            right = mid - 1
        else:
            left = mid + 1

    return False


matrix = [
  [ 1,  2,  3,  4,  5],
  [ 6,  7,  8,  9, 10],
  [11, 12, 13, 14, 15]
];

print(searchMatrix(matrix, 13) == True)