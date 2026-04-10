class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int possibility1 = maxAmount(nums, 0, n-2);
        int possibility2 = maxAmount(nums, 1, n-1);
        return Math.max(possibility1, possibility2);
        
    }

    public int maxAmount(int[] nums, int start, int end){
        int prev = nums[start], prev2 =0;
        for(int i = start+1; i <= end; i++){
            int canRob = nums[i] + (i > 1 ? prev2 : 0);
            int cannotRob = prev;
            int maxMoney = Math.max(canRob, cannotRob);
            prev2 = prev;
            prev = maxMoney;
        }
        return prev;
    }
}