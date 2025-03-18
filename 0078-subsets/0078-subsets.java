class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        //using recursion
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> subSet = new ArrayList<>();
        findSubset(nums, 0, list, subSet);
        //Below commented code uses power set
        //int n = nums.length;
        // for(int i=0; i< (1 << n); i++){
        //     list.add(new ArrayList<>());
        //     for(int j=0; j< nums.length; j++){
        //         if((i & (1<<j)) !=0 ){
        //             list.get(i).add(nums[j]);
        //         }
        //     }
        // }
        return list;
    }
    public static void findSubset(int[] nums, int index, List<List<Integer>>  list, List<Integer> subSet){

        if(index == nums.length){
            list.add(new ArrayList<>(subSet));
            return;
        }
        subSet.add(nums[index]);
        findSubset(nums, index+1, list, subSet);

        subSet.remove(subSet.size() -1);
        findSubset(nums, index+1, list, subSet);
    }
}