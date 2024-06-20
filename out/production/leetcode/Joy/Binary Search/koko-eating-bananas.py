'''
❓ 코코가 주어진 시간 h안에 모든 바나나를 먹을 수 있는 최소한의 속도 k를 찾는 문제

Explore
input: array[int] - piles, integer - hours
output: integer - minimum integer k such that she can eat all banans within h hours

Clarifications
1. Our goal is to make Koko eating the banana as slowly as possible but finish them all within the given hour
2. If h is less than the number of piles, we assume that Koko can't eat the banans? Yes
3. How should the function handle if there are no piles? -> Return 0

Test Case
1) piles = [3,6,7,11], h = 8 -> 4
=> [ceil(3/4) = 1hr, ceil(6/4) = 2hr, ceil(7/4) = 2hr, ceil(11/4) = 3hr]
=> 1 + 2 + 2 + 3 = 8, which is within h = 8

2) piles = [30,11,23,4,20], h = 5 -> 30
=> [ceil(30/30) = 1hr, ceil(11/30) = 1hr, ceil(23/30) = 1hr, ceil(4/30) = 1hr, ceil(20/30) = 1hr]
=> 1 + 1 + 1 + 1 + 1 = 5, which is within h = 5

3) [1,1,1,1], 4 -> 1

Brainstorm
brute-force: Try all possible values of K from 1 to the maximum number of banans in any pile => O(N*max(piles))
optimal approach: Use binary search to find the minimum integer k. O(N*log(max(piles)))

Plan
1. Define helper function to check if Koko can eat all tha banans with k speed within h 
    1-1. calculate hours for the entire array.
    1-2. Check if total hour is less than h
2. Binary Search initialization
    2-1. left, right pointer
    2-2. while left < right
        2-3. set K as the mid value
        2-4. check if Koko can eat all bananas with K speed using the helper function
        2-5. If can, reduce right pointer to find the lower possible k
        2-6. If can't increase left pointer to increase the speed
3. Return right 
=> TC: O(N * log(max(piles))), where N is the number of piles, SC: O(1)S

'''
from math import ceil
def minEatingSpeed(piles, h):
    def canFinishInTime(k):
        hours = 0
        for p in piles:
            hours += ceil(p / k)
        return hours <= h
    
    left, right = 1, max(piles)

    while left < right:
        k = (left + right) // 2
        if canFinishInTime(k):
            right = k
        else:
            left = k + 1
    return right

print(minEatingSpeed([3,6,7,11],8) == 4)
print(minEatingSpeed([30,11,23,4,20], 5) == 30)
print(minEatingSpeed([1,1,1,1], 4) == 1)