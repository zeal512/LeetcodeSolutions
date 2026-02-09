class Solution {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
            set.add(reverseInt(num));
        }
        return set.size();
    }
    public int reverseInt(int num){
        int reverse = 0;
        while(num > 0){
            reverse = (reverse * 10) + num % 10;
            num/=10;
        }
        return reverse;
    }
}