class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int start =0, maxSize = 0, zeroCount =0;
        for(int end =0; end < nums.length; end++){
            if (nums[end] == 0) zeroCount++;
            while (zeroCount > 1) {
                if(nums[start] == 0) zeroCount--;
                start++;
            }
            maxSize = Math.max(maxSize, end - start + 1);
        }
        return maxSize;
    }
}