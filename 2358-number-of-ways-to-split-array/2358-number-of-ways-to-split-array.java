class Solution {
    public int waysToSplitArray(int[] nums) {
        int n= nums.length;
        long leftSum=0, rightSum =0, sum=0;
        for(int num:nums) sum+=num;
        int validSplit = 0;
        for(int i=0; i<n;i++){
            leftSum+=nums[i];
            rightSum = sum - leftSum;
            if (leftSum >= rightSum && i < n-1) {
                validSplit++;
            }
        }
        return validSplit;
    }
}