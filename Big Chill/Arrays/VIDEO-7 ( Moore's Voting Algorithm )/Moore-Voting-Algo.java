// Moore's Voting Algorithm

// Given an array nums of size n, return the majority element.
// The majority element is the element that appears more than ⌊n / 2⌋ times. 
// You may assume that the majority element always exists in the array.

// Brute Force
class Solution {
    public int majorityElement(int[] nums) {
        int size = nums.length;

        for(int i = 0; i < size; i++){
            int cnt = 0;
            for(int j = 0; j < size; j++){
                if(nums[i] == nums[j]){
                    cnt += 1;
                }
            }

            if(cnt > size / 2){
                return nums[i];
            }
        }

        return -1;
    }
}

// Better Solution
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int size = nums.length;

        for(int i = 0; i < size; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet() ){
            int value = entry.getValue();
            if(value > size / 2){
                return entry.getKey();
            }
        }

        return -1;
    }
}

// Optimal Solution
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int size = nums.length;
        int element = -1, cnt = 0;

        for(int i = 0; i < size; i++){
            if(cnt == 0) element = nums[i];
            
            if(element == nums[i]) cnt += 1;
            else cnt -= 1;
        }

        return element;
    }
}