class Solution {
    /* public int fib(int n) {
        if(n <=1) return n;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return calculateFib(n, dp);
    }

    public int calculateFib(int n, int[] dp){
        if(n <=1) return n;
        if(dp[n] != -1) return dp[n];
        return dp[n] = calculateFib(n-1, dp) + calculateFib(n-2, dp);
    } */

    //Memoization 
    public int fib(int n){
        int num1 = 0, num2 = 1;
        for(int i=0; i<n; i++){
            int sum = num1 + num2;
            num1 = num2;
            num2 = sum;
        }
        return num1;
    }

}