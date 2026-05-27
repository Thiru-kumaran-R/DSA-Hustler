# Majority Element
-------------------------------------------------------------------------------------------------------------------------
## Brute Force
1) Take a value from array, from left to right and then check the occurance of that value in that array
2) Store that value in a variable
3) once the iteration is completed then compare whether that value is greater than the size of the array divided by 2.
4) if yes then return that value and break the loop, else go with the next element in the array

* Time Complexity : O(n^2)
* Space Complexity : O(1)

-------------------------------------------------------------------------------------------------------------------------
## Better 
1) Create a HashMap in order to store value as key and count as value.
2) Loop through the array and then load values in the map.
3) Once all the values are loaded in the map, loop through the map again and check whether the value is greater than the
    size of the array by 2.
4) if yes return the value else return -1.

* Time Complexity : O(2n), where n is the total number elements in the array.
* Space Complexity : O(m), where m is the number of unique elements in the array


-------------------------------------------------------------------------------------------------------------------------

## Optimal 

### Moore's Voting Algorithm

1) Assign the first element as the leader and create a counter, then loop through the array.
2) if consequtive values are not equal to the first element, decrease the counter value by one, else increase by one.
3) if the counter value is zero then assign the current element as the leader and reset the counter to zero.
4) After the iteration, we will get a majority element, if it contains one. return that element.

* Time Complexity : O(n)
* Space Complexity : O(1)
