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


# TWO SUM
class Solution:
    def sortColors(self, nums: List[int]) -> None:
        
        zero = 0
        one = 0
        two = 0

        for val in nums:
            if val == 0:
                zero += 1

            elif val == 1:
                one += 1

            else:
                two += 1

        for i in range(zero):
            nums[i] = 0

        for i in range(zero, zero + one):
            nums[i] = 1

        for i in range(zero + one, zero + one + two):
            nums[i] = 2



# ************************************************************************************************************
# MAJORITY ELEMENT->https://leetcode.com/problems/majority-element/description/

# BRUTE FORCE

class Solution {
    public int majorityElement(int[] nums) {
        
         if(nums.length==1){
            return nums[0];
        }
        int max=0;
        int valu=nums[0];

        
        for(int i=0;i<nums.length;i++){
            int val=nums[i];
            int count=1;

            for(int j=i+1;j<nums.length;j++){
                if(val==nums[j]){
                    count++;
                     if(count>max){
                        max=count;
                        valu=nums[j];

                     }
                }
            }
        }

        if(max>(nums.length/2)){
            return valu;
        }

        return -1;
    }
}


# BETTER ONE

class Solution {
    public int majorityElement(int[] nums) {

        if(nums.length==1){
            return nums[0];
        }

        Map<Integer,Integer> hm = new HashMap<>();
        int max=0;
        int val=nums[0];

        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }

        for(Map.Entry<Integer, Integer> e : hm.entrySet()) {
            int key=e.getValue();
            if(max<key){
                max=key;
                val=e.getKey();

            }
            

            
        }
        
        if(max>(nums.length/2)){
            return val;
        }

        return -1;
    }
}