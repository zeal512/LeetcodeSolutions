class Solution {
    private Set<List<Integer>> set;
    public List<List<Integer>> findSubsequences(int[] nums) {
         set = new HashSet<>();
        recursion(nums, new ArrayList<>(), 0);
        return new ArrayList(set);
    }
     public void recursion(int[] nums, List<Integer> list, int curr){
        if(list.size() >=2){
            set.add(new ArrayList(list));
        }
        for(int i=curr; i< nums.length; i++){
            if(list.size() == 0 || list.get(list.size()-1) <= nums[i]){
                list.add(nums[i]);
                recursion(nums, list, i+1);
                list.remove(list.size()-1);
            }
        }
     }
}