class Solution {
    public int repeatedNTimes(int[] nums) {
        // Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i< nums.length; i++){
            // if(nums[i] == nums[i-1]) return nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if(map.get(nums[i]) > 1 ) return nums[i];
        }
        return 0;
    }
}