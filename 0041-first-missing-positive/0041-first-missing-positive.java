class Solution {
    public int firstMissingPositive(int[] nums) {
        /* int n = nums.length;        
        boolean[] track = new boolean[n+1];
        Arrays.fill(track, false);
        for(int i = 0; i < n; i++){
            if(nums[i] >= 0 && nums[i] <= n){
                track[nums[i]] = true;
            }
        }
        for(int i =1; i <= n; i++){
            if(!track[i]) return i;
        }
        return n+1; */

        int n = nums.length;
        boolean is1Present = false;
        /* check if 1 is present in array and convert all the negative nums, zero and num greater than n to 1 */
        for(int i = 0; i < n; i++){
            if(nums[i] == 1) is1Present = true;
            if(nums[i] <=0 || nums[i] > n){
                nums[i] = 1;
            }
        }
        if (!is1Present) return 1;
        for(int i =0; i< n; i++){
            int val = Math.abs(nums[i]);
            if(val == n){
                nums[0] = -Math.abs(nums[0]);
            }
            else nums[val] = - Math.abs(nums[val]);
        }
        for(int i = 1; i< n; i++){
            if(nums[i] > 0) return i;
        }
        return nums[0] > 0? n : n+1;
        

    }
}


/* 
[3,5,1]
sum = -9
- 9 + 1 + 2 + 3 + 4


 */