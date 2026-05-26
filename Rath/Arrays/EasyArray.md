<!--find the largest element  -->

In this question first I made a varaible name max and assign it the first value of array then I simply iterate the loop and chekced whether the max is less than that element if yes then change the value of max to that element, otherwise move on to next element


<!-- ********************************************************** -->

<!--find the Second largest element  -->

In this question I applied the logic of finding the max element by using the same function and in the main function I made three varaibles name first one find the max value in the array and second is secLargest el and I assigned this varaible the minimun value and the third one is falg which i assign as true so I start interating the loop and checking  if(secEl<nums[i] && nums[i]<maxel) means the the value is greater than the secEl and less that the Maxel so by this everytime it will change the value of secEl it its greateer than it's existing value and also i changed the falg value to false means that yes in this array there is second element is present because at last i cheked the condition if the falg is unchanges means it's value is still true then there is no seond largest element every element is same value.


<!-- ********************************************************** -->

<!--checking if the rotated array is sort or not  -->

In this question first I made a variable name cnt and assign it an integer value 0 because whats the logic I made behind this question is I will check the breaking order of Asceding elements means that if the ascending order is breaked 2 times in the array then it is not sorted because for the first time it will find the smaller element then again it found the smaller element which is not following the srting order and for the same element the value cnt will be 0 and the 3 condition at last I'm also ckecking that the last value of array will be smaller than the first element if not then increase the count and it will not increase the count in one condition where the array is alredy sorted 
and at last i m cheking if the count is less than or equal to 1 then return true;


<!-- ********************************************************** -->

<!--Remove duplicate from sorted array  -->

In this question I used the logic of 2 pointers means that the array is already sorted so what i did is basically I kept the 1 pointer on 0 index and 2 pointer on 1 index and increasing the index 2 everytime and cheking everytime that the value of nums[i]!=nums[j] means the previous valu eis not equal to the current value at that time I store this value to the next of previous value and moving the the 1 pointer to the 2 pointer means now the 1 pointer is pointing the new value which stored rn in the array.



!-- ********************************************************** -->

<!--ROTATE ARRAY by K places -->

Actually that's pritty good question what i did is basically first i divide the k by length of the array and keep the remianders means if the value of k is greater than the length so it's takes the value which is lessar than length so the repition of rotating the array we can avoid then I make the reverse array
1- At first i reverse the whole array
2- I reverse the array until kth value but inside the array it will be k-1
3- then i reversed the from k until the length of the array 
By doing this, array become rotated by k places 


!-- ********************************************************** -->

<!--MOVE ZERO AT THE END OF ARRAY -->
 
 This question literally feak me out such a silly question but i want to solve this question in my own style means without swaping the values just directly assigning the ith value to 0
 Okk So What i did in this question is again I used the 2 pointer concpet same as above then while iterating the loop first i cheked that if the first element is not equal to 0 then increase the value of j from 0 to 1 then I just cheked that if the value is not equal to 0 then simply swap the value of i and j and after swapping just increase the secong pointer becuase j pointing the non zero value and at that index only I am storing the non zero so after swithing the value with j inex I have to increase it so the next non zero value stored on the next index.


 !-- ********************************************************** -->

<!--UNION OF TWO SORTED ARRAY -->

In this question I made a set and added all the elements from both fo the array in that set and at the last storing all the sets element inside the list and return that list



 !-- ********************************************************** -->

<!-- FIND MISSING NUMBER-->

Hmm that a classic prity simple question in that question what basically i did is i just took the summ of all the elements in the array and by using the Mathematical formula of finding the sum of n natural numbers i Subrated the summ form this mathematical calucalted sum and at the last i got my missing number that's ittt


 !-- ********************************************************** -->

<!-- FIND MISSING NUMBER-->

That's also pritty simple question in that what I did is I took the varaible name count which was the temporary varaible store the consecutive 1's count and second varaible was like store the max consecutive ones for I iterate in the loop and checked the condition that if the value=1 then count++ otherwise plase assign the count as zero and store the maxCount 

and at the last i returned the value by max(MaxCount,count) because what about the last edge case the last element is 1 so in that case maxCount will not be updated so at the last we have to chekc which one is greater and return the greater one