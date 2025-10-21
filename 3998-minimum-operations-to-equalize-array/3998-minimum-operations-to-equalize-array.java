class Solution {
    public int minOperations(int[] nums) {
        boolean allElementsAreEqual = true;
        int begin = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != begin){ 
                allElementsAreEqual = false;
                break;
            }
        }
        if(allElementsAreEqual){
            return 0;
        }
        return 1;
    }
}