class Solution {
    public int minimumDifference(int[] nums, int k) {
        int minDiff = Integer.MAX_VALUE, i = 0;
        Arrays.sort(nums);
        while(i + k - 1 < nums.length){
            minDiff = Math.min(minDiff, nums[i + k - 1] - nums[i]);
            i+=1;
        }
        return minDiff == Integer.MAX_VALUE ? 0: minDiff;
    }
}

/* 
[1,4,7,9]
   i

*/