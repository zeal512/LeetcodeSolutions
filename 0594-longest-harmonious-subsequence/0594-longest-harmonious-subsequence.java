class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int left =0,maxSize =0;
        for(int right = 0; right < nums.length; right++){
            while (nums[right] - nums[left] >1 ) {
                left++;
            }
            if (nums[right] - nums[left] == 1 ) {
                maxSize = Math.max(maxSize, right-left+1);
            }
        }
        return maxSize;
    }
}