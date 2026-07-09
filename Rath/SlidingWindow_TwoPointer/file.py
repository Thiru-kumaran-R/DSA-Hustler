# Longest Substring without repeating Character->https://leetcode.com/problems/longest-substring-without-repeating-characters/
# COMPLEXITY=O(2n)

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        unique=set()

        left=0
        right=0
        maxLength=0

        while right<len(s):

            if s[right] in unique:

                while s[left]!=s[right]:
                    unique.remove(s[left])
                    left+=1
                left+=1
                    
            unique.add(s[right])             
            maxLength=max(maxLength,right-left+1)
            right+=1


        return maxLength
