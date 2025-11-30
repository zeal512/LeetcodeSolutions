class Solution {
    public boolean isMonotonic(int[] nums) {
        if(nums.length == 1) return true;
        boolean monotonicIncreasing = false, monotonicDecreasing = false;
        for(int i=0; i< nums.length -1; i++){
            if(nums[i] <= nums[i+1]) monotonicIncreasing = true;
            else{
                monotonicIncreasing=false;
                break;
            }
        }
        for(int i=0; i< nums.length -1; i++){
            if(nums[i] >= nums[i+1]) monotonicDecreasing = true;
            else{
                monotonicDecreasing = false;
                break;
            }
        }
        return monotonicIncreasing || monotonicDecreasing;
    }
}