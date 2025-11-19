class Solution {
    public int findFinalValue(int[] nums, int original) {
        Set<Integer> unique = new HashSet<>();
        for(int num: nums){
            if(!unique.contains(num)) unique.add(num);
        }
        while(unique.contains(original)){
            original = original *2;
        }
        return original;
    }
}