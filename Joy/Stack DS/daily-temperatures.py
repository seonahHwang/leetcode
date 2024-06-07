'''
Explore
input: array[int] - temperatures with each day represents the daily temperatures
output: array[int] - answer[i] is the number of days you have to wait to get it warmer

Clarifications
- Can the array be empty? No. 
- If the array have all the same temperature, do I return [0,0,0...]? Yes

Test Cases
[73,74,75,71,69,72,76,73] -> [1,1,4,2,1,1,0,0]
[30, 20, 10] -> [0,0,0]
[10] -> [0]
[10,10,10] -> [0,0,0]

Brainstrom
- Brute Force: use nested loop to compare each day O(N ^2)
- Optimal Approach: Use stack. We will only store the previous index

Plan
1. Declare ans array filled with 0s and stack
2. Iterate through teh tempeartues array
    2-1. If stack and the top of the stack is less than the current temperature (high temperature found!)
        2-2. pop the stack, and store the value to the previous  index
        2-3. Update the ans for the current position. (i - previous index)
    2-4. Add the index to the stack
    2-5. Return the answer array

=> TC: O(N), SC: O(N)
'''

def dailyTemperatures(temperatures):
    ans = [ 0 for _ in range(len(temperatures))]
    stack = []

    for i, n in enumerate(temperatures):
        while stack and temperatures[stack[-1]] < n:
            prev_index = stack.pop()
            ans[prev_index] = i - prev_index
        stack.append(i)
    return ans


# normal case
print(dailyTemperatures([73,74,75,71,69,72,76,73]) == [1,1,4,2,1,1,0,0])
print(dailyTemperatures([30,20,10]) == [0,0,0])

# edge case
print(dailyTemperatures([10]) == [0])
print(dailyTemperatures([10,10,10]) == [0,0,0])