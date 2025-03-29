class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left =1, right = findMaxBananasInPile(piles);
        long minSpeed = right;
        while(left <= right){
            int speed = left + (right - left) /2;
            long maxHours = calculateTime(speed, piles);
            if(maxHours <= h){
                minSpeed = speed;
                right = speed -1;
            }
            else{
                left = speed +1;
            }
        }
        return (int)minSpeed;
    }

    public static int findMaxBananasInPile(int[] piles){
        int max =piles[0]; 
        for(int i=0; i< piles.length; i++){
            max = Math.max(max, piles[i]);
        }
        return max;
    }
    
    public static long calculateTime(int speed, int[] piles){
        long time =0; 
        for (int pile : piles) {
            time += (pile + speed - 1L) / speed;
        }
        return time;
    }
}