class Solution {
    public int findMin(int[] nums) {
        int low = 0, min = Integer.MAX_VALUE, high = nums.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[low] <= nums[mid]){
                min = Math.min(nums[low], min);
                low = mid+1;
            }
            else{
                min = Math.min(min, nums[mid]);
                high = mid-1;
            }
        }
        return min;
    }
}