class Solution {
    public int maximizeSweetness(int[] sweetness, int k) {
        int low = Integer.MAX_VALUE, high = 0;
        for(int i =0; i< sweetness.length; i++){
            low = Math.min(low, sweetness[i]);
            high += sweetness[i];
        }

        while(low <= high){
            int avg = low + ((high - low)/2);
            
            if(totalPiecesPossible(sweetness, avg, k)){
                low = avg +1;
            }
            else{
                high = avg-1;
            }
        }
        return high;
    }
    public boolean totalPiecesPossible(int[] sweetness, int maxSweetness, int k){
        
        int totalPieces = 0, sweetSum = 0;
        for(int i =0; i < sweetness.length; i++){
            sweetSum += sweetness[i];
            if(sweetSum >= maxSweetness){
                totalPieces +=1;
                sweetSum = 0;
            }
        }
        return totalPieces >=k+1;
    }
}

/* 
if 0 friends, sum(sweetness) will be answer
if sweetness.length == k+1, then min(sweetness) will be answer
so, to find out size of piece, out range should be between min(sweetness) to high = sum(sweetness)

*/