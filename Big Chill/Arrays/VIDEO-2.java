
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

import java.util.*;

class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5,9};
        int[] arr2 = {7, 3, 8 };
        
        Arrays.sort(arr);
        Arrays.sort(arr2);
        List<Integer> union = new ArrayList<>();
        int size1 = arr.length;
        int size2 = arr2.length;
        int right = 0, left = 0;
        
        while(right < size1 && left < size2){
            if(arr[right] <= arr2[left]){
                if(union.size() > 0 && arr[right] == union.get(union.size() - 1)){
                    continue;
                }else{
                    union.add(arr[right]);
                }
                right += 1;
            }else{
                if(union.size() > 0 && arr2[left] == union.get(union.size() - 1)){
                    continue;
                }else{
                    union.add(arr2[left]);
                }
                left += 1;
            }
        }
        
        while(right < size1){
            union.add(arr[right]);
            right += 1;
        }
        
        while(left < size2){
            union.add(arr2[left]);
            left += 1;
        }
        
        System.out.println(union);
    }
}

// Intersection of two sorted arrays
// Brute Force

class q1 {
    public static void main(int[] arr, int[] arr2) {
        List<Integer> union = new ArrayList<>();
        Arrays.sort(arr);
        Arrays.sort(arr2);
        int size1 = arr.length;
        int size2 = arr2.length;
        int[] visited = new int[size2];
        int right = 0, left = 0;
        
        for(int i = 0; i < size1; i++){
            for(int j = 0; j < size2; j++){
                if(arr[i] == arr2[j] && visited[j] == 0 && 
                    (union.size() == 0 ||
                    union.get(union.size() - 1) != arr[i])
                ){
                    union.add(arr[i]);
                    visited[j] = 1;
                    break;
                }
                
                if(arr[i] < arr2[j]) break;
            }
        }
        
        return union.stream().mapToInt(Integer::intValue).toArray();
    }
}

// Optimal
// Online Java Compiler
// Use this editor to write, compile and run your Java code online

import java.util.*;

class q1 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5,9};
        int[] arr2 = {7, 3, 2, 5, 6, 8 };
        
        Arrays.sort(arr);
        Arrays.sort(arr2);
        
        List<Integer> intersection = new ArrayList<>();
        
        int left = 0, right = 0;
        int size1 = arr.length, size2 = arr2.length;
        
        while(left < size1 && right < size2){
            if(arr[left] == arr2[right]){
                intersection.add(arr[left]);
                left += 1;
                right += 1;
            }else if(arr[left] > arr2[right]){
                right += 1;
            }else{
                left += 1;
            }
        }
        
        System.out.println(intersection);
    }
}