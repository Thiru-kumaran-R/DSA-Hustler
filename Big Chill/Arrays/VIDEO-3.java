// VIDEO - 3
// Find the missing number in the array

// Brute Force
import java.util.*;

class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5};
        int n = 5;
        int size = arr.length;
        
        for(int i = 1; i <= n; i++){
            boolean flag = false;
            for(int j = 0; j < size; j++){
                if(arr[j] == i){
                    flag = true;
                    break;
                }
            }
            
            if(!flag) System.out.println(i);
        }
        
        
    }
}

// Better 
import java.util.*;

class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5};
        int n = 5;

        boolean[] marker = new boolean[n + 1];

        // mark present numbers
        for(int num : arr){
            if(num <= n){
                marker[num] = true;
            }
        }

        // print missing numbers
        for(int i = 1; i <= n; i++){
            if(!marker[i]){
                System.out.println(i);
            }
        }
    }
}

// Optimal
import java.util.*;

class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5};
        int n = 5;
        
        int totalSum = (n * (n + 1) ) / 2;
        int actualSum = 0;
        
        for(int num : arr){
            actualSum += num;
        }
        
        System.out.println(totalSum - actualSum);
    }
}

// Optimal XOR
import java.util.*;

class Main {
    public static void main(String[] args){
        int[] arr = {1, 2, 4, 5};
        int N = 5;
        int n = N - 1;

        int totalXor = 0;

        for(int i = 0; i <= n; i++){
            totalXor ^= i;
            totalXor ^= arr[i];
        }

        System.out.println(totalXor ^ N);
    }
}

// Using one for loop
import java.util.*;

class Main {
    public static void main(String[] args){
        int[] arr = {1, 2, 4, 5};
        int N = 5;
        int n = N - 1;

        int totalXor = 0;

        for(int i = 0; i < n; i++){
            totalXor ^= i + 1;
            totalXor ^= arr[i];
        }

        System.out.println(totalXor ^ N);
    }
}