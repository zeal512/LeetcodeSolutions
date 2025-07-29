class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxNum = Integer.MIN_VALUE, sum = 0;
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
            if (num != 0 && !set.contains(Math.abs(num))){
                set.add(num);
                if (sum + num > sum) {
                    sum+=num;
                }
            }

        }
        if (maxNum < 0) {
            return maxNum;
        }
        return sum;
    }
}