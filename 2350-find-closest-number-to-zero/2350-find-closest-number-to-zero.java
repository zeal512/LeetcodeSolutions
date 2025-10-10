class Solution {
    public int findClosestNumber(int[] nums) {
        int closest = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int a = Math.abs(num), b = Math.abs(closest);
            if (a < b || (a == b && num > closest)) {
                closest = num; 
            }
        }
        return closest;
    }
}