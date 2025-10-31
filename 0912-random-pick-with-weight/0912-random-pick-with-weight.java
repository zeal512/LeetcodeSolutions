class Solution {
    List<Integer> preSum = new ArrayList<>();
    public Solution(int[] w) {
        int sum = 0;
        for(int i=0; i<w.length; i++){
            sum+=w[i];
            preSum.add(sum);
        }
    }
    
    public int pickIndex() {
        Random random = new Random();
        int range = preSum.get(preSum.size()-1);
        int randomNum = random.nextInt(range) + 1;
        
        int low = 0, high = preSum.size()-1;
        while(low<= high){
            int mid = (low+high)/2;
            if(preSum.get(mid) == randomNum) return mid;
            else if(preSum.get(mid) >= randomNum) high = mid-1;
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