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


//CHECK IF THE ROTATED ARRAY IS SORTED OR NOT

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