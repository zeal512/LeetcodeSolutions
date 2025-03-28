class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0, maxSum = Integer.MIN_VALUE;
        for(int i=0; i< nums.length; i++){
            sum +=nums[i];
            if(sum > maxSum){
                maxSum = sum;
            }
            
            if(sum < 0){
                sum =0;
            }
            
            //maxSum = Math.max(sum, maxSum); 

            /* int sum = 0;
            for(int j=i; j<nums.length; j++){
                sum+=nums[j];
                maxSum = Math.max(sum, maxSum); */
                /* int sum = 0;
                for(int k=i; k<=j;k++){
                    sum+=nums[k];
                    maxSum = Math.max(sum, maxSum);
                } */
            //}
        }
        if(maxSum < 0) return maxSum;
        return maxSum;
    }
}