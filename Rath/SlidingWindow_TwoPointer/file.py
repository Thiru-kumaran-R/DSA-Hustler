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



# MAX CONSECUTIVE ONES||| ->https://leetcode.com/problems/max-consecutive-ones-iii/description/

# complexity=O(2n)
# BETTER SOLUTION
class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:

        if len(nums)==1 and nums[0]==1:
            return 1

        right=0
        left=0
        maxLength=0
        zero=0

        while right<len(nums):
            if nums[right]==0:
                zero+=1

            if zero>k:
                while nums[left]!=0:
                    left+=1
                left+=1
                zero-=1

            maxLength=max(maxLength,right-left+1)

            right+=1


        return maxLength
            

# OPTIMAL SOLUTION-O(n)

class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:

        if len(nums)==1 and nums[0]==1:
            return 1

        right=0
        left=0
        maxLength=0
        zero=0

        while right<len(nums):
            if nums[right]==0:
                zero+=1

            if zero>k:
                if nums[left]==0:
                    zero-=1
                left+=1
                         
            if zero<=k:
                maxLength=max(maxLength,right-left+1)

            right+=1


        return maxLength
            

        
        