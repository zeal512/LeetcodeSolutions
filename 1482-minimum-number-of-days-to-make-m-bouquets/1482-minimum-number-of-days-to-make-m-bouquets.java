class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        
        if(bloomDay.length < (long) m * k) return -1;
        int minDays = Integer.MAX_VALUE, maxDays = Integer.MIN_VALUE;
        for(int i =0; i< bloomDay.length; i++){
            minDays = Math.min(bloomDay[i] , minDays);
            maxDays = Math.max(bloomDay[i], maxDays);
        }
        // for(int i = minDays; i <= maxDays; i++){
        //     if(isPossible(bloomDay, m, k, i)) return i;
        // }
        while (minDays <= maxDays) {
            int day = minDays + ((maxDays - minDays)/2);
            if(isPossible(bloomDay, m, k, day)){
                maxDays = day-1;
            }
            else{
                minDays = day+1;
            }
        }
        return minDays;
    }

    public boolean isPossible(int[] bloomDay, int m, int k, int days){
        int maxBouquets = 0;
        for(int i =0; i < bloomDay.length; i++){
            int flowersBloomed = 0;
            while(i < bloomDay.length && days >= bloomDay[i]){
                flowersBloomed+=1;
                i+=1;
            }
            if(flowersBloomed >= k){
                maxBouquets = maxBouquets + (flowersBloomed/k);
            }
        }
        if(maxBouquets >= m) return true;
        return false;
    }
}