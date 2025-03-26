class Solution {
    public int removeElement(int[] nums, int val) {
        int left = 0, right = nums.length-1;
        while(left<=right){
            if(nums[right] == val){
                nums[right] = -1;
                right--;
            }

            else if(nums[left] == val){
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                nums[right] = -1;
                left++;
                right--;
            }
            else{
                left++;
            }
        }
        return left;
    }
}