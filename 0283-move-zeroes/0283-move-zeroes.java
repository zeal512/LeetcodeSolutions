class Solution {
    public void moveZeroes(int[] nums) {
        int swapPointer =0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[swapPointer];
                nums[swapPointer] = nums[i];
                nums[i] = temp;
                swapPointer++;
            }
        }
    }
}