class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int longest = 0;
        for(int n :  nums){
            set.add(n);
        }
        for(int n :  set){
            if(!set.contains(n-1)){
                int current = n;
                int length = 1;
                while(set.contains(current + 1)){
                    current++;
                    length +=1;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}