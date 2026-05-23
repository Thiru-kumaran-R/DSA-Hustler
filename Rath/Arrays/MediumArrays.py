# /************************************************************************************************ */
# 1 TWO SUM->https://leetcode.com/problems/two-sum/description/

# BRUTE FORCE
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        arr=[]

        for i in range(len(nums)):
            a=nums[i]
            j=i+1
            for j in range(i + 1, len(nums)):
                if a+nums[j]==target:
                    arr.append(i)
                    arr.append(j)
                    return arr
                 

        return arr


# OPTIMAL
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        numMap={}
        n=len(nums)

        for i in range(n):
            comp=target-nums[i]
            if comp in numMap:
                return [numMap[comp],i]

            numMap[nums[i]]=i

        return []
        