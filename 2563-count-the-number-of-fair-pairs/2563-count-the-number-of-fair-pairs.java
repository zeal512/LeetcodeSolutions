class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return binary(nums, upper) - binary(nums, lower -1);
    }
    public static long binary(int[] nums, int maxSum){
        int left = 0, right = nums.length-1;
        long count = 0;
        while(left < right){
            if(nums[left] + nums[right] <= maxSum){
                count +=  (right - left);
                left++;
            }else{
                right--;
            }
        }
        return count;
    }
}