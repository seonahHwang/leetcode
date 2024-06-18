'''
❓ 시간 기반으로 여러 값을 저장하고 특정 타임스탬프에서 값을 검색하는 TimeMap 클래스를 디자인하는 문제
Explore
- input: 'set(k, v, t)' : a method to set a value for a key at a specific t
    'get(key, timestamp)' : a method to retreive the value associated with a key 
    at the largest timestamp less than or equal to the given timestamp
- output
    - set(): no return value
    - get(): value correspondign to the key at the given timestamp

Clarification
- Is it guranteed that the timestamps are increasing for each key? Yes

Brainstorm
- brute force: iterate through the list for the key and find the largest timestamp 
less than or equal to the given timestamp. O(N)
- optimal: use binary search O(logn), use hash for storage. key: [[val, timestamp]]

Plan
1. TimeMap class - define keyStore -> key: [[val, timestamp]]
2. Set method - append the item 
3. Get method - use binary search to find the largest timestamp les than or equal
    to the given timestamp. return empty string if no valid found

=> TC: O(logN), SC: O(N)
'''

class TimeMap:
    def __init__(self):
        self.keyStore = {} # key: list of [val, timestamp]

    def set(self, key: str, value: str, timestamp: int) -> None:
        if key not in self.keyStore:
            self.keyStore[key] = []
        self.keyStore[key].append([value, timestamp])

    def get(self, key: str, timestamp: int) -> str:
        res, values = "", self.keyStore.get(key, [])
        left, right = 0, len(values) - 1
        while left <= right:
            mid = (left + right) // 2
            if values[mid][1] <= timestamp:
                res = values[mid][0]
                left = mid + 1
            else:
                right = mid - 1
        return res
