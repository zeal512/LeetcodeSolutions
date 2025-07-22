class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Set<Integer> uniqueSet = new HashSet<>();
        int left = 0, right = 0;
        int sum = 0, maxSum = 0;
        while (right < nums.length) {

            while (uniqueSet.contains(nums[right])) {
                uniqueSet.remove(nums[left]);
                sum = sum - nums[left];
                left++;
            }
            uniqueSet.add(nums[right]);
            sum += nums[right];
            maxSum = Math.max(sum, maxSum);

            right++;
        }
        return Math.max(sum, maxSum);
    }
}