class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int minDistance = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        
        /* for(int i =0; i <nums.length; i++){
            map.putIfAbsent(nums[i], i);
        } */ 
        for(int i =0; i < nums.length; i++){
            int revNum = reverse(nums[i]);
            if(map.containsKey(nums[i])){
                int j = map.get(nums[i]);
                minDistance = Math.min(minDistance, i - j);
            }
            map.put(revNum, i);
        }
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    public int reverse(int num){
        int n = 0;
        while(num > 0){
            n = (n*10) + num%10;
            num = num/10;
        }
        return n;
    }
}