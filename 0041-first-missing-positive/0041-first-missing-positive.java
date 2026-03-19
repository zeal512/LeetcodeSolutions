class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;        
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
        return n+1;
    }
}


/* 
[3,5,1]
sum = -9
- 9 + 1 + 2 + 3 + 4


 */