'''
Explore
input: string
output: integer - longest subsdtring without repeating characters

Clarifications
1. Can s contain space or special characters? -> Yes
2. If the input string is empty, do I return 0? -> Yes

Test cases
"abcabcbb" -> 3
"aaaa" -> 1
"" -> 0
"a" -> 1

Brainstorm
- brute force: double for loop to check every substring O(N^2)
- optimal: sliding window(two pointers), set O(N)

Plan
1. Declare set - store the current substring to check duplicate
2. Delcare left pointer, longest to 0
3. while right < len(s)
    3-1. while right point is in set -> this means we have duplicate
        3-2. remove left value
        3-3. update left pointer += 1
    3-4. add right value
    3-5. update longest
4. return longest
TC: O(N), SC: O(N)
'''

def lengthOfLongestSubstring(s):
    charSet = set()
    left, longest = 0, 0

    for right in range(len(s)):
        while s[right] in charSet:
            charSet.remove(s[left])
            left += 1
        charSet.add(s[right])
        longest = max(longest, right - left + 1)
    return longest


# normal
print(lengthOfLongestSubstring("abcabcbb") == 3)
print(lengthOfLongestSubstring("aaaa") == 1)

#edge
print(lengthOfLongestSubstring("a") == 1)
print(lengthOfLongestSubstring("") == 0)

