'''
❓ Given the integer n, write a function to generate all combinations of valid parentheses. only using ( )
Explore
input: integer - n
output: array[str] - all combinations of valid parentheses using ( and )

Clarifications
- If the given integer is 0, do I return the empty array? Yes
- Does the order matter? For example, ()(()) and (())() the same? Yes, order mattters. They are not the same

Test Cases
n = 3 -> ["((()))","(()())","(())()","()(())","()()()"]
n = 1 -> ["()]
n = 0 -> []

Brainstorm
- brute force: make all the possible variations. filter out the valid ones. -> O(2^N)
- optimal: backtracking. n open parenthesis, n closing parenthesis (# close < # open) 

Plan
1.  declare stack and result array
2.  declare backtracking helper function taking number of open parenthesis and cloed parenthesis as parameters
    2-1. return condition: if openN == closedN == n
    2-2. if openN is less than n, keep calling backtracking
    2-3. if closedN is less than openN, keep calling backtracking
3. return result

'''

def generateParenthesis(n):
    stack = []
    res = []

    def backtrack(openN, closedN):
        if openN == closedN == n:
            res.append("".join(stack))
            return

        if openN < n:
            stack.append("(")
            backtrack(openN + 1, closedN)
            stack.pop()
        
        if closedN < openN:
            stack.append(")")
            backtrack(openN, closedN + 1)
            stack.pop()
    
    backtrack(0, 0)
    return res


# normal case
print(generateParenthesis(3))

# edge case
print(generateParenthesis(1))
print(generateParenthesis(0))