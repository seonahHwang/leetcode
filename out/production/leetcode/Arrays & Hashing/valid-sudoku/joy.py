'''
Explore
input: 2D array[string], "." means empty
output: boolean - check if the sudoku is valid or not

Clarifications
- board will only have 1-9 and . all in string. "." means empty
- board row x col lengths will be 9 fixed. 
- should the function handle invalid input sizes or characters? 
    -> No, you will always assume the input is always valid
- do we follow regular sudoku rule, or just given rule? -> Just given rule

Test Cases
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]] -> True


[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]] -> False

All empty board

Brainstorm
Use set to store the values in row, col, sub_boxes
Iterating through the board and check if the value is in row, col, sub_boxes for the validation check
-> O(N)
For the sub_box, the key will be (r//3, c//3)

Plan
1. Declare the variables row, col, sub_boxes using  defaultdict(set)
2. Explore the matrix
    2-1. If the current value is empty ("."), continue
    2-2. Check if the current value is in row, col or sub_box
        -> Return False
    2-3. Add the value 
3. Return True 

TC: O(N), SC: O(N)

'''
from collections import defaultdict
def isValidSudoku(board):
    row = defaultdict(set)
    col = defaultdict(set)
    sub_box = defaultdict(set)

    for r in range(9):
        for c in range(9):
            if board[r][c] == ".":
                continue
            if (board[r][c] in row[r] 
                or board[r][c] in col[c]
                or board[r][c] in sub_box[(r//3, c//3)]):
                return False
            row[r].add(board[r][c])
            col[c].add(board[r][c])
            sub_box[(r//3, c//3)].add(board[r][c])
    
    return True

# normal case
print(isValidSudoku([["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]) == True)

print(isValidSudoku([["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]) == False)

# edge case
print(isValidSudoku([[".",".",".",".","7",".",".",".","."]
,[".",".",".",".",".",".",".",".","."]
,[".",".",".",".",".",".",".",".","."]
,[".",".",".",".",".",".",".",".","."]
,[".",".",".",".",".",".",".",".","."]
,[".",".",".",".",".",".",".",".","."]
,[".",".",".",".",".",".",".",".","."]
,[".",".",".",".",".",".",".",".","."]
,[".",".",".",".",".",".",".",".","."]]) == True)