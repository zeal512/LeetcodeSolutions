class Solution {
    public int minSubarray(int[] nums, int p) {
        long arraySum = 0;
        int n = nums.length;
        for(int num: nums) arraySum+=num;
        int remainder = (int)(arraySum % p);
        if(remainder == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        long sum = 0; 
        int minSize = n;
        
        for(int i=0; i< n; i++){
            sum = (sum + nums[i]) % p;
            int requiredDifference = (int)((sum - remainder + p)%p);
            if(map.containsKey(requiredDifference)){
                minSize = Math.min(minSize,i- map.get(requiredDifference));
            }
            map.put((int)sum, i);
        }
        return minSize == n ? -1 : minSize ;
    }
}