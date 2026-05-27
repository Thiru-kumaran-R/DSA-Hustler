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


# *******************************************************************************************
# 53 Maximum Subarray->https://leetcode.com/problems/maximum-subarray/description/

# Brute and Better O(n^2)

class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        
        maxx=float('-inf')
        for i in range(len(nums)):
            sum=0
            for j in range(i,len(nums)):
                sum+=nums[j]
                maxx=max(sum,maxx)
            
             

        return maxx

# KADANE'S ALGORITHM O(n)

class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        
        maxx=float('-inf')
        summ=0
        for val in nums:
            summ+=val

            maxx=max(summ,maxx)

            if summ<0:
                summ=0

        return maxx
        

# 121 BUY AND SELL STOCKS->https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

class Solution:
    def maxProfit(self, nums: List[int]) -> int:
        
        maxProfit=0
        buy=nums[0]

        for i in range(1,len(nums)):
            if buy < nums[i]:
                maxProfit=max(maxProfit,nums[i]-buy)

            else:
                buy=nums[i]


        return maxProfit



# ****************************************************************************************************
# 2149 Reaarange array element by sign->https://leetcode.com/problems/rearrange-array-elements-by-sign/description/
# BRUTE FORCE

class Solution:
    def rearrangeArray(self, nums: List[int]) -> List[int]:

        arr1=[0]*(len(nums)//2)
        arr2=[0]*(len(arr1))
        k=0
        l=0

        for i in range(len(nums)):
            if nums[i]>=0:
                arr1[k]=nums[i]
                k+=1

            else:
                arr2[l]=nums[i]
                l+=1

        li=[]
        k=0
        l=0

        for i in range(len(nums)):
            if i%2==0:
                li.append(arr1[k])
                k+=1
            else:
                li.append(arr2[l])
                l+=1
        return li


# OPTIMAL APPROACH
class Solution:
    def rearrangeArray(self, nums: List[int]) -> List[int]:

        li=[]
        posIndex=0
        negIndex=1 

        for i in range(len(nums)):
            if nums[i]>=0:
                 li.insert(posIndex,nums[i])
                 posIndex+=2

            else:
                li.insert(negIndex,nums[i])
                negIndex+=2
                 

        
        return li
# IF THE NEGATIVE VALUE AND POSITIVE VALUES ARE NOT EQUAL
# BUT TAKING THE BEST CASE COMPLEXITY O(3N/2) AND O(2N) FOR THE WORST CASE

from typing import List

class Solution:
    def rearrangeArray(self, nums: List[int]) -> List[int]:
        pos = []
        neg = []

        for val in nums:
            if val >= 0:
                pos.append(val)  
            else:
                neg.append(val)  

        if len(pos) > len(neg):
            for i in range(len(neg)):
                nums[i * 2] = pos[i]
                nums[i * 2 + 1] = neg[i]
            
            j = len(neg) * 2
            pos_ptr = len(neg)   
            for i in range(j, len(nums)):
                nums[i] = pos[pos_ptr]
                pos_ptr += 1

        else:
            for i in range(len(pos)):
                nums[i * 2] = pos[i]
                nums[i * 2 + 1] = neg[i]
            
            j = len(pos) * 2
            neg_ptr = len(pos)   
            for i in range(j, len(nums)):
                nums[i] = neg[neg_ptr]
                neg_ptr += 1

        return nums   


        
# PRINT ALL PERMUATIONS
class Solution {

    public void recPermu(int[] nums,List<Integer> ds, List<List<Integer>> ans, boolean[] freq  ){
        if(ds.size()==nums.length){
            ans.add(new ArrayList<>(ds));
            return ;
        }

        for(int i=0;i<nums.length;i++){
            if(!freq[i]){
                freq[i]=true;
                ds.add(nums[i]);
                recPermu(nums,ds,ans,freq);
                ds.remove(ds.size()-1);
                freq[i]=false;
            }
        }
    }


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> ds = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];

        recPermu(nums,ds,ans,freq);
        return ans;
    }
}

# PYTHON

from typing import List

class Solution:
    def recPermu(self, nums: List[int], ds: List[int], ans: List[List[int]], freq: List[bool]):
        if len(ds) == len(nums):
            ans.append(ds.copy())   
            return

        for i in range(len(nums)):
            if not freq[i]:  
                freq[i] = True
                ds.append(nums[i]) 
                
                self.recPermu(nums, ds, ans, freq)  
                ds.pop()  
                freq[i] = False

    def permute(self, nums: List[int]) -> List[List[int]]:
        ans = []
        ds = []
        freq = [False] * len(nums)   

        self.recPermu(nums, ds, ans, freq)
        return ans


# NEXT PERMUTATION->https://leetcode.com/problems/next-permutation/description/

# BRUTE FORCE IS FINDING ALL THE PERMUTATIONS

# OPTIMAL SOLUTION


