class Solution {
    public int countHillValley(int[] nums) {
        int hillsOrVally =0;
        List<Integer> unique = new ArrayList<>();
        unique.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] != nums[i]) {
                unique.add(nums[i]);
            }
        }
        for (int i = 1; i < unique.size()-1; i++) {
            if ((unique.get(i) > unique.get(i-1) &&  unique.get(i) > unique.get(i+1)) || 
                (unique.get(i) < unique.get(i-1) &&  unique.get(i) < unique.get(i+1) ) ) {
                hillsOrVally++;
            }
        }
        return hillsOrVally;
    }
}