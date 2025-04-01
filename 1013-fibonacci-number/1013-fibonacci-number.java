class Solution {
    public int fib(int n) {
        if(n <=1) return n;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return calculateFib(n, dp);
    }

    public int calculateFib(int n, int[] dp){
        if(n <=1) return n;
        if(dp[n] != -1) return dp[n];
        return dp[n] = calculateFib(n-1, dp) + calculateFib(n-2, dp);
    }


}