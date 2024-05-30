'''
Explore
input: string, integer
output: integer - length of the longest substring containing the same letter after the operation

Clarifications
- s consists of ONLY uppercase English words
- If the length of the input string 0, should I return 0? Yes
- Are we allowed to replace only a single type of character? Yes
- Can k be larger than the length of the string? No, k<= s.length

Test cases
"ABAB", 2 -> 4 (AAAA / BBBB)
"AAAAA", 2 -> 5
"", 3 -> 0
"AABBA", 0 -> 2

Brainstorm
- brute force: We can try replacing each character with every other character. But it will take O(26n^2)
- optimal: Use sliding window with the frequency counter to keep track of the most frequent 
    chracter in the current window. We will try to make every character into the most frequent character.

Plan
1. Initialize count dictionary, left pointer and the result variable. 
2. While right pointer is less than the length of the string
    2-1. Update the character count
    2-2. If the window size - count of the most frequent value is greater than k,
        2-3. Move and update the left pointer and the count dictionary
    2-4. Update the result
3. Return result

=> TC: O(N), SC: O(26) -> O(1)
'''

def characterReplacement(s, k):
    count = {}
    left, result = 0, 0

    for right in range(len(s)):
        count[s[right]] = count.get(s[right], 0) + 1
        window = right - left + 1
        while (window) - max(count.values()) > k:
            count[s[left]] -= 1
            left += 1
        result = max(result, window)
    return result



# normal case
print(characterReplacement("ABAB", 2) == 4)
print(characterReplacement("AAAAA", 2) == 5)

# edge case
print(characterReplacement("", 3) == 0)
