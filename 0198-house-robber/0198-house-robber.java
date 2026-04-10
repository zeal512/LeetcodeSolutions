class Solution {
    //Memoization method
    /* public int rob(int[] nums) {
        int n = nums.length-1;
        int[] maxPossibility = new int[n+1];
        Arrays.fill(maxPossibility, -1);
        return maximize(n, nums, maxPossibility);
    }
    public int maximize(int n, int[] nums, int[] maxPossibility){
        if(n ==0) return nums[0];
        if(n < 0) return 0;
        if(maxPossibility[n] != -1) return maxPossibility[n];
        
        int willRob = nums[n] + maximize(n-2, nums, maxPossibility);
        int willNotRob = maximize(n-1, nums, maxPossibility);
        
        return maxPossibility[n] = Math.max(willRob, willNotRob);
    } */

    //tabulation method
    public int rob(int[] nums){
        int n = nums.length;
        int[] maximized = new int[n];
        maximized[0] = nums[0];
        for(int i =1; i < nums.length; i++){
            int canRob = nums[i] + (i > 1? maximized[i-2] : 0);
            int cannotRob = maximized[i-1];
            maximized[i] = Math.max(canRob, cannotRob);
        }
        return maximized[n-1];
    }
}