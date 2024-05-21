'''
Explore
input: array[str]
output: 2-D array - grouped anagrams

Clarifications / Questions
- only lowercase english letters -> not case sensitive
- If given input is empty, return empty array

Test Cases
["eat","tea","tan","ate","nat","bat"] -> [["bat"],["nat","tan"],["ate","eat","tea"]]
[""] -> [[""]]
["a"] -> [["a"]]

Brainstorm
1. sorting strings - sort each word in the alphabetical order. 
Use dictionary to have sorted word as a key, actual word as the value. O(nlogn)
2. use dictionary to store actual count to array [0,0,...] (26), 
and have it as a key, actual word as the value. O(N)

Plan
1. Initialize the dictionary using defaultdict
2. For each word, declare teh array with 0s for 26  -> store the frequency
    2-1. Add that frequency to the ans, having the frequency as the key, word as the value
3. return ans.values()

# TC: O(N), SC: O(N)

''' 

from collections import defaultdict
def groupAnagrams(strs):
    ans = defaultdict(list)
    for word in strs:
        count = [0] * 26
        for char in word:
            count[ord(char) - ord('a')] += 1
        ans[tuple(count)].append(word)
    return ans.values()


# normal case
print(groupAnagrams(["eat","tea","tan","ate","nat","bat"])) #[['eat', 'tea', 'ate'], ['tan', 'nat'], ['bat']]

# edge case
print(groupAnagrams([""])) #['']]
print(groupAnagrams(["a"])) #['a']]
