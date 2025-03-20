class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seenNum = new HashSet<>();
        while(n!=1){
            if(seenNum.contains(n)) return false;
            seenNum.add(n);
            n = helper(n);
        }
        return true;
    }

    public int helper(int n){
        int num = 0;
        int squareSum =0;
        while(n > 0){
            num = n%10;
            squareSum += num*num;
            n = n/10;
        }
        return squareSum;
    }
}