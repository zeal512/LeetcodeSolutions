class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int low = 1, high = position[n-1];
        while(low <= high){
            int mid = low + ((high - low)/2);
            if(isPossible(mid, position, m)){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return high;
    }
    public boolean isPossible(int currForce, int[] position, int totalBalls){
        int countBalls = 1, lastPosition = position[0];
        for(int i =1; i < position.length; i++){
            if(position[i] - lastPosition >= currForce){
                countBalls+=1;
                lastPosition = position[i];
            }
            if(countBalls >= totalBalls) return true;
        }
        return false;
    }
}