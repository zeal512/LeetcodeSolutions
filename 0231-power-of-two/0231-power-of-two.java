class Solution {
    public boolean isPowerOfTwo(int n) {
        return n>0 && (n & (n-1)) == 0;
        /* if(n <= 0) return false;
        if(n == 1) return true;
        return n%2 == 0 && isPowerOfTwo(n/2); */
    }
}