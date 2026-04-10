class Solution {
    public int findDuplicate(int[] nums) {   
        while(nums[0] != nums[nums[0]]){
            int temp = nums[nums[0]];
            nums[nums[0]] = nums[0];
            nums[0] = temp;
        }
        return nums[0];
    }
}

/* 
3,1,3,4,2

3 + 1 + 3 + 4 + 2 = 13

1 + 2 + 3 + 4 = 10 (n(n+1))/2;

*/