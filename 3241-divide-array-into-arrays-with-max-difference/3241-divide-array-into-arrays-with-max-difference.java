class Solution {
    public int[][] divideArray(int[] nums, int k) {
        nums = sortArray(nums, 0, nums.length-1);
        int maxArrays = nums.length/3;
        int[][] outputArr = new int[maxArrays][3];
        int counter = 0;
        for (int i = 0; i < maxArrays; i++) {
            if(Math.abs(nums[counter + 2] - nums[counter]) > k ) return new int[0][0];
            for (int j = 0; j < 3; j++) {
                outputArr[i][j] = nums[counter++];
            }
        }
        return outputArr;
    }
    public static int[] sortArray(int[] nums, int low, int high){
        if (low >=high) {
            return nums;
        }
        int mid = (low + high)/2;
        sortArray(nums, low, mid);
        sortArray(nums, mid+1, high);
        merge(nums, low, mid, high);
        return nums;
    }

    public static void merge(int[] nums, int low, int mid, int high){
        int temp[] = new int[high - low +1];
        int left = low, right = mid+1, counter = 0;
        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp[counter] = nums[left];
                counter++;
                left++;
            }
            else{
                temp[counter] = nums[right];
                counter++;
                right++;
            }
        }
        while (left <= mid) {
            temp[counter] = nums[left];
            counter++;
            left++;
        }
        while (right <= high) {
            temp[counter] = nums[right];
            counter++;
            right++;
        }
        for(int i=0; i< temp.length; i++){
            nums[low+i] = temp[i];
        }
    }
}