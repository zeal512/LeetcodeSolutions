class Solution {
    public int splitArray(int[] nums, int k) {
        
        if(k > nums.length) return -1;
        int minSubArraySum = 0, maxSubArraySum = 0;
        for(int i =0; i< nums.length; i++){
            minSubArraySum = Math.max(minSubArraySum, nums[i]);
            maxSubArraySum += nums[i];
        }
        while(minSubArraySum <= maxSubArraySum){
            int avgSum = minSubArraySum + ((maxSubArraySum - minSubArraySum)/2);
            int totalSubArrays = totalSubarrayPossible(avgSum, nums);
            if(totalSubArrays > k){
                minSubArraySum = avgSum + 1;
            }
            else{
                maxSubArraySum = avgSum -1;
            }
        }
        return minSubArraySum;
    }
    public int totalSubarrayPossible(int avgSum, int[] nums){
        int subArrayCount = 1, subArraySum = 0;
        for(int i =0; i< nums.length; i++){
            if(subArraySum + nums[i] > avgSum){
                subArrayCount +=1;
                subArraySum = nums[i];
            }
            else{
                subArraySum += nums[i];
            }
        }
        return subArrayCount;
    }
}

/* 
This question is same as 
Allocate Books  OR Allocate Minimum Pages - https://www.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1

*/