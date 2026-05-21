<!--find the largest element  -->

In this question first I made a varaible name max and assign it the first value of array then I simply iterate the loop and chekced whether the max is less than that element if yes then change the value of max to that element, otherwise move on to next element


<!-- ********************************************************** -->

<!--find the Second largest element  -->

In this question I applied the logic of finding the max element by using the same function and in the main function I made three varaibles name first one find the max value in the array and second is secLargest el and I assigned this varaible the minimun value and the third one is falg which i assign as true so I start interating the loop and checking  if(secEl<nums[i] && nums[i]<maxel) means the the value is greater than the secEl and less that the Maxel so by this everytime it will change the value of secEl it its greateer than it's existing value and also i changed the falg value to false means that yes in this array there is second element is present because at last i cheked the condition if the falg is unchanges means it's value is still true then there is no seond largest element every element is same value.


<!-- ********************************************************** -->

<!--checking if the rotated array is sort or not  -->

In this question first I made a variable name cnt and assign it an integer value 0 because whats the logic I made behind this question is I will check the breaking order of Asceding elements means that if the ascending order is breaked 2 times in the array then it is not sorted because for the first time it will find the smaller element then again it found the smaller element which is not following the srting order and for the same element the value cnt will be 0 and the 3 condition at last I'm also ckecking that the last value of array will be smaller than the first element if not then increase the count and it will not increase the count in one condition where the array is alredy sorted 
and at last i m cheking if the count is less than or equal to 1 then return true;

