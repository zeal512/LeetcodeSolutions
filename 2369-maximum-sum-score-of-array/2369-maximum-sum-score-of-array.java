class Solution {
    public long maximumSumScore(int[] nums) {
        long sum =0;
        for(int num:nums) sum+=num;
        long left = 0, right =0;
        long result = nums[0];
        for (int i = 0; i < nums.length; i++) {
            left += nums[i];
            right = sum - left + nums[i];
            result = Math.max(Math.max(left, right), result);
        }
        return result;
    }
}