class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];
        /* for(int i =0; i< nums.length; i++){
            int count=0;
            for(int j = 0; j< nums.length; j++){
                if(i != j && nums[j] < nums[i]){
                    count+=1;
                }
            }
            result[i] = count;
        } */
        
        Map<Integer, Integer> map = new HashMap<>();
        int[] sortedNum = nums.clone();
        Arrays.sort(sortedNum);

        for(int i =0; i < nums.length; i++){
            map.putIfAbsent(sortedNum[i], i);
        }
        for(int i =0; i < nums.length; i++){
            result[i] = map.get(nums[i]);
        }
        return result;
    }
}
/* 
[8,1,2,2,3]
[1,2,2,3,8]
[]
 */