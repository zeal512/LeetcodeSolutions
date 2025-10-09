class Solution {
    public int hIndex(int[] citations) {

        int arrSize = citations.length;
        int ans = 0;
        for(int i =0 ; i <=arrSize; i++){
            int papers = 0;
            for(int k =0; k< arrSize; k++){
                if(citations[k] >= i) papers++;
                if(papers >= i){
                    ans = Math.max(ans, i);
                    break;
                }
            }
        }
        return ans;
    }
}
