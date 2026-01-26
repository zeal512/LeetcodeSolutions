class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        return nums;
    }
    public void mergeSort(int[] nums, int start, int end){
        if(start >= end) return;
        int mid = (start + end)/2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid +1, end);
        performMergeSort(nums, start, mid, end);
    }
    public void performMergeSort(int[] nums, int start, int mid, int end){
        int left = start, right = mid+1;
        int[] temp = new int[end - start + 1];
        int ptr = 0;
        while (left <= mid && right <= end) {
            if(nums[left] <= nums[right]){
                temp[ptr++] = nums[left++];
            }
            else{
                temp[ptr++] = nums[right++];
            }
        }
        while(left <= mid) {
            temp[ptr++] = nums[left++];
        }
        while(right <= end) {
            temp[ptr++] = nums[right++];
        }
        for(int i = start; i<= end; i++){
            nums[i] = temp[i - start];
        }
    }
}