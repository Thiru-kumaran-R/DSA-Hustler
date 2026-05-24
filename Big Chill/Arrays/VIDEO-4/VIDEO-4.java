
// Longest Subarray with sum K | Brute - Better - Optimal | Generate Subarrays
***********************************************************************************************************************************************
// Brute Force
import java.util.*;

class Main {
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 1, 1, 1, 1, 4, 2, 3};
        int k = 3;
       int size = arr.length;
       int maxLen = -1;
       for(int i = 0; i < size; i++){
           int sum = 0;
           for(int j = i; j < size; j++){
               sum += arr[j];
               if(sum == k) maxLen = Math.max(maxLen, j - i + 1);
           }
       }
    
        System.out.println(maxLen);
        
    }
}

***********************************************************************************************************************************************
// Better



***********************************************************************************************************************************************
// Optimal 
import java.util.*;

class Main {
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 1, 1, 1, 1, 4, 2, 3};
        int k = 3;
       int size = arr.length;
       int maxLen = -1;
       int right = 0, left = 0;
       int sum = 0;
       while(right < size){
           sum += arr[right];
           
           while(sum > k && left <= right){
               sum -= arr[left];
               left += 1;
           }
           if(sum == k)maxLen = Math.max(maxLen,right-left + 1);
           right += 1;
       }
    
        System.out.println(maxLen);
        
    }
}

