class Solution {
    public int minStartValue(int[] nums) {
        int runningSum =0, minVal =0;
        for(int i=0; i<nums.length; i++){
            runningSum += nums[i];
            minVal = Math.min(minVal, runningSum);
            nums[i] = runningSum;
        }
        minVal = Math.abs(minVal) + 1;
        return minVal;
    }
}