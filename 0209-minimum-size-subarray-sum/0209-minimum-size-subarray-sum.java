class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        int sum =0, maxArrLength = Integer.MAX_VALUE;
        while(left <= right && right < nums.length ){
            sum+=nums[right];
            if(sum >= target){
                maxArrLength = Math.min(right - left + 1, maxArrLength);
                sum -= nums[left++];
                sum -= nums[right];
            }else{
                right++;
            }
        }
        return maxArrLength == Integer.MAX_VALUE ? 0: maxArrLength;
    }
}