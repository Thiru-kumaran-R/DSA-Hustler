// STRIVERS ARRAYS SERIES - 1

// VIDEO - 1
// Find the largest element in an array of integers.
// Brute
import java.util.*;

public class q1{
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5};
        Arrays.sort(arr);
        System.out.println(arr[arr.length-1]);
    }
}

// Optimal
import java.util.*;

public class q1 {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println(max);
    }
}

// Find the second largest element in an array of integers.
// Brute
import java.util.*;

public class q1 {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        Arrays.sort(arr);
        int size = arr.length;

        for(int i = size - 1; i >= 0; i--){
            if(arr[i] < arr[size - 1]){
                System.out.println(arr[i]);
                break;
            }
        }
    }
}

// Optimal
import java.util.*;

public class q1 {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            } else if (arr[i] > secondMax && arr[i] != max) {
                secondMax = arr[i];
            }
        }
        System.out.println(secondMax);
    }
}
