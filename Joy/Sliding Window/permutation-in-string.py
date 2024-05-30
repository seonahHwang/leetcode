'''
Explore
input: 2 strings 
output: boolean - check if one of s1's permutation is the substring of s2

Clarifications
- Input strings only contain lowercase English letters? -> Yes
- Can s1 be longer than s2? -> No

Test cases
- "ab", "eidbaooo" -> True
- "ab", "eiboaoo" -> False
- "a", "a" -> True
- "abc", "a" -> False

Brainstorm
- Brute Force: Generate all permutations of s1 and check if any of them is a substring of s2. O(N!)
- Optimal: Sliding window with chracter frequency comparison. 

Plan
1. If the length of s1 is greater than that of s2, return False
2. Initialize the count arrays hold 26 alphabets
3. Populate the count frequency array. If they are equal, return True
4. Slide the window over s2
    4-1. Update s2Count for the new character entering the window
    4-2. Update s2Count for the old character existing teh window
    4-3. If they are equal, return True
5. Return False

=> TC: O(N) - length of s2, SC: O(26) -> O(1)
'''

def checkInclusion(s1, s2):
    n1, n2 = len(s1), len(s2)

    if n1 > n2:
        return False

    s1Count, s2Count = [0] * 26, [0] * 26

    for i in range(n1):
        s1Count[ord(s1[i]) - ord('a')] += 1
        s2Count[ord(s2[i]) - ord('a')] += 1
    
    if s1Count == s2Count:
        return True

    for i in range(n1, n2):
        s2Count[ord(s2[i])-ord('a')] += 1
        s2Count[ord(s2[i-n1]) - ord('a')] -= 1
        if s1Count == s2Count:
            return True
    
    return False

# normal case
print(checkInclusion("ab", "eidbaooo") == True)
print(checkInclusion("ab", "eiboaoo") == False)

# edge case
print(checkInclusion("a", "a") == True)
print(checkInclusion("abc", "a") == False)