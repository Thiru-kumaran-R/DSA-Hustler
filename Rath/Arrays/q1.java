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