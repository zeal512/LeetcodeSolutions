class Solution {
    public int findMaxLength(int[] nums) {
        //if(nums.length < 2) return 0;
        int sum =0, maxLength = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                sum -=1;
            }
            else{
                sum +=1;
            }
            if(map.containsKey(sum)){
                maxLength = Math.max(maxLength, i - map.get(sum));
            }
            else map.put(sum,i);
        }
        return maxLength;
    }
}