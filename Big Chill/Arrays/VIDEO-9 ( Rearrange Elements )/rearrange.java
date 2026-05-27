// Rearrange Array Elements by Sign

// You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.

// You should return the array of nums such that the array follows the given conditions:

// Every consecutive pair of integers have opposite signs.
// For all integers with the same sign, the order in which they were present in nums is preserved.
// The rearranged array begins with a positive integer.
// Return the modified array after rearranging the elements to satisfy the aforementioned conditions.

// Brute force
class Solution {
    public int[] rearrangeArray(int[] nums) {
        int size = nums.length;
        int[] pos = new int[size/2];
        int[] neg = new int[size/2];

        int negPointer = 0, posPointer = 0;
        for(int i = 0; i < size; i++){
            if(nums[i] < 0){
                neg[negPointer++] = nums[i];
            }else{
                pos[posPointer++] = nums[i];
            }
        }

        posPointer = 0;
        negPointer = 0;
        int[] ans = new int[size];
        for(int i = 0; i < size; i++){
            if(i % 2 == 0){
                ans[i] = pos[posPointer++];
            }else{
                ans[i] = neg[negPointer++];
            }
        }

        return ans;
    }
}

// Optimal
