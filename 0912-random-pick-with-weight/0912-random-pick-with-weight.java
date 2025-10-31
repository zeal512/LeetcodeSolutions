class Solution {
    private final Random random = new Random();;
    private final int[] prefixSum;
    private final int total;
    public Solution(int[] w) {
        prefixSum = new int[w.length];
        int sum = 0;
        for(int i=0; i<w.length; i++){
            sum+=w[i];
            prefixSum[i] = sum;
        }
        total = sum;
    }
    
    public int pickIndex() {
        int randomNum = random.nextInt(total) + 1;
        int low = 0, high = prefixSum.length-1;
        while(low<= high){
            int mid = (low+high)/2;
            if(prefixSum[mid] == randomNum) return mid;
            else if(prefixSum[mid] >= randomNum) high = mid-1;
            else low = mid+1;
        }
        return low;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */