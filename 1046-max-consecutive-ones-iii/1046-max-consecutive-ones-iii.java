class Solution {
    public int longestOnes(int[] nums, int k) {
        int start =0, numberOfZeros =0, maxNum =0;
        for(int end=0; end< nums.length; end++){
            if(nums[end] == 0) numberOfZeros++;

            while(numberOfZeros > k){
                if(nums[start] == 0){
                    numberOfZeros--;
                }
                start++;
            }
            maxNum = Math.max(maxNum, end-start+1);
        }
        return maxNum;
    }
}