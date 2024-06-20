'''
❓ tokens 배열[str]가 주어졌을때, Reverse Polish Notation으로 계산한 결과를 반환하는 문제

Explore
input: array[str] - token  
output: integer - calculated result from reverse polish notation

Clarification
- only '+', '-', '*', '/'
- division -> division down. there won't be any case to divide by 0
- Can the input contain negative values? Yes

Test cases
["2","1","+","3","*"] -> 9
=> ((2 + 1) * 3) = 9
["3", "4", "+", "2", "*", "7", "/"] -> 2
=> (3 + 4) * 2 / 7 = 2

Brainstorm
Use stack o(n)

Plan
1. Initialize the stack
2. Iterate through each token in the input list
    2-1. If the token is an operand, convert into the integer and push it onto the stack
    2-2. If the token is an operator, => we need to do the calculation
        => we will pop 2 elements to do the operation, then push it back onto the stack
3. return stack[0]. There should be only one element left. 
-> TC: O(N), SC: O(N)
'''

def evalRPN(tokens):
    stack = []
    
    for token in tokens:
        if token in "+-*/":
            b = stack.pop()
            a = stack.pop()

            if token == "+":
                stack.append(a + b)
            elif token == "-":
                stack.append(a - b)
            elif token == "*":
                stack.append(a * b)
            elif token == "/":
                stack.append(int(a / b))
        else:
            stack.append(int(token))
    return int(stack[0])

print(evalRPN(["2","1","+","3","*"]) == 9   )
print(evalRPN(["3", "4", "+", "2", "*", "7", "/"]) == 2)