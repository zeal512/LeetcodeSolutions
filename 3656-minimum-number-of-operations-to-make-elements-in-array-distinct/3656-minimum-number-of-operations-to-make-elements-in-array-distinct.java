class Solution {
    public int minimumOperations(int[] nums) {
        // Set<Integer> set = new HashSet<>();
        boolean[] track = new boolean[101];
        for(int i =nums.length-1; i>= 0; i--){
            /* if(set.contains(nums[i])){
                return i/3 +1;
            }
            set.add(nums[i]); */
            if(track[nums[i]]){
                return i/3 + 1;
            }
            track[nums[i]] = true;
        }
        return 0;
    }
}