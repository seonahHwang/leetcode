'''
Explore
input: array[int], integer k
output: array - k most frequent elements

Clarifications / Questions
- If k is 0 or given array is empty, should I return empty array? -> Yes

Test Cases
[1,1,1,2,2,3], 2 -> [1,2]

[], 0 -> []
[1], 1 -> [1]
[1,2,3], 0 -> []

Brainstorm
- use hash table to count the number of element, and use max heap to store element by its frequency

Plan
1. if num is empty or k is 0, return empty array
2. count the frequency of each element using Counter
3. use max heap to store the elements by their frequency
    3-1. pop the top k elements from the heap
4. return the answer
'''

import heapq
from collections import Counter

def topKFrequent(nums, k):
    if not nums or k == 0:
        return []
    count = Counter(nums)
    heap = []
    for key, val in count.items():
        heapq.heappush(heap, (val, key))
        if len(heap) > k:
            heapq.heappop(heap)
    
    return [key for val, key in heap]

    
# normal case
print(topKFrequent([1,1,1,2,2,3], 2) == [2, 1])
print(topKFrequent([1], 1) == [1])
print(topKFrequent([4,1,-1,2,-1,2,3], 2) == [-1, 2])

# edge case
print(topKFrequent([], 0) == [])
print(topKFrequent([1, 2, 3, 4, 5], 0) == [])
print(topKFrequent([1, 2, 3, 4, 5], 5) == [1, 2, 3, 4, 5])
