// Leaders in the Array

class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        ArrayList<Integer> leaders = new ArrayList<>();
        int size = arr.length;
        int maxValue = arr[size - 1];
        leaders.add(maxValue);
        
        for(int i = size - 2; i >= 0; i--){
            if(maxValue <= arr[i]){
                maxValue = arr[i];
                leaders.add(maxValue);
                
            }
            
        }
        
        Collections.reverse(leaders);
        return leaders;
    }
}
