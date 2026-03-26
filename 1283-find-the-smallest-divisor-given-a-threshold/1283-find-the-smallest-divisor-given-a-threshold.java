class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int maxThreshold = 0, minThreshold = 1;
        for(int num : nums){
            maxThreshold = Math.max(maxThreshold, num);
        }
        int ans = maxThreshold;
        while (minThreshold <= maxThreshold) {
            int div = minThreshold + ((maxThreshold - minThreshold)/2);
            if(isDivisorPossible(nums, div, threshold)){
                ans = Math.min(ans, div);
                maxThreshold = div -1;
            }
            else minThreshold = div + 1;
        }
        return ans;
    }
    public boolean isDivisorPossible(int[] nums, int div, int threshold){
        int sum = 0;
        for(int num : nums){
            sum += (int)Math.ceil((double)num/div);
        }
        if(sum <= threshold) return true;
        return false;
    }
}