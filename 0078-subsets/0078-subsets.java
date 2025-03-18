class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i< (1 << n); i++){
            list.add(new ArrayList<>());
            for(int j=0; j< nums.length; j++){
                if((i & (1<<j)) !=0 ){
                    list.get(i).add(nums[j]);
                }
            }
        }
        return list;
    }
}