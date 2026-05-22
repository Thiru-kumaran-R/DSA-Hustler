
// VIDEO - 2
// Left rotate array by one place
import java.util.*;

class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int size = arr.length;
        int temp = arr[0];
        
        for(int i = 0 ; i < size - 1; i++){
            arr[i] = arr[i + 1];
        }
        
        arr[size - 1] = temp;
        
        System.out.println(Arrays.toString(arr));
    }
}

// Left rotate by d places
// Brute Force

import java.util.*;

class Main {
    public static void main(String[] args) {
        int d = 12;
        int[] arr = {1, 2, 3, 4, 5, 6};
        int size = arr.length;
        int k = d % size;
        
        int[] temp = new int[k] ;
        
        for(int i = 0 ; i < k; i++){
            temp[i] = arr[i]; // storing in temp arr
        }
        
        for(int i = k; i < size; i++){
            arr[i - k] = arr[i];
        }
        
        for(int i = size - k; i < size; i++){
            arr[i] = temp[i - (size - k) ];
        }
        
        System.out.println(Arrays.toString(arr));
    }
}

// Optimal 

import java.util.*;

class Main {
    public static void main(String[] args) {
        int d = 4;
        int[] arr = {1, 2, 3, 4, 5, 6};
        int size = arr.length;
        int k = d % size;
        
        reverseArr(arr, 0, k - 1);
        reverseArr(arr, k, size - 1);
        reverseArr(arr, 0, size - 1);
        
        
        
        System.out.println(Arrays.toString(arr));
    }
    
    public static void reverseArr(int[] arr, int left, int right){
        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left += 1;
            right -= 1;
        }
    }
}


// Move all zeroes to the end
// Brute Force
import java.util.*;

class Main {
    public static void main(String[] args) {
        int d = 4;
        int[] arr = {1, 2, 0, 3, 0, 0, 4, 5, 6};
        int size = arr.length;
        
        int[] res = new int[size];
        int pointer = 0;
        for(int i = 0; i < size; i++){
            if(arr[i] != 0){
                res[pointer++] = arr[i];
            }
        }
        
        
        
        System.out.println(Arrays.toString(res));
    }
}

// Optimal

import java.util.*;

class Main {
    public static void main(String[] args) {
        int d = 4;
        int[] arr = {1, 2, 0, 3, 0, 0, 4, 5, 6};
        int size = arr.length;
        
        int pointer = -1;
        for(int j = 0; j < size; j++){
            if(arr[j] == 0){
                pointer = j;
                break;
            }
        }
        
        if(pointer == -1) return;
        
        for(int i = pointer + 1; i < size; i++){
            if(arr[pointer] == 0 && arr[i] != 0){
                int temp = arr[pointer];
                arr[pointer] = arr[i];
                arr[i] = temp;
                pointer += 1;
            }
        }
        
        System.out.println(Arrays.toString(arr));
    }
}


// Linear Search
// Brute Force
class Main{
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5, 6};
        int size = arr.length;
        int target = 5;

        for(int i = 0; i < size; i++){
            if(arr[i] == target){
                System.out.println(i);
                break;
            }
        }
    }
}

// Union of two sorted arrays
// Brute Force
import java.util.*;

class Main {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 3, 4};
        int[] arr2 = {2, 3, 5};
        
        Set<Integer> set = new LinkedHashSet<>();
        
        // Add all elements of arr1
        for(int num : arr1){
            set.add(num);
        }
        
        // Add all elements of arr2
        for(int num : arr2){
            set.add(num);
        }
        
        // Convert set to list (optional)
        List<Integer> result = new ArrayList<>(set);
        
        System.out.println(result);
    }
}

// Optimal
