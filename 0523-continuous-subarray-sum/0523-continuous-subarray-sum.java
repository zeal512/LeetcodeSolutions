class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        //brute force approach, O(n^2)
        /* for(int i = 0; i< nums.length -1; i++){
            int sum = nums[i];
            for(int j = i+1; j< nums.length; j++){
                sum += nums[j];
                if(sum % k == 0) return true;
            }
        }
        return false; */
        int preSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i =0; i< nums.length; i++){
            preSum += nums[i];
            int remainder = preSum % k;
            if(map.containsKey(remainder)){
                if(i - map.get(remainder) >=2) return true;
            } 
            else map.put(remainder, i);
        }
        return false;


    }
}