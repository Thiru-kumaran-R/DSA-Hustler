// brute force
public class Solution {
    public int subarraySumBrute(int[] nums, int k) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                // Calculate sum of subarray nums[i...j]
                for (int K = i; K <= j; K++) {
                    sum += nums[K];
                }
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}