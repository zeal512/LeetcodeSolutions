class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i< nums.length; i++){
            int index = Math.abs(nums[i]) -1;
            nums[index] = -Math.abs(nums[index]);
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i] > 0){
                list.add(i + 1);
            }
        }
        return list;
    }
}