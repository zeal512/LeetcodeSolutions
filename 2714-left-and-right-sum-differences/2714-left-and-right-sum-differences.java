class Solution {
    public int[] leftRightDifference(int[] nums) {
        int total =0;
        for(int num: nums) total+=num;
        int n = nums.length, left=0;
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];
        for (int i = 0; i < n; i++) {
            leftSum[i] = left;
            left+=nums[i];
            rightSum[i] = total-left;
        }
        int[] result = new int[n];
        for(int i=0; i<n; i++){
            result[i] = Math.abs(leftSum[i] - rightSum[i]);
        }
        return result;
    }
}