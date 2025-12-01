class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> uniqueSet = new HashSet<>();
        int left = 0, right = 0;
        int sum = 0, maxSum = 0;
        while (right < nums.length) {
            while (uniqueSet.contains(nums[right])) {
                uniqueSet.remove(nums[left]);
                sum -= nums[left];
                left+=1;
            }
            uniqueSet.add(nums[right]);
            sum += nums[right];
            maxSum = Math.max(sum, maxSum);
            right+=1;
        }
        return Math.max(sum, maxSum);
    }
}