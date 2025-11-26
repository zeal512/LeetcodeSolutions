class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int group = 1;
        int[] groups = new int[n];
        int ptr = 0;
        boolean[] ans = new boolean[queries.length];
        groups[0] = group;
        for(int i=1; i< n; i++){
            if(nums[i] - nums[i-1] > maxDiff){
                group+=1;
                groups[i] = group;
            }else groups[i] = group;
        }
        for(int[] row : queries){
            int n1 = row[0];
            int n2 = row[1];
            if(groups[n1] == groups[n2]) ans[ptr++] = true;
            else ans[ptr++] = false;
        }
        return ans;
    }
}