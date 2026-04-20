class Solution {
    /* Recursive solution
    TC - O( pow(2,(m+n) ) )
    SC - O(m+n)

    public int uniquePaths(int m, int n) {
        if(m ==1 || n == 1) return 1;
        return uniquePaths(m-1, n) + uniquePaths(m, n-1);
    } */
    
    /*
    DP Solution 
    TC - O(m*n)
    SC - O(m*n)   
    */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] arr : dp){
            Arrays.fill(arr, 1);
        }
        for(int r = 1; r < m; r++){
            for(int c = 1; c < n; c++){
                dp[r][c] = dp[r-1][c] + dp[r][c-1];
            }
        }
        return dp[m-1][n-1];
    }
}