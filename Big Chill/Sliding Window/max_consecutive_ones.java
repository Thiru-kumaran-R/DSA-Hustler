class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int size = nums.length;
        int maxLen = 0;
        int zeroes = 0;

        while(right < size){

            if(nums[right] == 0){
                zeroes += 1;
            }

            while(zeroes > k){
                if(nums[left] == 0){
                    zeroes -= 1;
                }
                left += 1;
            }

            maxLen = Math.max(maxLen, right - left + 1);

            right += 1;
        }

        return maxLen;
    }
}