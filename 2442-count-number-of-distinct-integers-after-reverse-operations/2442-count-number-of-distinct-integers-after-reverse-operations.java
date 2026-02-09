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
            int reminder = num % 10;
            num = num / 10;
            reverse = (reverse * 10) + reminder;
        }
        return reverse;
    }
}
//134
//43