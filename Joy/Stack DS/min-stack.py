'''
❓ Design a stack that supports push, pop, top and get minimum element in O(1)

Clarifications
1. Each method should be implemented in O(1)
2. If pop, getMin, top method is called on empty stack, do I return None? -> Yes

Brainstorm
- brute force: If getMin is called, go through the stack and find the minimum value O(N)
- optimal approach: When push the element, use tuple to store the (value, minimum up to that point) O(1)

=> TC: O(1), SC: O(N)
'''

class MinStack:
    def __init__(self):
        self.stack = []

    def push(self, val):
        if not self.stack:
            self.stack.append((val, val))
        else:
            self.stack.append((val, min(val, self.stack[-1][1])))

    def pop(self):
        self.stack.pop()
    
    def top(self):
        return self.stack[-1][0]

    def getMin(self):
        return self.stack[-1][1]

