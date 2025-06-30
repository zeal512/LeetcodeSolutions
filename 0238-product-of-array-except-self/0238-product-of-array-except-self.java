class Solution {
    public int[] productExceptSelf(int[] nums){
        int[] product = new int[nums.length];
        product[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            product[i] = product[i-1] * nums[i-1];
        }
        int suffix = 1;
        for(int k = nums.length-1; k >=0; k--){
            product[k] = product[k] * suffix;
            suffix = suffix * nums[k];
        }
        return product;
    }
}