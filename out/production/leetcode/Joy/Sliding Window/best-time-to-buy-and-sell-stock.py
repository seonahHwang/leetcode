'''
Explore
input: array[int] - prices of the stock
output: integer - maximum profit

Clarifications
1. If the array have 1 price, do I return 0? Yes
2. Can the array have the negative price? No

Test Cases
[7,1,5,3,6,4] -> 5
[1,2,3,4,5] -> 4
[5,4,3,2,1] -> 0
[3] -> 0
[1,1,1] -> 0

Brainstorm
Brute force: Double for-loop to check every possibility. O(N^2)
Optimal approahch: Two Pointer (sliding window) O(N)

Plan
1. Declare left and right pointers. (left: sell, right: buy)
2. Declare maxProfit -> we weill keep updating it
3. while right pointer < length of the array
    3-1. if the left price is less than the right price
        3-2. calculate and update max profit
    3-3. Else, move left pointer to the right
    3-4. Increase the right pointer
4. Return max profit

TC: O(N), SC: O(1)
'''

def maxProfit(prices):
    if not prices:
        return 0
    left, right = 0, 1
    maxProfit = 0

    while right < len(prices):
        if prices[left] < prices[right]:
            profit = prices[right] - prices[left]
            maxProfit = max(maxProfit, profit)
        else:
            left = right
        right += 1
    
    return maxProfit


# normal case
print(maxProfit([71,1,5,3,6,4]) == 5)
print(maxProfit([1,2,3,4,5]) == 4)
print(maxProfit([5,4,3,2,1]) == 0)

# edge case
print(maxProfit([3]) == 0)
print(maxProfit([1,1,1]) == 0)
