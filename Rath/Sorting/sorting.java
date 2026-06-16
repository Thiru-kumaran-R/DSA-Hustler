//SELECTION SORT:

class Solution {

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static int min(int[] arr, int k) {
        int min = arr[k];
        int minIndex = k;
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public int[] selectionSort(int[] nums) {
        for (int i = 0; i <= nums.length - 2; i++) {
            int minIndex = min(nums, i);
            swap(nums, i, minIndex);
        }
        return nums;
    }
}




//************************************BUBBLE SORT*********************************************************
//TIME COMPLEXITY FOR WORST = O(N^2) AND THE BEST COMPLEXITY = O(N)
class Solution {
  
public static void swap(int []arr,int k,int l){
    int t=arr[k];
    arr[k]=arr[l];
    arr[l]=t;
}

   public static boolean it(int []arr,int k,boolean swapped){
        
    for(int i=1;i<arr.length-k;i++){
          if(arr[i-1]>arr[i]){
            swap(arr,i-1,i);
            swapped=true;
          }
    }

    return swapped;
   }

    public int[] bubbleSort(int[] nums) {
       
       for(int i=0;i<nums.length;i++){
        boolean swapped =false;
       boolean re= it(nums,i,swapped);

         if(!re){
            return nums;
        }
       }
        
       

       return nums;
    }
}

//*************************************************INSERTION SORT************************************** */
//TIME COMPLEXITY FOR WORST = O(N^2) AND THE BEST COMPLEXITY = O(N)

class Solution {

     public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public int[] insertionSort(int[] nums) {


 for(int i=1;i<nums.length;i++){
    j=i;
    while(j>0 && nums[j-1]>nums[j]){
        swap(nums,j-1,j);
        j--;
    }

 }

 return nums;
    }
}

// MERGE SORT
 
class Solution:
    def mergeSort(self, arr: List[int]) -> None:
         if len(arr) <= 1:
            return

         mid = len(arr) // 2
        
         left_half = arr[:mid]
        right_half = arr[mid:]

         self.mergeSort(left_half)
        self.mergeSort(right_half)

         i = j = k = 0

         while i < len(left_half) and j < len(right_half):
            if left_half[i] < right_half[j]:
                arr[k] = left_half[i]
                i += 1
            else:
                arr[k] = right_half[j]
                j += 1
            k += 1

         while i < len(left_half):
            arr[k] = left_half[i]
            i += 1
            k += 1

         while j < len(right_half):
            arr[k] = right_half[j]
            j += 1
            k += 1