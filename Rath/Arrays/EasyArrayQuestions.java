// FINDING THE LARGEST ELEMENT
class Solution {
    public int largestElement(int[] nums) {
        int max=nums[0];
    for(int i=1;i<nums.length;i++){
           if(max<nums[i]){
            max=nums[i];
           }
    }
    return max;
    }
}

//************************************************************************************************* */
//FINDING THE SECOND LARGEST ELEMENT

class Solution {

   public static int max(int []nums){
     int max=nums[0];
    for(int i=1;i<nums.length;i++){
           if(max<nums[i]){
            max=nums[i];
           }
    }
    return max;
   }

    public int secondLargestElement(int[] nums) {
    int maxel=max(nums);
    int secEl=Integer.MIN_VALUE;
    boolean flag=true;
    for(int i=0;i<nums.length;i++){
         if(secEl<nums[i] && nums[i]<maxel){
              secEl=nums[i];
              flag=false;
         }
    }

    if(flag){
        return -1;
    }

    return secEl;

    }
}


//*****************************CHECK IF THE ROTATED ARRAY IS SORTED OR NOT

public boolean check(int[] nums) {
 int cnt=0;
       for(int i=1;i<nums.length;i++){
            if(nums[i-1]>nums[i]){
                cnt++;
            }
       }

       if(nums[0]<nums[nums.length-1]){
        cnt++;
       }
        return cnt<=1;

//******************************************************************************* */

//26 Remove duplicte from sorted array-->https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/

class Solution {
    public int removeDuplicates(int[] nums) {
        
       if(nums.length==1){
        return 1;
       }

       int count=1;
       
       for(int i=1,j=0;i<nums.length;i++){
        if(nums[i]!=nums[j]){
             
            nums[count++]=nums[i];
            j=i;

        }
       }
    return count;
    }
}


// ***********************************************************************************************

//189 Rotate array->https://leetcode.com/problems/rotate-array/description/

// brute force
class Solution {
    public void rotate(int[] nums, int k) {
       
       //brute force
       k=k%nums.length;
       if(nums.length==1){
        return;
       }
       
       int [] arr=new int[k];
       int n=nums.length;
       //copying
       for(int i=0,j=n-k;i<k;i++,j++){
        arr[i]=nums[j];
       }

       //shifting
       for(int i=n-1;i>=k;i--){
        nums[i]=nums[i-k];
       }

       //inserting
       for(int i=0;i<arr.length;i++){
        nums[i]=arr[i];
       }


    }
}

// optimal
class Solution {

public static void reverse(int []arr,int start,int end){
        while(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
}

    
       k=k%nums.length;
       if(nums.length==1){
        return;
       }
 int n=nums.length-1;
     
   reverse(nums,0,n);
   reverse(nums,0,k-1);
   for(int i=0;i<nums.length;i++){
        System.out.print(nums[i]+" ");
    }
   reverse(nums,k,n);

    }
}


//******************************************************************************* */

// MOVE ZERO AT THE END OF ARRAY
class Solution {
    public void moveZeroes(int[] nums) {
        
    
        int n=nums.length;
        if(n==1){
          return;
         }
  
        for(int i=0,j=0;i<n;i++){
             if(i==0 && nums[i]!=0){
                j++;
                continue;
             }
             if(nums[i]!=0){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                j++;
                
             }
//tum gobar bhuddhu ho beta tum chorr do sab tumhari bhuddi me pura pura gobar bhara hai bss
           

        }
    }
}


//****************************************************************************************** */

// UNION OF TWO SORTED ARRAY

// Brute Force
class Solution:
    def unionArray(self, nums1, nums2):
        s=set();

        for val in nums1:
            s.add(val);

        for val in nums2:
            s.add(val);

        return list(s);


// Optimal

































// *************************************************************************************************************************

//FIND MISSING NUMBER
class Solution:
    def missingNumber(self, nums):
        n=len(nums)
        totalSum=n*(n+1)//2;
        summ=0

        for val in nums:
            summ+=val

        
        return totalSum-summ


        // ?***************************************************************************************************************************
// 485 MAXIMUM CONSECUTIVE ONES->https://leetcode.com/problems/max-consecutive-ones/description/

class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        MaxCount=0
        count=0

        for val in nums:
            if val==1:
                count+=1
            else:
                 
                MaxCount=max(MaxCount,count)
                count=0

        return max(MaxCount,count)



// ****************************************************************************************************

//136: SINGLE NUMBER->https://leetcode.com/problems/single-number/

// Brute Force

class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        if len(nums)==1:
            return nums[0]

        s = set()
        summ=0
        totalSum=0

        for val in nums:
            summ+=val
            s.add(val)

        for val in s:
             totalSum+=val

        
        return (totalSum*2)-summ

//OPTIMIZE

class Solution:
    def singleNumber(self, nums: List[int]) -> int:


        res=0
        for val in nums:
            res^=val

        
        return res
     

//*************************************************************************************************** */

//LONGEST SUBARRAY WITH SUM K
//BRUTE FORCE
class Solution:
    def longestSubarray(self, nums, k):
         nums.sort()
         summ=0
         i=0

         while i<len(nums) and summ<k:
            summ+=nums[i]
            i+=1
            
         if summ!=k:
            return 0

         return i

//OPTIMAL
class Solution {
    public int longestSubarray(int[] nums, int k) {
        int sum = 0;
        int j = 0;
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            while (sum > k) {   // ✅ j slowly hatao
                sum -= nums[j];
                j++;
            }

            if (sum == k) {
                max = Math.max(max, i - j + 1);
            }
        }

        return max;
    }
}


//HANDLING NEGATIVE NUMBERS ALSO
class Solution:
    def longestSubarray(self, nums: list[int], k: int) -> int:
        hm = {}
        hm[0] = -1
        summ = 0
        lent = 0

        for i in range(len(nums)):
            summ += nums[i]
            rem = summ - k
            
            if rem in hm:
                lent = max(lent, i - hm[rem])

            if summ not in hm:
                hm[summ] = i

        return lent  







