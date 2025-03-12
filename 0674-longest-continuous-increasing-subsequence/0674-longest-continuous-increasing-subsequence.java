class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int count =1, result =0;
        for(int i=1; i<nums.length; i++){
            if(nums[i] > nums[i-1]){
                count++;
            }
            else{
                result = Math.max(result, count);
                count =1;
            }
        }
        return Math.max(result, count);
    }
}