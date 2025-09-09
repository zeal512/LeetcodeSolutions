class Solution {
    public int waysToSplitArray(int[] nums) {
        int n= nums.length;
        long leftSum=0, sum=0;
        for(int num:nums) sum+=num;
        int validSplit = 0;
        for(int i=0; i<n-1;i++){
            leftSum+=nums[i];
            if (leftSum >= sum - leftSum) {
                validSplit++;
            }
        }
        return validSplit;
    }
}