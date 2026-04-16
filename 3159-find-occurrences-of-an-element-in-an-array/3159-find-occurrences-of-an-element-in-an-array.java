class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        List<Integer> occurance = new ArrayList<>();
        for(int i =0; i< nums.length; i++){
            if(nums[i] == x) occurance.add(i);
        }
        int[] mapping = new int[queries.length];
        int maxOccuracne = occurance.size(), mapPtr = 0;
        for(int num : queries){
            if(num <= maxOccuracne) mapping[mapPtr++] = occurance.get(num-1);
            else mapping[mapPtr++] = -1;
        }
        return mapping;
    }
}

/*  
nums = [1,3,1,7], queries = [1,3,2,4], x = 1

ans = [0,-1,2,-1]
list {0,2}

*/