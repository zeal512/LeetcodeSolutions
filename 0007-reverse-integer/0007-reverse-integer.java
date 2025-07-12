class Solution {
    public int reverse(int x) {
        if(x <= Integer.MIN_VALUE || x >= Integer.MAX_VALUE) return 0;
        int sum =0;
        
        while(x != 0){
            int remainder = x%10;
            x/=10;
            if(sum > Integer.MAX_VALUE/10 || (sum == Integer.MAX_VALUE/10 && remainder >7)) return 0;
            if(sum < Integer.MIN_VALUE/10 || (sum == Integer.MIN_VALUE/10 && remainder <-8)) return 0;
            sum = (sum*10) + remainder;
            
        }
        return sum;
    }
}