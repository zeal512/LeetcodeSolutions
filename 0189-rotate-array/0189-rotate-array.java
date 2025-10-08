class Solution {
    public void rotate(int[] nums, int k) {
        if(k == 0 || nums.length == 1 || k == nums.length) return;
        
        int sizeOfArray = nums.length;
        int left = 0, right = sizeOfArray-1;
        swap(nums, left, right);

        left = 0;
        right = (k%sizeOfArray) -1;
        swap(nums, left, right);

        left = (k%sizeOfArray);
        right = sizeOfArray -1;
        swap(nums, left, right);
    }

    public static void swap(int[] nums, int left, int right){
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }        
    }
}