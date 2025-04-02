class Solution {
    public int climbStairs(int n) {
        /* if(n == 0) return 1;
        if(n == 1) return 1;
        int jump1 = climbStairs(n-1);
        int jump2 = climbStairs(n-2);
        return jump1 + jump2; */
        int jump1 =0, jump2 = 1;
        for(int i=0; i< n; i++){
            int sum = jump1 + jump2;
            jump1 = jump2;
            jump2 = sum;
        }
        return jump2;
    }
}