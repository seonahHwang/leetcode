'''
Explore
input: 2 strings 
output: bolean - return true if the strings are anagrams

Questions
1. Should the comparison be case sensitive? No
2. Can the input including number, special characters ...? No

Test Cases
"anagram, "nagaram" -> True
"happy", "ypahe" -> False
"a", "a" -> True
"", "" -> True

Brainstorm
1. brute force -> double for-loop O(N^2)
2. Efficient -> use dictionary to store each character and compare. O(N)

Plan
1. Compare the length of the strings. Return False if they are different 
2. Declare two dictionaries
3. Iterate through the string
    3-1. Put each character in the dictionary key:character, value: count
4. Return True if they are the same. 

TC: O(N), SC: O(N) 
'''

def isAnagram(s, t):
    if len(s) != len(t):
        return False
    
    countS, countT = {}, {}
    for i in range(len(s)):
        countS[s[i]] = countS.get(s[i], 0) + 1
        countT[t[i]] = countT.get(t[i], 0) + 1
    
    return countS == countT


# normal case
print(isAnagram("anagram", "nagaram") == True)
print(isAnagram("happy", "slkdjf") == False)

# edge case
print(isAnagram("a", "a") == True)
print(isAnagram("", "") == True)
