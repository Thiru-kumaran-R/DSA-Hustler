// Maximum Subarray
// Given an integer array nums, find the subarray with the largest sum, and return its sum.

// Brute Force
class Solution {
    public int maxSubArray(int[] nums) {
        int size = nums.length;
        int maxVal = Integer.MIN_VALUE;

        for(int i = 0 ; i < size; i++){
            for(int j = i; j < size; j++){
                int val = 0;
                for(int k = i; k <= j; k++){
                    val += nums[k];
                    maxVal = Math.max(maxVal, val);
                }
            }
        }

        return maxVal;
    }
}



// Better Solution
class Solution {
    public int maxSubArray(int[] nums) {
        int size = nums.length;
        int maxVal = Integer.MIN_VALUE;

        for(int i = 0 ; i < size; i++){
            int val = 0;
            for(int j = i; j < size; j++){
                val += nums[j];
                maxVal = Math.max(maxVal, val);
            }
        }

        return maxVal;
    }
}

// Optimal Solution
class Solution {
    public int maxSubArray(int[] nums) {
        int totalSum = 0, maxSum = Integer.MIN_VALUE;
        int size = nums.length;
        for(int i = 0; i < size; i++){
            if(totalSum <= 0) totalSum = 0;
            totalSum += nums[i];
            maxSum = Math.max(maxSum, totalSum);
        }
        return maxSum;
    }
}