class Solution {
    public int differenceOfSums(int n, int m) {

        int num2 = m * ((n/m) * ((n/m) +1 ) )/2;
        int ans = (n* (n+1)/2) - 2 * num2;
        return ans;
        /* int divisibleSum =0, nonDivisibleSum =0;
        for (int i = 1; i <= n; i++) {
            if(i % m != 0) nonDivisibleSum+=i;
            else divisibleSum+=i;
        }
        return nonDivisibleSum - divisibleSum; */
    }
}